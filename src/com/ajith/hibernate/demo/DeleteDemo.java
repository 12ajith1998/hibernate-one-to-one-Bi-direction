package com.ajith.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajith.hibernate.demo.entity.Instructor;
import com.ajith.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {


			session.beginTransaction();

			int theId=3;
			Instructor tempInstructor=session.get(Instructor.class, theId);
			
			session.delete(tempInstructor);
			session.getTransaction().commit();

			System.out.println("Done !");

		} finally {
			factory.close();
		}
	}

}
