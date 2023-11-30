package Application.SignUp;

import Application.DatabaseConnection;
import Application.Login.LoginPage;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SignUpPage {
    private JLabel appName;
    private JLabel signUpLabel;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JTextField confirmPasswordTextField;
    private JButton signUpButton;
    private JButton backToLoginPage;
    private JPanel signUpPanel;
    private JTextField emailTextField;

    public static JFrame signUpPageFrame;


    public JPanel getSignUpPanel() {
        return signUpPanel;
    }

    // This method checks if the password is at least 6 characters
    public static boolean validPassword(String password){
        return password.length() >= 6;
    }

    public static boolean confirmPasswordMatch(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }

    // TODO: Checks the database to see if there is someone with the same username and password
    public static boolean userAlreadyExist(String username, String password){
        return LoginPage.userExistInDatabase(username, password);
    }

    // TODO: Inserts user into database
    public static void insertUser(String email, String username, String password){
        addUserToDatabaseHelper(email, username, password, false, DatabaseConnection.connect());
    }


    // TODO: Creates a new row in the database with the passed in values (sets isAdmin to false)
    public static void addUserToDatabaseHelper(String email,String username, String password, boolean isAdmin, Connection con){
        try{
            String sql = "INSERT INTO User(username, password, isAdmin, email) VALUES(?, ?, ?,?)";
            try(PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setBoolean(3, isAdmin);
                ps.setString(4, email);
                ps.execute();
            }
        }catch(SQLException e){
            System.out.println("Error inserting data");
        }


    }

    SignUpPage() {

        // When the back to login button is clicked it closes the sign-up page and renders the login page
        backToLoginPage.addActionListener(e -> {
            LoginPage.createAndShowGUI();
            LoginPage.closePage(signUpPageFrame);
        });

        signUpButton.addActionListener(e ->{
            // Grab the username and passwords
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();
            String confirmPassword = confirmPasswordTextField.getText();
            String email = emailTextField.getText();
            // Check if the password are valid
            if(!validPassword(password)){
                JOptionPane.showMessageDialog(signUpPageFrame, "Password must be at least 6 characters!");
            }
            if(!confirmPasswordMatch(password, confirmPassword)){
                JOptionPane.showMessageDialog(signUpPageFrame, "Passwords do not match!");
            }

            // Check if the username and password is already in the database
            if(userAlreadyExist(username, password) && confirmPasswordMatch(password, confirmPassword)){
                JOptionPane.showMessageDialog(signUpPageFrame, "User already exist!");
            }

            // if the passwords are valid then add the user to the database
            if(validPassword(password) && confirmPasswordMatch(password, confirmPassword) && !userAlreadyExist(username, password)){
                insertUser(email ,username, password);
                JOptionPane.showMessageDialog(signUpPageFrame, "You're in the database!");
            }

        });

        // Set the color for the button
        signUpButton.setContentAreaFilled(false);
        signUpButton.setForeground(Color.GREEN);




    }

    public static void createAndShowGUI(){
        // Set up the main frame
        SignUpPage.signUpPageFrame = new JFrame("Sign Up Page");
        SignUpPage.signUpPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SignUpPage.signUpPageFrame.setSize(1300, 700);

        // Create an instance of GUI class
        SignUpPage signUpPage = new SignUpPage();

        // Set up the layout and add components
        SignUpPage.signUpPageFrame.add(signUpPage.getSignUpPanel(), BorderLayout.CENTER);

        // Make the frame visible
        SignUpPage.signUpPageFrame.setVisible(true);
    }


}
