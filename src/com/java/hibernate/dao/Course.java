package com.java.hibernate.dao;

import java.util.Set;

public class Course implements java.io.Serializable {

	private long courseId;
	private String courseName;
	private Set<Student> students;

	public Course() {
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}