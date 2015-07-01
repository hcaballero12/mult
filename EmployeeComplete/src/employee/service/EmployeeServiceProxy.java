package employee.service;

public class EmployeeServiceProxy implements employee.service.EmployeeService {
  private String _endpoint = null;
  private employee.service.EmployeeService employeeService = null;
  
  public EmployeeServiceProxy() {
    _initEmployeeServiceProxy();
  }
  
  public EmployeeServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeServiceProxy();
  }
  
  private void _initEmployeeServiceProxy() {
    try {
      employeeService = (new employee.service.EmployeeServiceServiceLocator()).getEmployeeServicePort();
      if (employeeService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employeeService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employeeService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employeeService != null)
      ((javax.xml.rpc.Stub)employeeService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public employee.service.EmployeeService getEmployeeService() {
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService;
  }
  
  public java.lang.String getEmployees() throws java.rmi.RemoteException{
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService.getEmployees();
  }
  
  
}