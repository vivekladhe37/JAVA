package tester;

import static utils.CollectionUtils.*;
import java.util.HashMap;
import java.util.List;

import com.app.core.Customer;
import java.io.*;
import java.net.*;
import java.time.LocalDate;

import static utils.SerIoUtils.*;

public class CellPhoneBilling {

	public static void main(String[] args) {

		System.out.println("Waiting for Client Connection!!");
		HashMap<String, Customer> hm = populateCustomers();

		System.out.println("All Customers Data:");
		for (Customer c : hm.values()) {
			System.out.println(c);
		}

		try (ServerSocket ss = new ServerSocket(5000, 1); Socket ds = ss.accept();) {

			System.out.println("Connection Accepted from Client:");
			System.out.println("Client IP:" + ds.getInetAddress().getHostName());

			System.out.println("Remote IP:" + ds.getPort());
			System.out.println("Local Port:" + ds.getPort());

			try (ObjectOutputStream out = new ObjectOutputStream(ds.getOutputStream());
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					DataOutputStream dout = new DataOutputStream(ds.getOutputStream())) {

				dout.flush();
				DataInputStream din = new DataInputStream(ds.getInputStream());
				while (true) {
					switch (din.readInt()) {
					case 1: {
						System.out.println("In case 1:");
						String mobileNo = din.readUTF();
						System.out.println("Client sent Mobile NO:" + mobileNo);

						String curBill = getCurrentMonthBill(mobileNo, hm);

						// Writting The Result to client
						dout.writeUTF(curBill);
					}
						break;

					case 2: {
						System.out.println("In case 1:");
						String mobileNo = din.readUTF();
						System.out.println("Client sent Mobile NO:" + mobileNo);

						List<String> lastSixMonthBill = getLastSixMonthBill(mobileNo, hm);

						// Writing List Reference to client
						out.writeObject(lastSixMonthBill);
					}
						break;
					case 3: {
						System.out.println("In Case 3");
						String userName = getMaxBill(hm);
						
						//Writting User Name having Max Bill in last 6 month
						dout.writeUTF(userName);

					}
						break;

					case 4: {

						System.out.println("In case 4:");
						String userName = din.readUTF();
						System.out.println("Client sent User Name:" + userName);
						
						String DOB = din.readUTF();
						System.out.println("Client sent Date:" + DOB);
						
						// For Validating User Send Date
						LocalDate dob = LocalDate.parse(DOB);

						
						String curBill = getCurrentMonthBillByDateAndName(userName, dob, hm);
						System.out.println("Server Returned CurBill" + curBill);

						dout.writeUTF(curBill);

					}
						break;
					default:
						break;
					}
				}

			} catch (Exception e) {

				/*
				 * if (e instanceof EOFException)
				 * System.out.println("Client has Terminated Application!!");
				 */
				e.printStackTrace();
			}

		} catch (Exception e) {

			if (e instanceof EOFException)
				System.out.println("Client has Terminated Application!!");
			// e.printStackTrace();
		}
		System.out.println("Out Of try bolck!!!");
	}

}
