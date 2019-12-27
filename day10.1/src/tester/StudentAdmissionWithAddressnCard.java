package tester;

import static utils.HibernateUtils.*;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.*;

import dao.StudentDaoImpl;
import pojos.Address;
import pojos.AdharCard;
import pojos.Student;

public class StudentAdmissionWithAddressnCard {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hib started....");
			System.out.println("Enter student name n course name");
			Student s1 = new Student(sc.next());
			String courseName = sc.next();
			System.out.println("Enter addresss dtls ci st co");
			s1.addAddress(new Address(sc.next(), sc.next(), sc.next()));
			System.out.println("Enter adhar card no n date");
			// link adhar card to student dtls
			s1.setCard(new AdharCard(sc.next(), LocalDate.parse(sc.next())));
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println(dao.admitNewStudent(s1, courseName));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
