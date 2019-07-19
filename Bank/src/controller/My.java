package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Bankdao;
import dto.Accountdto;


/**
 * Servlet implementation class My
 */
@WebServlet("/My")
public class My extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pinnumber,bankid;
	private ArrayList<dto.Accountdto> accounts;
	private ArrayList<String> accountnumbers;
    private Bankdao bankdao;
    private HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public My() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object check =request.getParameter("update");
		session = request.getSession();
		bankdao = new Bankdao();
		accountnumbers = new ArrayList();
		bankid = (String) session.getAttribute("login");
		if(bankid!=null) {
		if(check==null) {
			accounts = bankdao.readAccountByOwnerPinnumber(bankdao.getpinnumber((String)session.getAttribute("login")));
			
			request.setAttribute("account",accounts );

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mypage.jsp");
		dispatcher.forward(request, response);
		}
		else {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
			dispatcher.forward(request, response);
			
		}}
		else {
			session.setAttribute("loginMSG", "·Î±×ÀÎÀ» ÇÏ½Ã¿À");
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session.removeAttribute("login");
		response.sendRedirect("/Bank");
	}

}