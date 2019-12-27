package dao;

import static utils.HibernateUtils.getSf;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String admitNewStudent(Student s, String courseName) {
		String mesg="student admission failed";
		String jpql = "select c from Course c where c.name=:nm";
		// session
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			// get Course dtls from course name
			Course c = hs.createQuery(jpql, Course.class).setParameter("nm", courseName).getSingleResult();
			// c-- PERSISTENT
			c.addStudent(s);
			tx.commit();
			mesg="student admitted successfully...";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Student getStudentDetails(String name1) {
		Student s=null;
		String jpql = "select s from Student s where s.name=:nm";
		// session
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();

		try {
			s=hs.createQuery(jpql, Student.class).setParameter("nm", name1).getSingleResult();
			tx.commit();
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return s;
	}
	

}
