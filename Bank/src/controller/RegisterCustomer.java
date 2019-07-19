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
 * Servlet implementation class RegisterCustomer
 */
@WebServlet("/registerCustomer")
public class RegisterCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();;
		BankService service = new BankService();
	    request.setCharacterEncoding("EUC-KR");

		if(request.getParameter("id")!=null && request.getParameter("password")!=null && request.getParameter("name")!=null && 
				request.getParameter("pinnum1")!=null && request.getParameter("pinnum2")!=null && request.getParameter("address")!=null &&
				!request.getParameter("id").isEmpty() && !request.getParameter("password").isEmpty() && !request.getParameter("name").isEmpty() &&
				!request.getParameter("pinnum1").isEmpty() && !request.getParameter("pinnum2").isEmpty() && !request.getParameter("address").isEmpty()) {

			service = new BankService();
			Customerdto dto = new Customerdto();
			dto.setBankid(request.getParameter("id"));
			dto.setBankpassword(request.getParameter("password"));
			dto.setName(request.getParameter("name"));
			dto.setAddress(request.getParameter("address"));
			dto.setPinnumber(request.getParameter("pinnum1")+"-"+request.getParameter("pinnum2"));
			if(service.regiserCustomer(dto)) {
				session.removeAttribute("registerCustomerMSG");
				session.setAttribute("loginMSG", "회원가입에 성공하였습니다. 로그인 해주세요.");
				response.sendRedirect("login.jsp");
			}

			else {
				session.setAttribute("registerCustomerMSG", "회원가입에 실패하였습니다, 다시 시도해주세요.");
				response.sendRedirect("registerCustomer.jsp");
			}
		}
		else {
			session.setAttribute("registerCustomerMSG", "회원정보를 정확히 입력하세요.");
			response.sendRedirect("registerCustomer.jsp");
		}
	}

}
