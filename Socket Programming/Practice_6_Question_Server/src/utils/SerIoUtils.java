package utils;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.app.core.Customer;

public class SerIoUtils {

	public static void writeData(ObjectOutputStream out,int curMonthBill) throws IOException
	{
		System.out.println("In SerIo Utils");
		//out.writeObject(hm);
		
		/*for(Customer c:hm.values())
		{
			out.writeObject(c);
		}*/
		System.out.println("In Write Data:");
		out.writeObject(curMonthBill);
	    System.out.println("Write Data Over and returning...");	
	}
	
	
}
