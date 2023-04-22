package demo;

import ecomm.Globals;
import ecomm.Product;
import ecomm.Globals.Category;

public class Mobile extends Product {

    private String name, productID;
    private int price, quantity;

    public Mobile(String name, String productID, int price, int quantity) {
        this.name = name;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public Category getCategory() { // Setters and getters
        return Globals.Category.Mobile;
    }

    @Override
    public String getName() {
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
