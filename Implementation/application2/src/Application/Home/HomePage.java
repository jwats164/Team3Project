package Application.Home;

import Application.Account.AccountPage;
import Application.Cart.CartPage;
import Application.CheckOut.CheckOutPage;
import Application.Inventory.InventoryPage;
import Application.Login.LoginPage;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HomePage {
    private JPanel homePagePanel;
    private JTabbedPane tabbedPane1;
    private JLabel appName;
    private JLabel shortenAppName;
    private JButton checkInventoryButton;
    private JLabel redLamboImage;
    private JTable exampleTable;
    private JLabel leftCornerLabel;
    private JLabel middleBottomLabel;
    private JLabel bottomRightLabel;
    private JButton shoppingCartButton;
    private JButton accountButton;
    private JLabel aboutUsLabel;
    private JLabel creatorsLabel;
    private JScrollPane scrollPane;


    public static JFrame homePageFrame;




    HomePage() {
        // table data for homepage

        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //DefaultTableModel model = (DefaultTableModel) exampleTable.getModel();
        Object[][] rowData = {
                {"1:64", "Toyota", "Die-Cast Metal"},
                {"1:43", "Audi", "Plastic"},
                {"1:24", "Lamborghini", "Resin"},
                {"1:18", "Bugatti", "Metal"},
                {"1:14", "Maserati", "Wood"},
                {"1:12", "Cadillac", "Steel"}
        };

        Object[] columnNames = {"Scales", "Car Brand", "Material"};



        model.setDataVector(rowData, columnNames);

        exampleTable.setModel(model);
        exampleTable.setRowHeight(50);

        // Show column names
        exampleTable.getTableHeader().setVisible(true);

        // Set autoResizeMode to adjust columns to fit available space
        exampleTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);




        // text for the labels on the bottom of the page
        leftCornerLabel.setText("<html> <b>Shipping</b><br/>We offer overnight<br/>ground, and 3-day shipping</html>");
        middleBottomLabel.setText("<html><b>Exclusivity</b><br/> Our models are one of one<br/>once it has been purchased, it's gone</html>");
        bottomRightLabel.setText("<html><b>Refund</b><br/> If your model arrives damaged<br/> we offer refunds within 3 weeks of purchase</html>");


        //Text for about us page
        aboutUsLabel.setText("<html><font size = '6'> <b>About Us </b> </font> <br/> <font size = '4'> Welcome to Mini-Mobile! Here we sell unique, one-of-a kind miniature model cars.<br/> You will not find model cars like this anywhere else.<br/><br/> We guarantee the best services on your order.</font></html>");

        creatorsLabel.setText("<html> <font size = '4'> Application made by: Heriberto Contreas, Joseph Ohanu, Adam Tucker, Joshua Watson </font></html>");

        // Account Button
        accountButton.addActionListener(e ->{
            AccountPage.createAndShowGUI();
            LoginPage.closePage(homePageFrame);
        });


        // Inventory Button
        checkInventoryButton.addActionListener(e ->{
            InventoryPage.createAndShowGUI();
            LoginPage.closePage(homePageFrame);
        });

        shoppingCartButton.addActionListener(e -> {
            //CheckOutPage checkOutPage = new CheckOutPage(); //Can't make it static
            //checkOutPage.createAndShowGUI();
            CartPage.createAndShowGUI();
            LoginPage.closePage(homePageFrame);
        });

        // Search Button
        searchButton.addActionListener(e ->{
            String searchText = searchBar.getText().trim();
            if(!searchText.equals("")) //Will not search if no text is entered
            {
                InventoryPage.createAndShowGUI();
                LoginPage.closePage(homePageFrame);
            }
        });

    }

    public JPanel getHomePagePanel() {
        return homePagePanel;
    }


    public static void createAndShowGUI(){
        // Log the User in
        homePageFrame = new JFrame("Home Page");
        homePageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homePageFrame.setSize(1300, 700);

        homePageFrame.getContentPane().setBackground(Color.WHITE);

        // Create an instance of GUI class

        HomePage homePage = new HomePage();


        // Set up the layout and add components
        homePageFrame.add(homePage.getHomePagePanel(), BorderLayout.CENTER);



        // Make the frame visible
        homePageFrame.setVisible(true);
    }



}
