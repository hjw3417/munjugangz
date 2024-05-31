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
@WebServlet("/login7")
public class LoginServlet extends HttpServlet {

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
		
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pwd);
		
		MemberDAO dao = new MemberDAO();
		
		boolean result = dao.isExited(memberVO);
		
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pwd);
			out.print("<html><body>");
			out.print("안녕하세요. " + user_id + "님!!!<br>");
			out.print("<a href='show'>회원 정보 보기</a>");
			out.print("</body></html>");
		} else {
			out.print("<html><body><center>회원 아이디가 틀립니다.");
			out.print("<a href='login7.html'>다시 로그인 하기</a>");
			out.print("</body></html>");
		}
		
	}

}
