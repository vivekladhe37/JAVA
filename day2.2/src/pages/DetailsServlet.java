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
 * Servlet implementation class DetailsServlet
 */
@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h4>Login Successful</h4>");
			// get cookie/s from request hdr
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies)
					if (c.getName().equals("cust_dtls")) {
						pw.print("Details : " + c.getValue());
						break;
					}
			} else
				pw.print("No cookies....: no session tracking!!!");
			pw.print("<h5><a href='logout'>Log Me Out</a>");

		}
	}

}
