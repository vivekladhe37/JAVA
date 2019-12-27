package com.app.dao;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorDao {
	//list all vendors
	List<Vendor> listAllVendors();
	//delete vendor
	String deleteVendor(int vendorId);
	//add new vendor
	String registerVendor(Vendor v);
	

}
