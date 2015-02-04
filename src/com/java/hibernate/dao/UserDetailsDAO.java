package com.java.hibernate.dao;

import com.java.hibernate.dto.Student;
import com.java.hibernate.dto.UserDetails;

public interface UserDetailsDAO {
	void saveUserDetails(UserDetails userDetails);
	void saveStudentDetails(Student student);
}
