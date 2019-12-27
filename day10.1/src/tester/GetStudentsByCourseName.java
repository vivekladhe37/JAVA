package tester;

import static utils.HibernateUtils.*;

import java.util.List;
import java.util.Scanner;

import org.hibernate.*;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Student;

public class GetStudentsByCourseName {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hib started....");
			System.out.println("Enter course name");
			CourseDaoImpl dao = new CourseDaoImpl();
			List<Student> list = dao.getStudentsByCourseName(sc.next());
			/*
			 * for (Student s : list) System.out.println(s);
			 */	
			
			} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
