package tester;

import static utils.HibernateUtils.*;

import java.util.List;
import java.util.Scanner;

import org.hibernate.*;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Student;

public class GetStudentDetailsByName {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hib started....");
			System.out.println("Enter student name");
			StudentDaoImpl dao = new StudentDaoImpl();
			Student s1 = dao.getStudentDetails(sc.next());
	       System.out.println(s1);	
	       System.out.println("adr details "+s1.getAddr());
	       System.out.println("course name "+s1.getSelectedCourse().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
