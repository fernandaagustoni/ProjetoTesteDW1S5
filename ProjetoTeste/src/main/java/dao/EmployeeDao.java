package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;


public class EmployeeDao {
    int id = 0;
	 public int registerEmployee(Employee employee) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO employee" +
	            "  (id, first_name, last_name, username, password, address, contact) VALUES " +
	            " (?, ?, ?, ?, ?,?,?);";

	        int result = 0;
	        id = id + 1;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, id);
	            preparedStatement.setString(2, employee.getFirstName());
	            preparedStatement.setString(3, employee.getLastName());
	            preparedStatement.setString(4, employee.getUsername());
	            preparedStatement.setString(5, employee.getPassword());
	            preparedStatement.setString(6, employee.getAddress());
	            preparedStatement.setString(7, employee.getContact());

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }
	 
	 public int getLoginEmployee(String u, String p) throws ClassNotFoundException {
	        String SELECT_USERS_SQL = "SELECT first_name, last_name from employee" +
	            "  WHERE username = ? AND password = ?;";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_SQL)) {
	        	preparedStatement.setString(1, u);
	            preparedStatement.setString(2, p);
	            

	            ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("first_name"));
					System.out.println(rs.getString("last_name"));
		
					result = 1;
				}

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }
	 
	 public Employee detailsEmployee (String u, String p) throws ClassNotFoundException {
			String LOGIN_USERS_SQL = "SELECT first_name, last_name, address, contact FROM employee "
					+ "WHERE username = ? AND password = ?;";
			Class.forName("com.mysql.jdbc.Driver");
			
			try (Connection connection = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/employees", "root", "");
					
					PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_USERS_SQL)){;
					
					preparedStatement.setString(1, u);
					preparedStatement.setString(2, p);
					
					System.out.println("Entrei");
					
					ResultSet rs1 = preparedStatement.executeQuery();
					while (rs1.next()) {
						System.out.println(rs1.getString("first_name"));
						System.out.println(rs1.getString("last_name"));
						System.out.println(rs1.getString("address"));
						System.out.println(rs1.getString("contact"));
						
						Employee loginEmployee = new Employee();
						loginEmployee.setFirstName(rs1.getString("first_name"));
						loginEmployee.setLastName(rs1.getString("last_name"));
						loginEmployee.setAddress(rs1.getString("address"));
						loginEmployee.setContact(rs1.getString("contact"));
						return loginEmployee;
					}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		}

}
