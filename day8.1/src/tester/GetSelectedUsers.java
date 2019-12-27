package tester;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.User;

public class GetSelectedUsers {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf()) {
			System.out.println("hib started....");
			System.out.println("Enter role n date");
			UserDaoImpl dao = new UserDaoImpl();
			for (User u : dao.getAllSelectedUsers(sc.next(), sdf.parse(sc.next())))
				System.out.println(u);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
