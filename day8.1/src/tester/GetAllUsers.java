package tester;
import static utils.HibernateUtils.getSf;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.User;

public class GetAllUsers {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf())
		{
			System.out.println("hib started....");
			UserDaoImpl dao=new UserDaoImpl();
			for(User u : dao.getAllUsers())
				System.out.println(u);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
