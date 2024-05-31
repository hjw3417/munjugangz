package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		
		String data = "안녕하세요!<br> 로그인하셨습니다.<br><br>";
        data += "<html><body>";
        data += "아이디 : " + user_id;
        data += "<br>";
        data += "비밀번호 : " + user_pw;
        data += "<br>";
        data += "주소 : " + user_address;
        data += "<br>";
        data += "email : " + user_email;
        data += "<br>";
        data += "휴대 전화 : " + user_hp;
        data += "</html></body>";
        out.print(data);
    }

    public void destroy() {
        System.out.println("destroy 메서드 호출");
    }
}
