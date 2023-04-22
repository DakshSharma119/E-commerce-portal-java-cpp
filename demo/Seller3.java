//IMPLEMENTED BY IMT2021533 (Daksh Sharma)

package demo;

import java.util.ArrayList;

import ecomm.Globals;
import ecomm.Platform;
import ecomm.Product;
import ecomm.Seller;
import ecomm.Globals.Category;

public class Seller3 extends Seller {

    Product book1 = new Book("IMT2021533_A", "S3_Chernobyl", 543, 45);
    Product book2 = new Book("IMT2021533_B", "S3_EndofWorld", 100, 89);
    Product book3 = new Book("IMT2021533_C", "S3_Divergent", 1901, 50);
    Product mob1 = new Mobile("IMT2021533_D", "S3_Samsung", 40000, 77);
    Product mob2 = new Mobile("IMT2021533_E", "S3_Iphone", 41003, 800);
    private ArrayList<Product> books = new ArrayList<>();
    private ArrayList<Product> mobiles = new ArrayList<>();

    // Same comments as Seller 1
    public Seller3(String id) {
        super(id);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        mobiles.add(mob1);
        mobiles.add(mob2);
    }

    public void addPlatform(Platform thePlatform) {
        thePlatform.addSeller(this);
    }

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
            if (p.getProductID().equals(productID)) {
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
