//IMPLEMENTED BY IMT2021014 (Karan Raj Pandey)
package demo;

import java.util.ArrayList;

import ecomm.Globals;
import ecomm.Platform;
import ecomm.Product;
import ecomm.Seller;
import ecomm.Globals.Category;

public class Seller1 extends Seller { // Entering Data Manually

    Product book1 = new Book("IMT2021014_A", "S1_Chernobyl", 1000, 4);
    Product book2 = new Book("IMT2021014_B", "S1_BadHabbits", 99, 32);
    Product book3 = new Book("IMT2021014_C", "S1_AliBaba", 2012, 6);
    Product mob1 = new Mobile("IMT2021014_D", "S1_Nokia", 20000, 17);
    Product mob2 = new Mobile("IMT2021014_E", "S1_Samsung", 70100, 40);
    private ArrayList<Product> books = new ArrayList<>();
    private ArrayList<Product> mobiles = new ArrayList<>();

    public Seller1(String id) {
        super(id);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        mobiles.add(mob1);
        mobiles.add(mob2); // Adding to Array List
    }

    public void addPlatform(Platform thePlatform) {
        thePlatform.addSeller(this);
    }

    // Doing Accordingly
    public ArrayList<Product> findProducts(Category whichOne) {
        ArrayList<Product> foundProducts = new ArrayList<>();
        if (whichOne.equals(Globals.Category.Book)) {
            for (int i = 0; i < books.size(); i++) {
                foundProducts.add(books.get(i));
            }
        } else {
            for (int i = 0; i < mobiles.size(); i++) {
                foundProducts.add(mobiles.get(i));
            }
        }
        return foundProducts;
    }

    public boolean buyProduct(String productID, int quantity) {
        for (int i = 0; i < books.size(); i++) {
            Product p = books.get(i);
            if (p.getProductID().equals(productID)) {
                if (p.getQuantity() >= quantity) {
                    p.updateQuantity(p.getQuantity() - quantity);
                    return true;
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < mobiles.size(); i++) {
            Product p = mobiles.get(i);
            // System.out.println("In Mobiles");
            if (p.getProductID().equals(productID)) {
                // System.out.println("Mobile found");
                if (p.getQuantity() >= quantity) {
                    p.updateQuantity(p.getQuantity() - quantity);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

}
