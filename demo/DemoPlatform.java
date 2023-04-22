package demo;

import ecomm.*;
import java.io.*;
import java.util.*;

public class DemoPlatform extends Platform {

  private ArrayList<Seller> sellers = new ArrayList<>(); // Array List to Store Sellers

  @Override
  public boolean addSeller(Seller aSeller) { // Add seller method
    sellers.add(aSeller);
    return false;
  }

  @Override
  public void processRequests() {
    try {
      File myFile = new File(Globals.toPlatform);
      FileWriter fileWriter = new FileWriter(Globals.fromPlatform, true); // FileHandling
      Scanner sc = new Scanner(myFile);
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String arr[] = line.split(" ");
        if (!requests.containsKey(arr[1])) {
          requests.put(arr[1], 1);
          if (arr[2].equals("List")) {
            // System.out.println("Read file list");
            ArrayList<Product> products = new ArrayList<>(); // contains product list
            if (arr[3].equals("Book")) {
              for (int i = 0; i < sellers.size(); i++) {
                products.addAll(
                    sellers.get(i).findProducts(Globals.Category.Book)// Access book.java
                );
              }
            } else {
              for (int i = 0; i < sellers.size(); i++) {
                products.addAll(
                    sellers.get(i).findProducts(Globals.Category.Mobile) // Access Mobile.java
                );
              }
            }

            // Write list
            for (int i = 0; i < products.size(); i++) {
              Product p = products.get(i);
              // System.out.println(arr[0]+" "+arr[1]+" "+p.getName()+" "+p.getProductID()+"
              // "+p.getPrice()+" "+p.getQuantity());
              fileWriter.append(arr[0] + " " + arr[1] + " " + p.getName() + " " + p.getProductID() + " " + p.getPrice()
                  + " " + p.getQuantity());
              fileWriter.write('\n'); // FileWriter
            }

          } else if (arr[2].equals("Buy")) {
            // System.out.println("Buy request");
            boolean ans = false;
            for (int i = 0; i < sellers.size(); i++) {
              ans = sellers.get(i).buyProduct(arr[3], Integer.parseInt(arr[4]));
              if (ans) {
                break;
              }
            }
            // Write ans
            if (ans) {
              fileWriter.append(arr[0] + " " + arr[1] + " " + "Success ");
              // System.out.println(arr[0]+" "+arr[1]+" "+"Failure");
              fileWriter.write('\n');

            } else {
              // System.out.println(arr[0]+" "+arr[1]+" "+"Failure");
              fileWriter.append(arr[0] + " " + arr[1] + " " + "Failure ");
              fileWriter.write('\n');

            }
          } else if (arr[2].equals("Start")) {
            Globals g = new Globals();
            fileWriter.append(arr[0] + " " + arr[1]);
            for (Globals.Category s : Globals.Category.values()) { // Start writing on a file
              fileWriter.append(" " + g.getCategoryName(s));
            }
            fileWriter.write(" " + '\n');
          }
        } else {
          continue;
        }

      }
      fileWriter.close();
      sc.close();

    } catch (FileNotFoundException e1) {
      // System.out.println("Scanner err"); // Exception Handling
      e1.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  HashMap<String, Integer> requests = new HashMap<String, Integer>(); // Hash Map Duplicates for stable sort
}
