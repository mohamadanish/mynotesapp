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
 * Servlet implementation class NotesServlet
 */
@WebServlet("/NotesServlet")
public class NotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NotesServlet() {
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
			case "/NotesServlet/delete":
				deleteNote(request, response);
				break;
			case "/NotesServlet/edit":
				showEditForm(request, response);
				break;
			case "/NotesServlet/update":
				updateNote(request, response);
				break;
			case "/NotesServlet":
				listNotes(request, response);
				break; // CHANGED THE SERVLET PATH OVER HERE.
			// DIDNT ADD THE DASHBOARD PATH HERE, CHECK IF I NEED IT OR NOT
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		// String title = request.getParameter("title");
		
		int Id = Integer.parseInt(request.getParameter("id"));
		int Userid = 1;
		Notes existingNote = new Notes(Id, Userid, "", "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NOTE_BY_ID);) {
			preparedStatement.setInt(1, Id);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				int id = rs.getInt("id");
				int userid = rs.getInt("userid");
				String title = rs.getString("title");
				String note = rs.getString("note");
				existingNote = new Notes(id, userid, title, note);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("note", existingNote);
		request.getRequestDispatcher("/noteEdit.jsp").forward(request, response);
	}

	// method to update the user table base on the form data
	private void updateNote(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String note = request.getParameter("note");
		System.out.println(id);
		

		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_NOTES_SQL);) {
			statement.setString(1, title);
			statement.setString(2, note);
			statement.setInt(3, id);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to NotesServlet (note: remember to change the url to
		// your project name)
		response.sendRedirect("http://localhost:8090/mynotesapp/NotesServlet");
	}

	// method to delete note
	private void deleteNote(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		int id = Integer.parseInt(request.getParameter("id"));
		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_NOTES_SQL);) {
			statement.setInt(1, id);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet dashboard (note: remember to change the
		// url to your project name)
		response.sendRedirect("http://localhost:8090/mynotesapp/NotesServlet");
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
	private static final String INSERT_NOTES_SQL = "INSERT INTO notes" + " (userid,title,note,datetime) VALUES "
			+ " (?, ?, ?,?);";
	private static final String SELECT_NOTE_BY_USERID = "select userid,title,note,datetime from notes where userid =?;";
	private static final String SELECT_NOTE_BY_ID = "select * from notes where id=?; ";
	private static final String SELECT_ALL_NOTES = "select * from notes ";
	private static final String DELETE_NOTES_SQL = "delete from notes where userid = ?;"; //DELeTE THE * IF IT DOESNT WORK 
	private static final String UPDATE_NOTES_SQL = "update notes set title = ?,note= ? where id = ?;";

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

	private void listNotes(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		System.out.println("size test");
		List<Notes> notes = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NOTES);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				int userid = rs.getInt("userid");
				String title = rs.getString("title");
				String note = rs.getString("note");
				notes.add(new Notes(id, userid, title, note));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// userManagement.jsp

		request.setAttribute("listNotes", notes);
		request.getRequestDispatcher("/noteManagement.jsp").forward(request, response);
	}

}
