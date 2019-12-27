package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// get cookie from req hdr
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for(Cookie c : cookies)
					if(c.getName().equals("cust_dtls"))
					{
						pw.print("You have logged out successful <br>");
						
						pw.print("Last entered dtls "+c.getValue());
						c.setMaxAge(0);
						//must re send the cookie to clnt browser
						response.addCookie(c);//IMPORTANT
						break;
					}
			} else
				pw.print("No cookies....: no session tracking!!!");
			pw.print("<h5><a href='login.html'>Visit Again</a>");
		}
	}

}
