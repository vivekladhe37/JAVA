package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pojos.DacBooks;

import static dbutils.DBUtils.*;

public class BookDaoImpl implements IBookDao {

	private Connection con;
	private PreparedStatement pst1, pst2,pst3;

	public BookDaoImpl() throws ClassNotFoundException, SQLException {
		super();
		con = fetchConnection();
		String sql1 = "select category from dac_books";
		pst1 = con.prepareStatement(sql1);
		String sql2 = "select * from dac_books where category=?";
		pst2 = con.prepareStatement(sql2);
		
		String sql3 = "select * from dac_books where id=?";
		pst3 = con.prepareStatement(sql3);
		
		System.out.println("BookDaoImpl called!!!");
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst2 != null)
			pst2.close();
        if (con != null)
			con.close();
		System.out.println("BookDao CleanUp called!!!");
	}

	public List<String> getCategoryNames() throws SQLException {
		List<String> names = new ArrayList<String>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next()) {
				names.add(rst.getString(1));

			}

		}
		return names;
	}

	public List<DacBooks> getBookDetailsByCategory(String categoryName) throws SQLException {

		List<DacBooks> books=new ArrayList<DacBooks>();
		pst2.setString(1, categoryName);
		try(ResultSet rst=pst2.executeQuery())
		{
			while(rst.next())
			{
				books.add(new DacBooks(rst.getInt(1),rst.getString(2), 
						rst.getString(3),rst.getString(4),rst.getShort(5)));
			}
			
		}
		return books;
	}

	@Override
	public DacBooks getBookDetailsById(int id) throws SQLException {
		
		pst3.setInt(1, id);
		try(ResultSet rst=pst3.executeQuery())
		{
			
			if(rst.next())
			{
				return new DacBooks(rst.getInt(1),rst.getString(2), 
						rst.getString(3),rst.getString(4),rst.getDouble(5));
			}
			
		}
		return null;
		
	}

}
