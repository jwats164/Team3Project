package Application.Inventory;

import Application.Cart.Cart;
import Application.Cart.CartPage;
import Application.DatabaseConnection;
import Application.Home.HomePage;
import Application.Login.LoginPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashSet;
import java.util.List;

public class InventoryPage {
    private  JPanel inventoryPanel;
    private JTable inventoryTable;
    private JLabel appName;
    private JLabel inventoryItemsLabel;
    private JScrollPane scrollPane;
    private JButton addToCartButton;
    private JLabel directionsLabel;
    private JButton viewCartButton;
    private JButton backToHomeButton;
    private JButton checkoutButton;





    public static JFrame inventoryPageJframe;

    public static List<InventoryItem> inventoryItems;

    //DefaultTableModel model = (DefaultTableModel) inventoryTable.getModel();

    public JPanel getInventoryPanel() {
        return inventoryPanel;
    }

    private void initializeUI(List<InventoryItem> inventoryItems){
        //inventoryTable.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };

        //model.setColumnCount(0);

        model.addColumn("Item");
        model.addColumn("Name");

        model.addColumn("Price");
        model.addColumn("Description");


        for(InventoryItem item: inventoryItems){
            model.addRow(item.toObjectArray());
        }

        inventoryTable.setModel(model);
        inventoryTable.setRowHeight(50);



        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


    }




    public static HashSet<Integer> set = new HashSet<>();


    InventoryPage(){
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        inventoryItems = DatabaseConnection.getInventoryItems();

        initializeUI(inventoryItems);

        addToCartButton.addActionListener(e ->{
            int selectedRow = inventoryTable.getSelectedRow() + 1;

            if(selectedRow != -1 && set.add(selectedRow)){
                String item = (String) inventoryTable.getValueAt(selectedRow -1, 0);

                char charInventoryId = item.charAt(item.length()-1);

                int inventoryId = Integer.parseInt(String.valueOf(charInventoryId));

                Cart.itemsInCart.add(DatabaseConnection.getInventoryItemById(inventoryId));

                JOptionPane.showMessageDialog(inventoryPageJframe, "Item Successfully Added to Cart!");
            }
            else{
                JOptionPane.showMessageDialog(inventoryPageJframe, "Item already in Cart! ");
            }
        });

        viewCartButton.addActionListener(e ->{
            CartPage.createAndShowGUI();
            LoginPage.closePage(inventoryPageJframe);
        });

        backToHomeButton.addActionListener(e ->{
            HomePage.createAndShowGUI();
            LoginPage.closePage(inventoryPageJframe);
        });


    }

    public static void createAndShowGUI(){
        // Log the User in
        inventoryPageJframe = new JFrame("Home Page");
        inventoryPageJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inventoryPageJframe.setSize(1300, 700);

        inventoryPageJframe.getContentPane().setBackground(Color.WHITE);

        // Create an instance of GUI class

        InventoryPage inventoryPage = new InventoryPage();


        // Set up the layout and add components
        inventoryPageJframe.add(inventoryPage.getInventoryPanel(), BorderLayout.CENTER);



        // Make the frame visible
        inventoryPageJframe.setVisible(true);
    }


}
