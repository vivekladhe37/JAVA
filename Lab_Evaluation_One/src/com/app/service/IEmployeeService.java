package com.app.service;

import java.util.*;

import javax.servlet.http.HttpSession;


import com.app.pojos.Department;
import com.app.pojos.Employee;
public interface IEmployeeService {

	public List<Department> getDepartments();
	public String registerEmployee(Employee e,HttpSession hs);
}
