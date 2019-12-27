package dao;

import pojos.Student;

public interface IStudentDao {
	String admitNewStudent(Student s, String courseName);
    Student getStudentDetails(String name);
}
