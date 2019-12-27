package tester;

import static utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;

public class UpdateUser {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf()) {
			System.out.println("hib started....");
			System.out.println("Enter user email pass new pass n incr amt");
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println(
					dao.updateUserDetails(sc.next(), sc.next(), sc.next(), sc.nextDouble()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
