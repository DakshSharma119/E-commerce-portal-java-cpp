//IMPLEMENTED BY IMT2021522 (Divyansh Singhal)

package demo;

import java.util.ArrayList;

import ecomm.Globals;
import ecomm.Platform;
import ecomm.Product;
import ecomm.Seller;
import ecomm.Globals.Category;

public class Seller2 extends Seller {

    Product book1 = new Book("IMT2021522_A", "S2_DelhiCrime", 500, 56);
    Product book2 = new Book("IMT2021522_B", "S2_EndOfWorld", 1223, 1);
    Product book3 = new Book("IMT2021522_C", "S2_HarryPotter", 2, 32);
    Product mob1 = new Mobile("IMT2021522_D", "S2_Blackberry", 29023, 55);
    Product mob2 = new Mobile("IMT2021522_E", "S2_Iphone", 100004, 10);
    private ArrayList<Product> books = new ArrayList<>();
    private ArrayList<Product> mobiles = new ArrayList<>();

    // Same comments as Seller 1
    public Seller2(String id) {
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
