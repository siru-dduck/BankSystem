package controller;

import java.io.IOException;
import java.time.LocalDate;
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
 * Servlet implementation class Transaction
 */
@WebServlet("/Transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<Accountdto> accounts;
    private ArrayList<String> accountnumbers;
    private Bankdao bankdao;
    private HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		accounts = new ArrayList();
		accountnumbers = new ArrayList();
		session = request.getSession();
		bankdao = new Bankdao();
		
		accounts = bankdao.readAccountByOwnerPinnumber(bankdao.getpinnumber((String)session.getAttribute("login")));
		for(Accountdto a:accounts) {
			accountnumbers.add(a.getAccountnumber());
		}
		
		request.setAttribute("account",accountnumbers );
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/transaction.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int money = Integer.parseInt(request.getParameter("sendmoney"));
		String receive = request.getParameter("receiveaccount");
		String send = request.getParameter("checkaccount");
		
		bankdao = new Bankdao();
		boolean result = bankdao.sendmoney(send, receive, money);
		
		if(result) {
			
		}
		else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/fail.jsp");
			dispatcher.forward(request, response);
		}

		
	}

}