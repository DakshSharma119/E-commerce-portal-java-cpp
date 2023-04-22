package demo;

import ecomm.Globals;
import ecomm.Product;
import ecomm.Globals.Category;

public class Book extends Product {

    private String name, productID; // Data members
    private int quantity;
    private float price;

    public Book(String name, String productID, float price, int quantity) {
        this.name = name;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public Category getCategory() {
        return Globals.Category.Book; // Getpath
    }

    @Override
    public String getName() { // getters & setters
        return name;
    }

    @Override
    public String getProductID() {
        return productID;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    public void updateQuantity(int n) {
        this.quantity = n;
    }

}
