package com.flipcard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipcard.bean.Student;
import com.flipcard.constant.SQLConstantQueries;
import com.flipcard.utils.DBUtil;

public class AdminDaoImpl implements AdminDao {
	// provides details of all students
	public List<Student> displayStudents() {

		Connection connection= DBUtil.getConnection();
		PreparedStatement stmt= null;
		try {

			stmt= connection.prepareStatement(SQLConstantQueries.DISPLAY_STUDENTS);

			ResultSet rs = stmt.executeQuery();

			List<Student> list= new ArrayList<Student>();

			//Creating ArrayList of student
			while(rs.next())
			{
				Student student= new Student();
				student.setStudentId(rs.getInt("StudentID"));
				student.setName(rs.getString("Name"));
				student.setPhoneNumber(rs.getLong("PhoneNumber"));
				student.setGender(rs.getString("Gender"));
				student.setBranch(rs.getString("Branch"));
				student.setSemester(rs.getInt("Semester"));
				student.setRegistrationStatus(rs.getBoolean("StudentRegistrationStatus"));
				student.setScholarshipPercentage(rs.getInt("ScholarshipPercentage"));
				
				list.add(student);
				                    
			}

			//returning list of student
			return list;
		}
		catch(SQLException ex) {
						}
		
		return null;
	}



}
