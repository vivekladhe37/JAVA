package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IAdminDao;
import com.app.dao.IDepartmentDao;
import com.app.pojos.Department;
import com.app.pojos.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IDepartmentDao dao;

	@Autowired
	private IAdminDao adao;

	@Override
	public List<Department> getDepartments() {

		return dao.getDepartments();
	}

	@Override
	public String registerEmployee(Employee e,HttpSession hs) {
		if(!(e.getSalary() > 20000 && e.getSalary() < 30000 ))
		{
			hs.setAttribute("msg1", "Salary Should be within 20000 "
					+ "and 30000");
			return "/admin/register";
		}
		if(e.getDateOfBirth().isAfter(LocalDate.parse("1995-01-01")))
		{
			hs.setAttribute("msg1","Date Should not after 1995");
			return "/admin/register";
		}

		
		return adao.registerEmployee(e);
	}

}
