package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Customerdto;
import service.BankService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/loginCheck")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankService service = null;
	private HttpSession session;
	private Customerdto customer;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    




	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session=request.getSession();
		
		if(session.getAttribute("login") !=null) {
		session.removeAttribute("login");
		response.sendRedirect("/Bank");
		}
		else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("bankid")!=null && request.getParameter("password").toString()!=null && 

				!request.getParameter("bankid").isEmpty() && !request.getParameter("password").toString().isEmpty()) {

			service = new BankService();

			if(service.loginCheck(request.getParameter("bankid"), request.getParameter("password").toString())) {

				 session= request.getSession();
				session.removeAttribute("loginMSG");

				session.setAttribute("login", request.getParameter("bankid"));
				System.out.println("session was created");
				
				response.sendRedirect("index.jsp");

			}

			else {

				session.setAttribute("loginMSG", "로그인에 실패하였습니다.");

				response.sendRedirect("login.jsp");

			}

			

		}

		else {

			session.setAttribute("loginMSG", "아이디와 비밀번호를 정확히 입력하세요.");

			response.sendRedirect("login.jsp");

		}

		

	}
}