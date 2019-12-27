package tester;
import static utils.HibernateUtils.*;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.*;

import dao.CourseDaoImpl;
import pojos.Course;
import pojos.Student;

public class LaunchCourseWithStudents {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();
				Scanner sc=new Scanner(System.in))
		{
			System.out.println("hib started....");
			System.out.println("Enter course dtls : nm strt end fess capacity");
			Course c1=new Course(sc.next(), LocalDate.parse(sc.next()),  LocalDate.parse(sc.next()), sc.nextDouble(), sc.nextInt());
			for(int i=0;i<3;i++)
			{
				System.out.println("Enter student dtls : nm");
				Student s1=new Student(sc.next());
				c1.addStudent(s1);
			}
			CourseDaoImpl dao=new CourseDaoImpl();
			System.out.println(dao.launchCourse(c1));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
