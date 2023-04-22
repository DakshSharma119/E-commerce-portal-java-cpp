import java.util.*;
import demo.DemoPlatform;
import demo.Seller1;
import demo.Seller2;
import demo.Seller3;
import ecomm.*;

public class PlatformMain {

	public static void main(String[] args) {

		Platform pf = new DemoPlatform(); // replace with appropriate derived class

		// create a number of sellers (of different sub-types of Seller)
		// Assign a name (sellerID) to each of them.

		// replace each of the XYZ below with the derived class name of one of the
		// team members.

		Seller s1 = new Seller1("Seller1");
		s1.addPlatform(pf);
		pf.processRequests();
		Seller s2 = new Seller2("Seller2");
		s2.addPlatform(pf);
		Seller s3 = new Seller3("Seller3");
		s3.addPlatform(pf);

		// Seller s3 = new SellerXYZ2("Seller3");
		// s1.addPlatform(pf);

		/*
		 * // keep reading from System.in
		 * // If "Check" typed in
		 * // invoke
		 * pf.processRequests();
		 */
		Scanner sc = new Scanner(System.in);
		while (true) {
			String s = sc.nextLine();
			if (s.equals("Check")){
			pf.processRequests();
		}
		}
	}

}
