package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

/**
 * Servlet implementation class DoRegister
 */
@WebServlet("/doRegister")
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");

		Customer customer = new Customer(id, password, name, gender, email);
		request.setAttribute("customer", customer);
		CustomerService service = (CustomerService) CustomerService.getInstance();

		service.addCustomer(customer);

		String page = null;

		page = "/view/registerSuccess.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
}
