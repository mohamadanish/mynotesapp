
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();
		 try {
		 switch (action) {
		 case "/insert":
			 break;
		 case "/AdminServlet/delete":
				deleteUser(request, response);
				break;
			 case "/AdminServlet/edit":
				 showEditForm(request, response);
				 break; 
			 case "/AdminServlet/update":
				 updateUser(request, response);
				 break;
			 case "/AdminServlet/dashboard":
				 listUsers(request, response);
				 break;
		 }
		 } catch (SQLException ex) {
		 throw new ServletException(ex);
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// Database Connection
	private String jdbcURL = "jdbc:mysql://localhost:3306/mynotesapp";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	// CRUD Statements
//	private static final String INSERT_USERS_SQL = "INSERT INTO UserDetails" + " (name, password, email, language) VALUES " + " (?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select id,username,password,email,address,phone from USERSINFO where id =?";
	private static final String SELECT_ALL_USERS = "select * from USERSINFO ";
	private static final String DELETE_USERS_SQL = "delete from USERSINFO where id = ?;";
	private static final String UPDATE_USERS_SQL = "update USERSINFO set id=?, username = ?,password= ?,email =?,address =?, phone =? where id = ?;";

	// Connection to DB via JDBC
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List <Admin> users = new ArrayList<>();
		try (Connection connection = getConnection();
// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");

				users.add(new Admin(id, username, password, email, address, phone));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
// Step 5.4: Set the users list into the listUsers attribute to be pass to the
// userManagement.jsp
		request.setAttribute("listUsers", users);
		request.getRequestDispatcher("/Admin.jsp").forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Admin existingUser = new Admin("", "", "", "", "");
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				existingUser = new Admin(id, username, password, email, address, phone);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("user", existingUser);
		request.getRequestDispatcher("/userEdit.jsp").forward(request, response);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//Step 1: Retrieve value from the request
				int id = Integer.parseInt(request.getParameter("id"));
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				String phone = request.getParameter("phone");
				System.out.println(address+ username+"REQ");


		//Step 2: Attempt connection with database and execute update user SQL query
				try (Connection connection = getConnection();
						PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
					statement.setInt(1, id);
					statement.setString(2, username);
					statement.setString(3, password);
					statement.setString(4, email);
					statement.setString(5, address);
					statement.setString(6, phone);
					statement.setInt(7, id); // where condition

					System.out.println(address);
				
					int i = statement.executeUpdate();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		//Step 3: redirect back to UserServlet (note: remember to change the url to your project name)
				response.sendRedirect("http://localhost:8090/mynotesapp/AdminServlet/dashboard");
			} 
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		int id = Integer.parseInt(request.getParameter("id"));
		// Step 2: Attempt connection with database and execute delete user SQL query
				try (Connection connection = getConnection();
						PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
					statement.setInt(1, id);
					int i = statement.executeUpdate();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		// Step 3: redirect back to UserServlet dashboard (note: remember to change the
		// url to your project name)
				response.sendRedirect("http://localhost:8090/mynotesapp/AdminServlet/dashboard");
			}
	
	

}
