package dao;

import pojos.Customer;
import java.sql.*;
import static utils.DBUtils.*;

public class CustomerDaoImpl implements ICustomerDao {
	private Connection cn;
	private PreparedStatement pst1;

	// constr
	public CustomerDaoImpl() throws Exception {
		// cn
		cn = fetchConnection();
		pst1 = cn.prepareStatement("select * from my_customers where email=? and password=?");
		System.out.println("customer dao created");
	}
	
	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();
		if (cn != null)
			cn.close();
		System.out.println("cust dao cleaned up");
		
	}

	@Override
	public Customer signIn(String email, String pass) throws Exception {
		//set IN params
		pst1.setString(1, email);
		pst1.setString(2, pass);
		try(ResultSet rst=pst1.executeQuery())
		{
			if(rst.next())
				return new Customer(rst.getInt(1), email, pass, rst.getDouble(4), rst.getDate(5));
		}
		return null;
	}

	@Override
	public String signUp(Customer c) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
