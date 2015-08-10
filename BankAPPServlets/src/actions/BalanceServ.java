package actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import business.Balance;
import business.Operations;

public class BalanceServ extends HttpServlet {

	
	final static Logger logger = Logger.getLogger(BalanceServ.class); 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	

		//get the account number from session and get the updated balance not the one saved on session
		HttpSession sess = req.getSession();
		Operations ope = new Operations();
		
		//add the info requested
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("balanceS",ope.getBalance(sess.getAttribute("account").toString()));
		map.put("success", true);
		
		
		write(resp,map);
		

	}

	private void write(HttpServletResponse resp, Map<String, Object> map) {
		
		
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		try {
			resp.getWriter().write(new Gson().toJson(map));
		} catch (IOException e) {
			logger.error( e );
		}

		
	}

}
