package demo03.test;

import java.util.EnumSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import demo03.Course;
import demo03.Student;

public class HibernateTest3 {

	public static void main(String[] args) {
		
//		Course course = new Course();
//		course.setCname("化学");
//		
//		Student student = new Student();
//		student.setSname("刘备");
//		
//		student.getCourseSet().add(course);
//		
//		Session session = new Configuration().configure().buildSessionFactory().openSession();
//		session.beginTransaction();
//		
//		session.save(course);
//		session.save(student);
//		
//		session.getTransaction().commit();
		
		Configuration cfg = new Configuration().configure();
		//StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
		SchemaExport schemaExport = new SchemaExport(); 
		schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
	}

}
