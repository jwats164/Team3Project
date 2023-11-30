package Application.Inventory;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.sql.Blob;

public class InventoryItem {

    private String item;


    public void setItem(String item) {
        this.item = item;
    }

    public JButton button;

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    private String name;
    private String description;
    private double price;
    private Blob imageBlob;

    private byte[] imageBytes;

    // ... other methods, getters, setters

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Blob getImageBlob() {
        return imageBlob;
    }

    public void setImageBlob(Blob imageBlob) {
        this.imageBlob = imageBlob;
    }

    // method that converts the BLOB to ImageIcon


    // Method to convert an InventoryItem to an Object array (for table model)
    public Object[] toObjectArray(){
        return new Object[]{item, name, price, description};
    }


}




