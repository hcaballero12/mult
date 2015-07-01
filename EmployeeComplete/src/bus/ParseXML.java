package bus;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import dao.Department;
import dao.Employee;

public class ParseXML {

	public void parse() {

		try {

			// Create Session Factory
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();

			// create session object
			Session session = sf.openSession();
			//create transaction
			Transaction tran = session.beginTransaction();

			// create a set of employees
			Set<Employee> empSet = new HashSet<Employee>();
			// create file in this case the xml that I created
			File file = new File("employee.xml");
			// create a document builder factory
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			// create a document builder
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			// create a document by parsing file to a document using document
			// builder
			Document d = db.parse(file);
			String name = "";
			String email = "";
			String department = "";

			// create node list with parent root of xml
			NodeList list = d.getElementsByTagName("employee");

			// iterate thorough the node list
			for (int i = 0; i < list.getLength(); i++) {
				// create element for each iteration
				Element element = (Element) list.item(i);
				// getcurrent item by element tag name
				name = element.getElementsByTagName("name").item(0)
						.getTextContent();
				email = element.getElementsByTagName("email").item(0)
						.getTextContent();
				department = element.getElementsByTagName("dept-name").item(0)
						.getTextContent();
				// insert employee into the set by checking departmen in an if
				if (department.trim().toUpperCase().equals("HR")) {

					// create employee object
					Employee x = new Employee();
					Department demp = (Department) session.load(Department.class, 122L);
					x.setName(name);
					x.setEmail(email);
					x.setSdept(demp);
					empSet.add(x);


				} else if (department.trim().toUpperCase().equals("IT")) {

					// create employee object
					Employee x = new Employee();
					Department demp = (Department) session.load(Department.class, 121L);
					x.setName(name);
					x.setEmail(email);
					x.setSdept(demp);
					empSet.add(x);
				} else if (department.trim().toUpperCase().equals("MARKETING")) {

					// create employee object
					Employee x = new Employee();
					Department demp = (Department) session.load(Department.class, 120L);
					x.setName(name);
					x.setEmail(email);
					x.setSdept(demp);
					empSet.add(x);

				} else {
					System.out.println(name);
					System.out.println(email);
					System.out.println(department);
				}

			}
			

			// Inset into the database using the deparment set
			Department demp = new Department();
			//save the set of department with a set of employees then save it.
			demp.setEmployee(empSet);
			session.save(demp);
			tran.commit();
			
			

		} catch (Exception e) {

		}

		

	}

}
