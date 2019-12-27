package com.app.dao;

import java.util.List;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.pojos.Vendor;

@Repository
@Transactional
public class VendorDaoImpl implements IVendorDao {
//dependency
	@Autowired
	private SessionFactory sf;

	@Override
	public List<Vendor> listAllVendors() {
		String jpql = "select v from Vendor v where v.role=:rl";
		return sf.getCurrentSession().createQuery(jpql, Vendor.class).setParameter("rl", "vendor").getResultList();
	}

	@Override
	public String deleteVendor(int vendorId) {
		Session hs = sf.getCurrentSession();
		Vendor v = hs.get(Vendor.class, vendorId);
		// v --persistent
		hs.delete(v);
		return "Vendor with " + vendorId + " un subscribed ...";
	}

	@Override
	public String registerVendor(Vendor v) {
		sf.getCurrentSession().persist(v);
		return "Vendor with ID " + v.getId() + " reged successfully...";
	}

}
