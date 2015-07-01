package bus;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.Employee;



public class DataGathering {
	
	
	public List<Employee> getData(){
		
		// Create Session Factory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		// create session object
		Session session = sf.openSession();
		
		//create criteria
		Criteria cr = session.createCriteria(Employee.class);
		List<Employee> results = cr.list();
		
		
		
		
		
		
		return results;
		
		
		
	}

}
