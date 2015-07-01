package net.multivision.action;



import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.multivision.dao.Employee;
import net.multivision.dao.EmployeeDAOImpl;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

public class EmsAction extends DispatchAction {

	/*
	 * this is the spring injection using setter DI needs setters and getters
	 */
	EmployeeDAOImpl dao;
	HttpSession session;

	public EmployeeDAOImpl getDao() {
		return dao;
	}

	public void setDao(EmployeeDAOImpl dao) {
		this.dao = dao;
	}
	
	/*
	 * Action Login
	 */
	 public ActionForward login(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	     
		 	DynaActionForm loginForm = ((DynaActionForm)form);
			String user = loginForm.getString("user");
			String pass = loginForm.getString("pass");
			String type = loginForm.getString("type");
			
			if(dao.authUser(user, pass) && dao.getClearance(user,type)){
				
				return mapping.findForward("manager");
			}
			else if(dao.authUser(user, pass) && dao.getClearance(user,type) == false){
				return mapping.findForward("employee");
			}
			else{
				System.out.println("fail to authenticate user");
				return mapping.findForward("fail");
			}
	}
	 
	 /*
	  * Action Add
	  */
	 public ActionForward add(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	     
		 	DynaActionForm loginForm = ((DynaActionForm)form);
			String user = loginForm.getString("user");
			String pass = loginForm.getString("pass");
			String clear = loginForm.getString("clearance");
			String first = loginForm.getString("name");
			String last = loginForm.getString("last");
			
			System.out.println("add values -> " + user + " " + pass + " " + clear + " " + first+ " "  + last);
			
			return mapping.findForward("add");
	}
	 
	 public ActionForward addEmp(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
		 
		 	//Type cast form to login from.
		 	DynaActionForm loginForm = ((DynaActionForm)form);
		 	//get data inputs
			String user = loginForm.getString("user");
			String pass = loginForm.getString("pass");
			String clear = loginForm.getString("clearance");
			String first = loginForm.getString("name");
			String last = loginForm.getString("last");
			
			/*
			 * write the file
			 */
			
			FormFile uploadFile   = (FormFile)loginForm.get("file");
			String img = writeFile(uploadFile,first,last);
			
			//add into data base
			dao.create(first, last, user, pass, clear,img);
			//get all employees from data base
			loadEmployees(request);
			//debug statement to know which method has being invoke
			System.out.println("addEmp values -> " + user + " " + pass + " " + clear + " " + first+ " "  + last);
			//go to the page requested in strut config
			return mapping.findForward("adview");
	}
	 /*
	  * Action Update
	  */
	 
	 public ActionForward update(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	     
		
		 	loadEmployees(request);
			System.out.println("update values -> ");
			return mapping.findForward("select");
	}
	 
	 public ActionForward getEmp(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	     
		 	DynaActionForm loginForm = ((DynaActionForm)form);
			String id = loginForm.getString("id");
			System.out.println("this is the id" + id);
			Employee emp = dao.update(id);
			session = request.getSession(true);
			session.setAttribute("employee", emp);
			System.out.println("getEmp values -> " );
			return mapping.findForward("update");
	}
	 
	 public ActionForward upEmp(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	     
		 	DynaActionForm loginForm = ((DynaActionForm)form);
		 	String id = loginForm.getString("id");
			String user = loginForm.getString("user");
			String pass = loginForm.getString("pass");
			String clearance = loginForm.getString("clearance");
			String first = loginForm.getString("name");
			String last = loginForm.getString("last");
			
			/*
			 * write the file
			 */
			
			FormFile uploadFile   = (FormFile)loginForm.get("file");
			String img = writeFile(uploadFile,first,last);
			
			dao.updateEmployee(id,user,pass,clearance,first,last,img);
			loadEmployees(request);
			System.out.println("upEmp values -> " + user + " " + pass + " " + clearance + " " + first+ " "  + last);
			return mapping.findForward("adview");
	}
	 /*
	  * Action Delete
	  */
	 public ActionForward delete(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	     
		 	loadEmployees(request);
			System.out.println("delete values -> ");
			return mapping.findForward("delete");
	}
	 
	 public ActionForward delEmp(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	     
		 	DynaActionForm loginForm = ((DynaActionForm)form);
			String id = loginForm.getString("id");
			System.out.println("this is the id" + id);
			dao.delete(id);
			loadEmployees(request);
			System.out.println("delEmp values -> ");
			return mapping.findForward("adview");
	}
	 /*
	  * Views
	  */
	 public ActionForward view(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	     
		 	
		 	loadEmployees(request);
			System.out.println("view values -> ");
			return mapping.findForward("adview");
	}
	 
	 public ActionForward eview(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	     	//get any input of aform
		 	DynaActionForm loginForm = ((DynaActionForm)form);
			String user = loginForm.getString("user");
			String pass = loginForm.getString("pass");
			//creates an employee
			Employee emp = dao.read(user, pass);
			//place it in a http session with name eview
			session = request.getSession(true);
			session.setAttribute("eview", emp);
			//debug purposes
			System.out.println("eview values -> " + user + pass);
			//go to employee view
			return mapping.findForward("eview");
	}
	 
	 public ActionForward profile(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
		//get any input of aform
		 	DynaActionForm loginForm = ((DynaActionForm)form);
			String user = loginForm.getString("user");
			String pass = loginForm.getString("pass");
			//creates an employee
			Employee emp = dao.read(user, pass);
			//place it in a http session with name eview
			session = request.getSession(true);
			session.setAttribute("eview", emp);
			//debug purposes
		 	System.out.println("profile values -> ") ;
			return mapping.findForward("profile");
	}
	 
	 public ActionForward returnadview(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	  
			System.out.println("returnadview values -> ") ;
			return mapping.findForward("manager");
	}
	 
	 public ActionForward returneview(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	  
			System.out.println("returneview values -> ") ;
			return mapping.findForward("employee");
	}
	 
	
	 
	 /*
	  * get all the elements of a list
	  */
	 
	 public void loadEmployees(HttpServletRequest request)
	 {
		 	session = request.getSession(true);
			List<Employee> list= dao.readAll();
			session.setAttribute("employees", list);
	 }
	 
	 /*
	  * write file
	  */
	 public String writeFile(FormFile uploadFile,String first,String last){
		 /*
			 * write the file
			 */
		 try {
			 String uploadingFileName    = last+first+"1.jpg";
				
				String uploadPath="C:\\Users\\Hector\\Desktop\\emsn-img";
				File uploadFileObject = new File(uploadPath,uploadingFileName);

				FileOutputStream fileOutStream = new FileOutputStream(uploadFileObject);
				fileOutStream.write(uploadFile.getFileData());
				fileOutStream.flush();
				fileOutStream.close();
				return uploadPath + "\\" + uploadingFileName;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return null;
			
	 }
	 

}
