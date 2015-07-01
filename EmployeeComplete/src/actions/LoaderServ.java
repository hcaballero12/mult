package actions;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





import dao.Employee;
import bus.WsClient;

public class LoaderServ extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		WsClient a = new WsClient();
		List<Employee> results = a.display();
		
		RequestDispatcher rd;
		HttpSession session = req.getSession(true);
		session.setAttribute("results", results);
		rd = req.getRequestDispatcher("/data.jsp");
		rd.forward(req, resp);

	}

}
