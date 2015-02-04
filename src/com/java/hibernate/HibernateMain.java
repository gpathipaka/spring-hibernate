package com.java.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.dao.Course;
import com.java.hibernate.dao.Student;
import com.java.hibernate.dto.Address;
import com.java.hibernate.dto.FourWeeler;
import com.java.hibernate.dto.TwoWeeler;
import com.java.hibernate.dto.UserD;
import com.java.hibernate.dto.UserDetails;
import com.java.hibernate.dto.Vehicle;

public class HibernateMain {

	/**
	 * @param args
	 */
	//@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// singleTableInheritance();

		// oneToOneMapping();

		// User Details
		/*
		 * userDetails_1();
		 */

		//manyToMany();
	}

	private static void manyToMany() {
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		try {

			// session.save(v);
			// session.save(twoWeeler);
			// session.save(fourWeeler);
			
			Set<Course> courses = new HashSet<Course>();
			courses.add(new Course("Maths"));
			courses.add(new Course("Computer Science"));

			Student student1 = new Student("Gangadhar", courses);
			Student student2 = new Student("Joe", courses);
			session.save(student1);
			session.save(student2);
			
			
			//Set<Student> students = new HashSet<Student>();
			//students.add(student1);
			//students.add(student2);
			
			//session.save(students);

		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Transaction Rolled Back....");
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.clear();
		}
	}

	private static void singleTableInheritance() {

		Vehicle v = new Vehicle();
		v.setVehicleName("Car");

		TwoWeeler twoWeeler = new TwoWeeler();
		twoWeeler.setVehicleName("Pulsar");
		twoWeeler.setStreeringHandle("Pulsar steering Handle");

		FourWeeler fourWeeler = new FourWeeler();
		fourWeeler.setVehicleName("BMW");
		fourWeeler.setSteeringWeel("BMW car steering");

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		try {

			session.save(v);
			session.save(twoWeeler);
			session.save(fourWeeler);

		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Transaction Rolled Back....");
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.clear();
		}
	}

	private static void oneToOneMapping() {

		UserD userDetails = new UserD();
		userDetails.setName("Samatha");
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Bike");

		userDetails.getVehicle().add(vehicle);
		userDetails.getVehicle().add(vehicle1);

		// vehicle.getUserList().add(userDetails);
		// vehicle.getUserList().add(userDetails);

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		try {
			session.beginTransaction();

			session.persist(userDetails);
			// session.save(userDetails);
			// session.save(vehicle);
			// session.save(vehicle1);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Transaction Rolled Back....");
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.clear();
		}

	}

	private static void userDetails_1() {

		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(1);
		userDetails.setUserName("Samatha");

		Address homeAddress = new Address();
		homeAddress.setStreetName("834 Washington Avenue");
		homeAddress.setCity("Carnegie");
		homeAddress.setState("PA");
		homeAddress.setZip("15106");

		Address officeAddress = new Address();
		officeAddress.setStreetName("1000 Fedex Drive");
		officeAddress.setCity("Carnegie");
		officeAddress.setState("PA");
		officeAddress.setZip("15108");

		/*
		 * userDetails.setHomeAddress(homeAddress);
		 * userDetails.setOfficeAddress(officeAddress);
		 */

		userDetails.getAddList().add(homeAddress);
		userDetails.getAddList().add(officeAddress);

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.save(userDetails);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Transaction Rolled Back....");
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			session.clear();
		}

		session = null;
		userDetails = null;
		session = factory.openSession();
		userDetails = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
		System.out.println("Address List " + userDetails.getAddList().size());

	}

}
