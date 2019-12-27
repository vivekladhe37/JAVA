package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.dao.ICourseDao;
import com.app.pojos.Course;
import com.app.pojos.Student;

@Service
@Transactional
public class CouerseServiceimpl implements Iservice{
    @Autowired
	private ICourseDao cdao;
    @Autowired 
    private IAdminDao adao;
    
	public List<Course> getAllCourse()
	{
		return cdao.getAllCourse();
	}
	public String registerStudents(Student s,HttpSession hs)
	{   
		if(s.getDob().isAfter(LocalDate.parse("1990-01-01")))
		{
			//hs.setAttribute("msg1","Date Should not after 1995");
			hs.setAttribute("msg1","Date Should not after 1995 ");
			return "/admin/register";
		}
		if(s.getCgpa()<7)
		{
			hs.setAttribute("msg1", "cgpa should greater than 7");
			return "/admin/register";
		}
		

		 return adao.registerStudent(s);
	}
}
