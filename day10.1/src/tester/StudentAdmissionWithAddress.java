package tester;

import static utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.*;

import dao.StudentDaoImpl;
import pojos.Address;
import pojos.Student;

public class StudentAdmissionWithAddress {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); 
				Scanner sc = new Scanner(System.in)) {
			System.out.println("hib started....");
			System.out.println("Enter student name n course name");
			Student s1=new Student(sc.next());
			String courseName=sc.next();
			System.out.println("Enter addresss dtls ci st co");
			s1.addAddress(new Address(sc.next(), sc.next(), sc.next()));
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println(dao.admitNewStudent(s1,courseName));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
