package com.flipcard.service;

import java.util.List;

import com.flipcard.bean.Student;
import com.flipcard.dao.AdminDao;
import com.flipcard.dao.AdminDaoImpl;

public class AdminServiceOperation implements AdminServiceInterface {
	AdminDao userDao= new AdminDaoImpl();
	public List<Student> displayStudents(){
		return userDao.displayStudents();
	}

}
