package dao;

import java.util.List;

import pojos.Course;
import pojos.Student;

public interface ICourseDao {
	String launchCourse(Course c);//c -- transient
    List<Student> getStudentsByCourseName(String cName);
    List<Student> getStudentsByCourseNameAgain(String cName);

}
