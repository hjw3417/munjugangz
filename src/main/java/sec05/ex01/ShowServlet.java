package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = "", pwd = "";
		boolean isLogon = false;
		HttpSession session = request.getSession();
		
		if(session != null) {
			isLogon = (Boolean) session.getAttribute("isLogon");
			if(isLogon) {
				id = (String) session.getAttribute("login.id");
				pwd = (String) session.getAttribute("login.pwd");
				out.print("<html><body>");
				out.print("아이디: " + id +"<br>");
				out.print("비밀번호: " + pwd +"<br>");
				out.print("</body></html>");
			} else {
				response.sendRedirect("login3.html");
			}
		}else {
			response.sendRedirect("login3.html");
		}
	}

}
