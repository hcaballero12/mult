package bus;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.List;

import javax.xml.rpc.ServiceException;

import dao.Employee;
import employee.service.*;

public class WsClient {
	
	public  List<Employee> display() throws RemoteException {
		
		EmployeeServiceServiceLocator loc = new EmployeeServiceServiceLocator();
		ParseXML parser = new ParseXML();
		DataGathering data = new DataGathering();
		
		try {
			EmployeeService port = loc.getEmployeeServicePort();
			
			
			writeFile(port.getEmployees());
			parser.parse();
			return data.getData();
			
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}
	
	private void writeFile(String message){
		
		try {
			File file = new File("employee.xml");
			FileWriter fr = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fr);
			
			bw.write(message);
			bw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
