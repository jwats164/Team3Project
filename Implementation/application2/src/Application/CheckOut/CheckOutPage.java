package Application.CheckOut;

import Application.Account.AccountPage;
import Application.Home.HomePage;
import Application.Login.LoginPage;

import javax.swing.*;
import java.awt.*;

public class CheckOutPage {
    private JLabel applicationTitle;
    private JButton homePage;
    private JButton aboutPage;
    private JButton profilePage;
    private JRadioButton freeShipping;
    private JRadioButton threeDayShipping;
    private JRadioButton overNightShipping;
    private JButton next;
    private JTable cartInformation;
    private JTextField address;
    private JTextField zipCode;
    private JTextField phoneNumber;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField city;
    private JTextField state;
    private JTextField email;
    private JTextField cardNumber;
    private JTextField expDate;
    private JTextField cvv;
    public JFrame checkOutPageFrame;
    public JPanel checkoutPage;

    ButtonGroup shippingTypes = new ButtonGroup();

    public CheckOutPage(){

    }
    public void createAndShowGUI(){

        checkOutPageFrame = new JFrame();
        checkoutPage = new JPanel();
        checkOutPageFrame.add(checkoutPage);

        checkoutPage.setPreferredSize(new Dimension(1300, 700));

        //Picking the layout for the panel
        checkoutPage.setLayout(new BorderLayout());

        //adding components to the top bar
        JPanel topButtons = new JPanel(new FlowLayout());
        applicationTitle = new JLabel("Mini-Mobile");
        topButtons.add(applicationTitle);
        homePage = new JButton("Home");
        topButtons.add(homePage);
        homePage.addActionListener(e -> {
            HomePage.createAndShowGUI();
            LoginPage.closePage(checkOutPageFrame);
        });
        aboutPage = new JButton("About");
        topButtons.add(aboutPage);
        aboutPage.addActionListener(e -> {
            HomePage.createAndShowGUI();
            LoginPage.closePage(checkOutPageFrame);
        });
        profilePage = new JButton("Profile");
        topButtons.add(profilePage);
        profilePage.addActionListener(e -> {
            AccountPage.createAndShowGUI();
            LoginPage.closePage(checkOutPageFrame);
        });

        //adding components to the bottom bar
        JPanel bottomButtons = new JPanel(new FlowLayout());
        freeShipping = new JRadioButton("Free Shipping");
        threeDayShipping = new JRadioButton("3-Day Shipping");
        overNightShipping = new JRadioButton("Overnight Shipping");
        shippingTypes.add(freeShipping);
        shippingTypes.add(threeDayShipping);
        shippingTypes.add(overNightShipping);
        bottomButtons.add(freeShipping);
        bottomButtons.add(threeDayShipping);
        bottomButtons.add(overNightShipping);
        next = new JButton("FINISH PAYMENT");
        bottomButtons.add(next);
        next.addActionListener(e -> {
            //action when pressed
            int confirmation = confirmation();
            //TODO if yes then invoice if no then nothing
        });

        //Adding the Shipping Information
        JPanel centerFilloutForm = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        //gbc.weights = 1
        firstName = new JTextField("First Name");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        centerFilloutForm.add(firstName, gbc);

        lastName = new JTextField("Last Name");
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        centerFilloutForm.add(lastName, gbc);

        address = new JTextField("Address");
        gbc.gridy = 2;
        centerFilloutForm.add(address, gbc);

        city = new JTextField("City");
        gbc.gridy = 3;
        centerFilloutForm.add(city, gbc);

        state = new JTextField("State");
        gbc.gridy = 4;
        centerFilloutForm.add(city, gbc);

        zipCode = new JTextField("ZIP code");
        gbc.gridy = 5;
        centerFilloutForm.add(zipCode, gbc);

        phoneNumber = new JTextField("Phone Number");
        gbc.gridy = 6;
        centerFilloutForm.add(phoneNumber, gbc);

        email = new JTextField("Email");
        gbc.gridy = 7;
        centerFilloutForm.add(email, gbc);

        //Adding the Payment Information
        JPanel eastFilloutForm = new JPanel(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        cardNumber = new JTextField("Card Number");
        gbc2.gridy = 0;
        gbc2.gridx = 0;
        eastFilloutForm.add(cardNumber, gbc2);

        expDate = new JTextField("Exp Date: MM/YY");
        gbc2.gridy = 1;
        eastFilloutForm.add(expDate, gbc2);

        cvv = new JTextField("cvv");
        gbc2.gridy = 2;
        eastFilloutForm.add(cvv, gbc2);



        //Adding the sub Panel to main Panel
        cartInformation = new JTable();
        checkoutPage.add(eastFilloutForm, BorderLayout.EAST);
        checkoutPage.add(centerFilloutForm, BorderLayout.CENTER);
        checkoutPage.add(cartInformation, BorderLayout.WEST);
        checkoutPage.add(topButtons, BorderLayout.NORTH);
        checkoutPage.add(bottomButtons, BorderLayout.SOUTH);

        checkOutPageFrame.pack();
        checkOutPageFrame.setVisible(true);

    }

    public int confirmation(){
        return JOptionPane.showConfirmDialog(null, "Do you want to continue with this purchase?", "Confirmation", JOptionPane.YES_NO_OPTION);
    }

}
