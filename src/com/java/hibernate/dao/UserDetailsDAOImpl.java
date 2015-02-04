package com.java.hibernate.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.hibernate.dto.Student;
import com.java.hibernate.dto.UserDetails;

@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class UserDetailsDAOImpl implements UserDetailsDAO {

	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public void saveUserDetails(UserDetails userDetails) {
		hibernateTemplate.saveOrUpdate(userDetails);
	}
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void saveStudentDetails(Student student) {
		hibernateTemplate.save(student);
	}
	
	

}
