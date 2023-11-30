package Application.Cart;

import Application.DatabaseConnection;
import Application.Inventory.InventoryItem;
import Application.Inventory.InventoryPage;
import Application.Login.LoginPage;
import Application.Purchase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CartPage {
    private JLabel cartOverviewLabel;
    private JLabel itemsInCartLabel;
    private JScrollPane scrollPane;
    private JTable itemsInCartTable;
    private JPanel cartPanel;
    private JButton backToInventoryPage;
    private JButton deleteItemFromCart;
    private JLabel directionsLabel;
    private JButton checkOutButton;
    private JLabel totalPriceLabel;

    public static double totalPrice = 0;

    public JPanel getCartPanel() {
        return cartPanel;
    }

    public static JFrame cartJFrame;

    CartPage(){
        initializeUI(Cart.itemsInCart);

        backToInventoryPage.addActionListener(e ->{
            InventoryPage.createAndShowGUI();
            LoginPage.closePage(cartJFrame);
        });

        deleteItemFromCart.addActionListener(e ->{
            int selectedRow = itemsInCartTable.getSelectedRow();
            model.removeRow(selectedRow);

            JOptionPane.showMessageDialog(cartJFrame, "Item Removed");

            calculatePrice(itemsInCartTable);

        });

        checkOutButton.addActionListener(e ->{
            Purchase.createAndShowGUI();
            LoginPage.closePage(cartJFrame);
        });


    }

    static DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };


    private void initializeUI(HashSet<List<InventoryItem>> a){
        totalPriceLabel.setText("<html><font size = '5'> Item(s) SubTotal: $"+ DatabaseConnection.priceTotal + "</font><html>");


        model.addColumn("Item");
        model.addColumn("Name");

        model.addColumn("Price");
        model.addColumn("Description");



        Iterator<List<InventoryItem>> it = a.iterator();
        for(int i = 0; i < a.size(); i++){
            while(it.hasNext()){
                model.addRow(it.next().get(i).toObjectArray());
                calculatePrice(itemsInCartTable);
            }
        }

        itemsInCartTable.setModel(model);
        itemsInCartTable.setRowHeight(50);






        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


    }

    public static void calculatePrice(JTable table){
        double curr = 0;
        for(int i = 0; i < table.getRowCount(); i++){
            curr += (double) table.getValueAt(i, 2);

        }

        totalPrice = curr;
    }




    public static void createAndShowGUI(){
        // Log the User in
        cartJFrame = new JFrame("Home Page");
        cartJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cartJFrame.setSize(1300, 700);

        cartJFrame.getContentPane().setBackground(Color.WHITE);

        // Create an instance of GUI class


        CartPage cartPage = new CartPage();


        // Set up the layout and add components
        cartJFrame.add(cartPage.getCartPanel(), BorderLayout.CENTER);



        // Make the frame visible
        cartJFrame.setVisible(true);
    }
}
