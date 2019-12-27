package pojos;

import java.sql.Date;

public class Customer {
	private int id;
	private String email, pass;
	private double amount;
	private Date regDate;
	public Customer(int id, String email, String pass, double amount, Date regDate) {
		super();
		this.id = id;
		this.email = email;
		this.pass = pass;
		this.amount = amount;
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", amount=" + amount + ", regDate=" + regDate + "]";
	}
	
	
}
