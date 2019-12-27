package tester;

import static utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.*;

import dao.StudentDaoImpl;
import pojos.Student;

public class StudentAdmission {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hib started....");
			System.out.println("Enter student name n course name");
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println(dao.admitNewStudent(new Student(sc.next()), sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
