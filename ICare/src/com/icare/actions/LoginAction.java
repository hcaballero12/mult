package com.icare.actions;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

import com.icare.dao.DAOImpl;
import com.icare.dao.Employee;
import com.icare.dao.Issue;
import com.icare.mail.Mail;

public class LoginAction extends DispatchAction {
	
	DAOImpl dao;
	
	

	public DAOImpl getDao() {
		return dao;
	}



	public void setDao(DAOImpl dao) {
		this.dao = dao;
	}



	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DynaActionForm loginForm = ((DynaActionForm) form);
		String user = loginForm.getString("user");
		String pass = loginForm.getString("pass");
		Employee emp = dao.authorize(user, pass);
		HttpSession session = request.getSession();
		
		//call the authentication and authorization method and check to grant access 
		Mail mail = new Mail();
		mail.sendEmail();
		
		if(emp == null){
			//System.out.println("fail to authenticate user");
			return mapping.findForward("fail");
			
		}
		else if(emp.getRole().equals("manager")){
			
			session.setAttribute("manager", dao.getDepartmentIssues(emp.getDepartment().getDepId()));
			System.out.println(emp.getDepartment().getDepartment());
			return mapping.findForward("manager");

		}
		else if(emp.getRole().equals("employee")){
		
			session.setAttribute("employee", dao.getEmployeeIssues(emp.getEmpId()));
			session.setAttribute("empId",emp.getEmpId());
			System.out.println(emp.getEmpId());
			return mapping.findForward("employee");
		} else {

			//System.out.println("fail to authenticate user");
			return mapping.findForward("fail");
		}
	}
	
	
	public ActionForward openIssue(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
			return mapping.findForward("open");
	}
	
	public ActionForward createIssue(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();
		DynaActionForm loginForm = ((DynaActionForm) form);
		String priority = loginForm.getString("priority");
		String description = loginForm.getString("description");
		String department = loginForm.getString("department");
		Long id = Long.parseLong(loginForm.getString("id"));
		java.util.Date date= new java.util.Date();

		Issue is = new Issue();
		is.setDescription(description);
		is.setPriority(Integer.parseInt(priority));
		is.setStatus("open");
		is.setTimestamp(new Timestamp(date.getTime()));
		System.out.println(is);
		boolean addYes = dao.addIssue(is,id,department);
		System.out.println(addYes);
		
		
		session.setAttribute("employee", dao.getEmployeeIssues(id));
		return mapping.findForward("employee");
	}
	
	
	public ActionForward closeIssue(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {


		HttpSession session = request.getSession();
		DynaActionForm loginForm = ((DynaActionForm) form);
		Long id = Long.parseLong(loginForm.getString("id"));

		session.setAttribute("issue", dao.getIssues(id));
		
			return mapping.findForward("close");
		
	}
	
	public ActionForward close(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {


		HttpSession session = request.getSession();
		DynaActionForm loginForm = ((DynaActionForm) form);
		Long id = Long.parseLong(loginForm.getString("id"));
		
		dao.updateIssueStats(id);
		
		Issue is = dao.getIssues(id);
		
		
		session.setAttribute("manager", dao.getDepartmentIssues(is.getDepartment().getDepId()));
		return mapping.findForward("manager");
		
	}

	public String authorization(String user, String password) {

		// check the database for clearance
		String type = null;
		Employee emp = dao.authorize(user, password);
		
	
		if (emp.getRole().equals("manager")){
			
			return type = emp.getDepartment().getDepartment();
		}
		else if(emp.getRole().equals("employee"))
			return type = String.valueOf(emp.getEmpId());
		else{
			return type;
		}

	}


}
