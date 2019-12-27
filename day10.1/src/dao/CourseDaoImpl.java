package dao;

import pojos.Course;
import pojos.Student;

import org.hibernate.*;
import static utils.HibernateUtils.*;

import java.util.List;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String launchCourse(Course c) {
		String mesg = "Launching course failed...";
		// session
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			hs.persist(c);
			tx.commit();
			mesg = "Course launched with ID : " + c.getId();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public List<Student> getStudentsByCourseName(String cName) {
		String jpql = "select c from Course c where c.name=:nm";
		List<Student> l1 = null;
		// HS
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			Course c = hs.createQuery(jpql, Course.class).setParameter("nm", cName).getSingleResult();
			// c -- persistent
			l1 = c.getStudents(); // l1 --- coll of proxies
			l1.size();// l1 --fetched data from DB
			tx.commit(); // session is closed
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		System.out.println(l1);
		return l1;// DAO rets collection of proxies to tester --DETACHED
	}

	@Override
	public List<Student> getStudentsByCourseNameAgain(String cName) {
		String jpql = "select c from Course c join fetch c.students where c.name=:nm";
		List<Student> l1 = null;
		// HS
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			Course c = hs.createQuery(jpql, Course.class).setParameter("nm", cName).getSingleResult();
			// c -- persistent
			l1 = c.getStudents(); // l1 --- coll of student's data lifted from DB
		
			tx.commit(); // session is closed
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		System.out.println(l1);
		return l1;// DAO rets collection of proxies to tester --DETACHED
	}

}
