package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDaoImpl;
import pojos.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/validate")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDaoImpl dao;

	public void init() throws ServletException {
		try {
			dao = new CustomerDaoImpl();
		} catch (Exception e) {
			throw new ServletException("err in init :" + getClass().getName(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			dao.cleanUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("err in destroy ", e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set cont type
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			//invoke dao's method for authentication
			Customer c=dao.signIn(request.getParameter("em"), request.getParameter("pass"));
			//invalid login -- null
			if(c == null)
				pw.print("<h4> Invalid Login , Pls  <a href='login.html'>Retry</a></h4>");
			else  {
				//create a cookie
				Cookie c1=new Cookie("cust_dtls", c.toString());
				//add cookie to resp hdr
				response.addCookie(c1);
				//redirect the clnt to NEXT page , in the NEXT request
				response.sendRedirect("details");
			}
		}catch (Exception e) {
			throw new ServletException("err in do-get : "+getClass().getName(),e);
		}
	}

}
