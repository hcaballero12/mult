package actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import business.Operations;

import com.google.gson.Gson;

public class Operation extends HttpServlet {

	final static Logger logger = Logger.getLogger(Operation.class); 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			// get the account number from session and get the updated balance
			// not the one saved on session
			HttpSession sess = req.getSession();
			Operations ope = new Operations();

			// get input
			double amount = Double.parseDouble(req.getParameter("amount"));
			String operation = req.getParameter("operation");
			double balance = ope.doOperation(amount, operation, sess
					.getAttribute("account").toString());
			System.out.println(amount);
			System.out.println(operation);
			System.out.println(balance);

			// add the info requested
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("balanceS",ope.getBalance(sess.getAttribute("account").toString()));
			map.put("amount", amount);
				//in the operation class is going to return insufficient balance as a 0.00 so we handle it here accordingly
				if(balance == 0.00){
					map.put("success", false);
				}else{
					map.put("success", true);
				}
			
			

			write(resp, map);
		} catch (Exception e) {
			logger.error( e );
		}

	}

	private void write(HttpServletResponse resp, Map<String, Object> map) {

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		try {
			resp.getWriter().write(new Gson().toJson(map));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error( e );
		}

	}

}
