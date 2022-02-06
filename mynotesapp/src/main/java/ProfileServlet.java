

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		 try {
		 switch (action) {
		 case "/ProfileServlet/edit":
			 showUpdateForm(request, response);
			 break; 
			 case "/ProfileServlet/update":
				 updateProfile(request, response);
				 break;
			 case "/ProfileServlet/profile":
				 listUser(request, response);
				 break; 
		
		 }
		 } catch (SQLException ex) {
		 throw new ServletException(ex);
		 }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
    private String jdbcURL = "jdbc:mysql://localhost:3306/mynotesapp";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	// CRUD Statements
//	private static final String INSERT_USERS_SQL = "INSERT INTO UserDetails" + " (name, password, email, language) VALUES " + " (?, ?, ?);";
	
	private static final String UPDATE_USERS_SQL = "update USERSINFO set id=?, username = ?,password= ?,email =?,address =?, phone =? where id = ?;";
	private static final String SELECT_USER_BY_ID = "select id,username,password,email,address,phone from USERSINFO where id =?";

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

	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List <Admin> users = new ArrayList<>();
		try (Connection connection = getConnection();
// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
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
				System.out.println(username + password);
				users.add(new Admin(id, username, password, email, address, phone));
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error!!!");
		}
// Step 5.4: Set the users list into the listUsers attribute to be pass to the
// userManagement.jsp
		request.setAttribute("listUser", users);
		request.getRequestDispatcher("/Profile.jsp").forward(request, response);
	}
	
	
	
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
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
		request.getRequestDispatcher("/editProfile.jsp").forward(request, response);
	}
	private void updateProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
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
				HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect("http://localhost:8090/mynotesapp/login.jsp");				
			} 


}
