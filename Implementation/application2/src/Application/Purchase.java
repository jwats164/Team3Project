package Application;

import Application.Cart.Cart;
import Application.Cart.CartPage;
import Application.Home.HomePage;
import Application.Inventory.InventoryItem;
import Application.Login.LoginPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Purchase {
    private JLabel checkOutLabel;
    private JLabel itemsInCartLabel;
    private JScrollPane scrollPane;
    private JTable cartItemsTable;
    private JTextField cardNumber;
    private JTextField shippingAddress;
    private JTextField cardExDate;
    private JTextField CVV;
    private JTextField zipCode;
    private JTextField phoneNumber;
    private JLabel subTotalLabel;
    private JButton confrimOrderButton;
    private JCheckBox shippingTypeSelection;
    private JCheckBox a3DayCheckBox;
    private JCheckBox groundCheckBox;
    private JPanel purchasePanel;

    public static JFrame purchaseFrame;

    static DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };
    Purchase(HashSet<List<InventoryItem>> a){
        model.addColumn("Item");
        model.addColumn("Name");

        model.addColumn("Price");
        model.addColumn("Description");



        Iterator<List<InventoryItem>> it = a.iterator();
        for(int i = 0; i < a.size(); i++){
            while(it.hasNext()){
                model.addRow(it.next().get(i).toObjectArray());
                //calculatePrice(itemsInCartTable);
            }
        }

        cartItemsTable.setModel(model);
        cartItemsTable.setRowHeight(50);


        shippingTypeSelection.addActionListener(e->{
            DatabaseConnection.priceTotal += 29.00;
        });

        subTotalLabel.setText("<html><font size = '5'> Total: " + DatabaseConnection.priceTotal+ "</font></html>");

        confrimOrderButton.addActionListener(e ->{
            DatabaseConnection.createSale(LoginPage.currentUserId, DatabaseConnection.queue.poll(), 1, DatabaseConnection.priceTotal);
            JOptionPane.showMessageDialog(purchaseFrame, "Order Confirmed");
            HomePage.createAndShowGUI();
            LoginPage.closePage(purchaseFrame);
        });
    }

    public JPanel getPurchasePanel() {
        return purchasePanel;
    }

    public static void createAndShowGUI(){
        // Log the User in
        purchaseFrame = new JFrame("Home Page");
        purchaseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        purchaseFrame.setSize(1300, 700);

        purchaseFrame.getContentPane().setBackground(Color.WHITE);

        // Create an instance of GUI class


        Purchase purchase = new Purchase(Cart.itemsInCart);


        // Set up the layout and add components
        purchaseFrame.add(purchase.getPurchasePanel(), BorderLayout.CENTER);



        // Make the frame visible
        purchaseFrame.setVisible(true);
    }
}
