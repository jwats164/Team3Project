package Application;

import Application.Cart.Cart;
import Application.Inventory.InventoryItem;
import Application.Inventory.InventoryPage;

import javax.swing.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class DatabaseConnection {
    // This method connects to the database in the program
    public static Connection connect(){
        Connection con = null;
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:Database_Connection_Test.db");
            System.out.println("Connected!");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e + " ");
        }

        return con;
    }

    public static List<InventoryItem> getInventoryItems(){
        List<InventoryItem> inventoryItems = new ArrayList<>();




        try(Connection con = connect();
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM Inventory")){

            while (resultSet.next()){
                InventoryItem item = new InventoryItem();
                String curr = "Item: " + resultSet.getInt("inventoryId");
                item.setItem(curr);
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getDouble("price"));
                item.setDescription(resultSet.getString("description"));



                inventoryItems.add(item);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return inventoryItems;
    }

    public static double priceTotal;

    public static Queue<Integer> queue = new LinkedList<>() ;




    public static List<InventoryItem> getInventoryItemById(int inventoryId){
        List<InventoryItem> inventoryItems = new ArrayList<>();


        String query = "SELECT * FROM Inventory WHERE inventoryId = ?";
        InventoryItem inventoryItem;

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, inventoryId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Assuming InventoryItem has a constructor that takes ResultSet
                    inventoryItem = new InventoryItem();
                    String curr = "Item: " + resultSet.getInt("inventoryId");
                    queue.add(resultSet.getInt("inventoryId"));
                    inventoryItem.setItem(curr);
                    inventoryItem.setName(resultSet.getString("name"));
                    inventoryItem.setPrice(resultSet.getDouble("price"));
                    priceTotal = resultSet.getDouble("price");
                    inventoryItem.setDescription(resultSet.getString("description"));

                    //Cart.itemsInCart.add(inventoryItem);

                    inventoryItems.add(inventoryItem);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions as needed
        }
        return inventoryItems;
    }

    // Method to create a sale in the Sale table
    public static void createSale(int userId, int inventoryId, int shippingTypeId, double grandTotal) {
        // SQL query to insert a new sale
        String insertSaleQuery = "INSERT INTO Sales (userId, inventoryId, shippingTypeId, grandTotal, soldDate) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connect().prepareStatement(insertSaleQuery)) {
            // Set values for the parameters
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, inventoryId);
            preparedStatement.setInt(3, shippingTypeId);
            preparedStatement.setDouble(4, grandTotal);

            // Set the current date as the sale date
            Date currentDate = Date.valueOf(LocalDate.now());

            preparedStatement.setDate(5, currentDate);

            // Execute the SQL query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions that may occur during the database operation
        }
    }


}
