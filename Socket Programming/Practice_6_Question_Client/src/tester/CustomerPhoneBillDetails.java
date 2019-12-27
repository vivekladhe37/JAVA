package tester;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class CustomerPhoneBillDetails {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.out.println("Enter Remote IP and Port:");
		boolean exit = false;
		try (Scanner sc = new Scanner(System.in); Socket s = new Socket(sc.next(), sc.nextInt())) {

			System.out.println("Connected To Server!!Yayy!!");
			System.out.println("Server IP" + s.getInetAddress());
			System.out.println("Remote Port:" + s.getPort());
			System.out.println("Local Port:" + s.getLocalPort());

			try (DataOutputStream dout = new DataOutputStream(s.getOutputStream());
					ObjectInputStream in = new ObjectInputStream(s.getInputStream());
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					DataInputStream din = new DataInputStream(s.getInputStream());
					ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream())) {
				
				dout.flush();
				while (!exit) {
					System.out.println("****Menu****");
					System.out.println("1.Get Current Month Bill");
					System.out.println("2.Get bills for last 6 months");
					System.out.println("3.User Having Max bill in past 6 month");
					System.out.println("4.Current Bill By using name and DatOfBirth");
	                System.out.println("10.Exit");
					System.out.println("Enter Your Choice");
					
					switch (sc.nextInt()) {
					case 1: {
						dout.writeInt(1);
						System.out.println("Enter Your Phone No:");
						dout.writeUTF(br.readLine());

						System.out.println("Current Month Bill:" +"Rs:"+ din.readUTF());

					}
						break;

					case 2: {
						dout.writeInt(2);
						System.out.println("Enter Your Phone No:");
						dout.writeUTF(br.readLine());

						@SuppressWarnings("unused")
						List<String> lastSixMonthBill1 = (List<String>) in.readObject();
						System.out.println("Last Six Months Bill:");
						int i = 0;
						for (String b : lastSixMonthBill1) {
							System.out.println(i + 1 +"=>"+ "Month Bill:" +"Rs."+ b);
							i++;
						}

					}
						break;
					case 3: {
						System.out.println("In case 3");
						dout.writeInt(3);
						System.out.println("Customer Name with max Bill in last Six month:" + din.readUTF());

					}
						break;

					case 4: {
						System.out.println("In case 4");
						dout.writeInt(4);
						System.out.println("Enter Name:");
						dout.writeUTF(br.readLine());
						System.out.println("Enter Date of Birth:");
						dout.writeUTF(br.readLine());
						System.out.println("Current Month Bill:"+"Rs." + din.readUTF());

					}
						break;

					case 10: {
						exit = false;
					}
						break;
					}
					sc.nextLine();
				}

			} catch (Exception e) {

				/*
				 * if (e instanceof EOFException)
				 * System.out.println("Server has Terminated Application!!");
				 */
				e.printStackTrace();
			}

		} catch (Exception e) {

			/*
			 * if (e instanceof EOFException)
			 * System.out.println("Server has Terminated Application!!");
			 */
			e.printStackTrace();
		}

	}

}
