package employee.service;
import javax.jws.*;

@WebService
public class EmployeeService {

	@WebMethod
	public String getEmployees(){
		
		
		LoadEmployees emp = new LoadEmployees();

		System.out.println(emp);
		return emp.loadInfo();
	}
}
