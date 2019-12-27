package dao;

import pojos.User;
import static utils.HibernateUtils.*;
import org.hibernate.*;

public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User u) {
		// get session from SF
		Session hs = getSf().openSession();
		// begin tx
		Transaction tx = hs.beginTransaction();
		try {
			hs.save(u);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		} finally {
			// close session --rets pooled out DB conn to the pool
			hs.close();
		}
		return "User reg success , ID : "+u.getUserId();
	}

}
