package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable,Comparable<Customer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerName;
	private LocalDate birtDate;
	private String mobileNumber;
	private List<String> bills;

	public Customer() {
		System.out.println("In default Constr!!");
	}

	public Customer(String customerName, LocalDate birtDate, String mobileNumber) {
		super();
		this.customerName = customerName;
		this.birtDate = birtDate;
		this.mobileNumber = mobileNumber;
		 bills=new ArrayList<String>();

	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", birtDate=" + birtDate + ", mobileNumber=" + mobileNumber
				+ ", bills=" + bills + "]";
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getBirtDate() {
		return birtDate;
	}

	public void setBirtDate(LocalDate birtDate) {
		this.birtDate = birtDate;
	}

	public List<String> getBills() {
		return bills;
	}

	public void setBills(List<String> bills) {
		this.bills = bills;
	}

	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
