package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.app.core.Customer;

public class CollectionUtils {

	// HashMap<mobileNumber,Customer>
	public static HashMap<String, Customer> populateCustomers() {
		// Empty Hashmap
		HashMap<String, Customer> hm = new HashMap<String, Customer>();
		try {

			Customer c = new Customer("shweta", LocalDate.parse("2018-02-02"), "9689680148");
			// Add Last 6 Month bills in list<Integer>
			c.getBills().add("456");
			c.getBills().add("500");
			c.getBills().add("600");
			c.getBills().add("863");
			c.getBills().add("200");
			c.getBills().add("1000");

			hm.put("9689680148", c);

			// Second Customer

			Customer c1 = new Customer("Renu", LocalDate.parse("2018-02-02"), "9584680148");
			// Add Last 6 Month bills in list<Integer>
			c1.getBills().add("356");
			c1.getBills().add("500");
			c1.getBills().add("400");
			c1.getBills().add("763");
			c1.getBills().add("200");
			c1.getBills().add("100");

			hm.put("9584680148", c1);
			System.out.println("In Collection Utils");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hm;
	}

	public static String getCurrentMonthBill(String mobileNo, HashMap<String, Customer> hm) {
		Customer c = hm.get(mobileNo);
		int lastIndex = (c.getBills().size()) - 1;
		System.out.println("Last Index:" + lastIndex);
		String curBill = c.getBills().get(lastIndex);
		return curBill;
	}

	public static List<String> getLastSixMonthBill(String mobileNo, HashMap<String, Customer> hm) {
		Customer c = hm.get(mobileNo);

		return c.getBills();
	}

	public static String getMaxBill(HashMap<String, Customer> hm) {
		HashMap<String, Customer> hm1 = new HashMap<String, Customer>();
		for (Customer c : hm.values()) {

			String key = Collections.max(c.getBills());
			hm1.put(key, c);

		}
		String maxKey = Collections.max(hm1.keySet());
		return hm1.get(maxKey).getCustomerName();

	}

	public static String getCurrentMonthBillByDateAndName(String name, LocalDate date, HashMap<String, Customer> hm) {
		String curBill = null;
		for (Customer c : hm.values()) {
			if (name.equals(c.getCustomerName()) && date.equals(c.getBirtDate())) {
				
				//Last Added Elemtnt will be Current Month
				
				int lastIndex = (c.getBills().size()) - 1;
				System.out.println("Last Index:" + lastIndex);
				curBill = c.getBills().get(lastIndex);

			}
		}
		return curBill;
    }

}
