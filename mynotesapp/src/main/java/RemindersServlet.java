
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemindersServlet
 */
@WebServlet("/RemindersServlet")
public class RemindersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemindersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/RemindersServlet/delete":
				deleteReminder(request, response);
				break;
			case "/RemindersServlet/edit":
				showEditForm(request, response);
				break;
			case "/RemindersServlet/update":
				updateReminder(request, response);
				break;
			case "/RemindersServlet/dashboard":
				listReminders(request, response);
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

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/mynotesapp";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String INSERT_REMINDERS_SQL = "INSERT INTO reminders" + " (startdate, enddate, task) VALUES " + " (?, ?, ?);";
	private static final String SELECT_REMINDERS_BY_ID = "select id,startdate,enddate,task from reminders where id = ?";
	private static final String SELECT_ALL_REMINDERS = "select * from reminders";
	private static final String DELETE_REMINDERS_SQL = "delete from reminders where id = ?;";
	private static final String UPDATE_REMINDERS_SQL = "update reminders set id = ?, startdate = ?, enddate= ?, task =? where id = ?;";

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// Step 5: listUsers function to connect to the database and retrieve all users
	// records
	private void listReminders(HttpServletRequest request, HttpServletResponse response)

			throws SQLException, IOException, ServletException {

		List<Reminders> reminder = new ArrayList<>();

		try (Connection connection = getConnection();

// Step 5.1: Create a statement using connection object

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REMINDERS);) {

// Step 5.2: Execute the query or update query

			ResultSet rs = preparedStatement.executeQuery();

// Step 5.3: Process the ResultSet object.

			while (rs.next()) {

				int id = rs.getInt("id");

				String startdate = rs.getString("startdate");

				String enddate = rs.getString("enddate");

				String task = rs.getString("task");

				reminder.add(new Reminders(id, startdate, enddate, task));
				System.out.println(id);
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

// Step 5.4: Set the users list into the listUsers attribute to be pass to the

// userManagement.jsp

		request.setAttribute("listReminders", reminder);
		// System.out.println(reminder);
		request.getRequestDispatcher("/reminderManagement.jsp").forward(request, response);

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		int id = Integer.parseInt(request.getParameter("id"));
		Reminders existingReminder = new Reminders("", "", "");
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REMINDERS_BY_ID);) {
			preparedStatement.setInt(1, id);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				id = rs.getInt("id");
				String startdate = rs.getString("startdate");
				String enddate = rs.getString("enddate");
				String task = rs.getString("task");
				existingReminder = new Reminders(id, startdate, enddate, task);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("reminder", existingReminder);
		request.getRequestDispatcher("/reminderEdit.jsp").forward(request, response);
	}

	// method to update the user table base on the form data
	private void updateReminder(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		int id = Integer.parseInt(request.getParameter("id"));
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String task = request.getParameter("task");

		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_REMINDERS_SQL);) {
			statement.setInt(1, id);
			statement.setString(2, startdate);
			statement.setString(3, enddate);
			statement.setString(4, task);
			statement.setInt(5, id);

			int i = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// Step 3: redirect back to UserServlet (note: remember to change the url to
			// your project name)
		}
			response.sendRedirect("http://localhost:8090/mynotesapp/RemindersServlet/dashboard");
		}

	private void deleteReminder(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
			//Step 1: Retrieve value from the request
			 int id = Integer.parseInt(request.getParameter("id"));
			 //Step 2: Attempt connection with database and execute delete user SQL query
			 try (Connection connection = getConnection(); PreparedStatement statement =
			connection.prepareStatement(DELETE_REMINDERS_SQL);) {
					statement.setInt(1, id);
			 int i = statement.executeUpdate();
			 }
			 catch (SQLException e) {
					System.out.println(e.getMessage());
					// Step 3: redirect back to UserServlet (note: remember to change the url to
					// your project name)
				}
			 //Step 3: redirect back to UserServlet dashboard (note: remember to change the url to your project name)
			 response.sendRedirect("http://localhost:8090/mynotesapp/RemindersServlet/dashboard");
			}
	
}
