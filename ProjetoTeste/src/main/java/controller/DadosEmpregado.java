package controller;

import java.io.IOException;

import dao.EmployeeDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;
/**
 * Servlet implementation class DadosEmpregado
 */
@WebServlet("/dadosEmpregado")
public class DadosEmpregado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmployeeDao employeeDAO = new EmployeeDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DadosEmpregado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	        String username = (String) request.getAttribute("username");
	        String password = (String) request.getAttribute("password");
			
			System.out.println("DoGet"+username);
			System.out.println(password);
					
			Employee employee = new Employee();
			employee.setUsername(username);
			employee.setPassword(password);
			Employee dataEmployee = new Employee();
			
			try {
				dataEmployee = employeeDAO.detailsEmployee(username, password);
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("name", dataEmployee.getFirstName());
			request.setAttribute("lastName", dataEmployee.getLastName());
			request.setAttribute("address", dataEmployee.getAddress());
			request.setAttribute("contact", dataEmployee.getContact());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
