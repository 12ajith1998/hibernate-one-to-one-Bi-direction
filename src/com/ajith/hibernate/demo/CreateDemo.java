package com.ajith.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajith.hibernate.demo.entity.Instructor;
import com.ajith.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {

//			Instructor tempInstructor = new Instructor("Ajith", "kumar", "Ak@gmail.com");

//			InstructorDetail tempInstructorDetail = new InstructorDetail("SimplyKrishyoutube.com", "Luv 2 code...!!!");

			Instructor tempInstructor = new Instructor("krish", "krish", "krish@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("Ajithyoutube.com", "Luv to code...!!!");

			tempInstructor.setInstructorDetail(tempInstructorDetail);

			session.beginTransaction();

			session.save(tempInstructor);

			session.getTransaction().commit();

			System.out.println("Done !");

		} finally {
			factory.close();
		}
	}

}
