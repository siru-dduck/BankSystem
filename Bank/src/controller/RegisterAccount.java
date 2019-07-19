package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Bankdao;
import dto.Accountdto;

/**
 * Servlet implementation class RegisterAccount
 */
@WebServlet("/registerAccount")
public class RegisterAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/registeraccount.jsp");
		rs.forward(request, response);
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bankdao dao = new Bankdao();
		Accountdto account = new Accountdto();
		account.setAccountnumber(request.getParameter("number"));
		account.setAccountpassword(request.getParameter("pass"));
		account.setBalance(Integer.parseInt(request.getParameter("money")));
		account.setOwnerpinnumber(request.getParameter("pin"));
		//dao.createAccount(account);
		System.out.println(dao.createAccount(account));
		response.sendRedirect("/Bank");
	}
}
