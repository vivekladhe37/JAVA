package tester;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;
import pojos.User;
import pojos.UserType;

public class RegUser {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf()) {
			System.out.println("hibernate booted....");
			// String name, String email, String password, String role, String
			// confirmPassword, double regAmount,
			// Date regDate, UserType userType
			System.out.println("Enter user dtls nm em pass role cpass amt dt utype");
			User u = new User(sc.next(), sc.next(), 
					sc.next(), sc.next(), sc.next(),
					sc.nextDouble(),
					sdf.parse(sc.next()),
					UserType.valueOf(sc.next().toUpperCase()));
			//create DAO instance
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println(dao.registerUser(u));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
