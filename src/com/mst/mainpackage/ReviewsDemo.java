package com.mst.mainpackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mst.entity.Course;
import com.mst.entity.Instructor;
import com.mst.entity.InstructorDetail;
import com.mst.entity.Review;

public class ReviewsDemo {
public static void main(String[] args) {
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Course.class)
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(InstructorDetail.class)
			.addAnnotatedClass(Review.class)
			.buildSessionFactory();
	
	Session session = sessionFactory.getCurrentSession();
	
	try {
		
		session.beginTransaction();
		
		Course tempCourse = new Course("WebDeveloper - Bootcamp");
		
		tempCourse.addReviews(new Review("Interesting course to learn new algos"));
		tempCourse.addReviews(new Review("Best Course"));
		
		session.save(tempCourse);
		
		session.getTransaction().commit();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		session.close();
		sessionFactory.close();
	}
	finally {
		session.close();
		sessionFactory.close();
	}
}
}
