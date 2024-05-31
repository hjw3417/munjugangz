package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/login5")
public class SessionTest4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
		}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		if(session.isNew()) {
			if(user_id != null) {
				session.setAttribute("user_id", user_id);
				out.println("<a href='login5'>로그인 상태 확인</a>");
			} else {
				out.print("<a href='login2.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		} else {
			user_id = (String) session.getAttribute("user_id");
			if(user_id != null && user_id.length() != 0) {
				out.print("안녕하세요 " + user_id + "님!!");
			} else {
				out.print("<a href='login2.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}
		
	}

}
