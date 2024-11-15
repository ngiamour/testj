import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Product {
    protected String title;
    protected String description;
    protected double price;
    protected String category;
    protected String subcategory;
    protected double availableQuantity;

    public Product(String title, String description, double price, String category, String subcategory, double availableQuantity) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.subcategory = subcategory;
        this.availableQuantity = availableQuantity;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getSubcategory() {
        return subcategory;
    }
    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
    public double getAvailableQuantity() {
        return availableQuantity;
    }
    public void setAvailableQuantity(double availableQuantity) {
        this.availableQuantity = availableQuantity;
    }


    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("products.txt", true))) {
            writer.write(this.toCustomString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving product to file: " + e.getMessage());
        }
    }

    // Προσαρμοσμένο `toString` για την επιθυμητή μορφοποίηση
    public String toCustomString() {
        return "Τίτλος: " + title + "\n" +
                "Περιγραφή: " + description + "\n" +
                "Κατηγορία: " + category + "\n" +
                "Υποκατηγορία: " + subcategory + "\n" +
                "Τιμή: " + String.format("%.2f€", price) + "\n" +
                "Ποσότητα: " + availableQuantity + "kg\n";
    }
}

