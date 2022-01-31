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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/insert":
				 break;
				 case "/delete":
				 break;
				 case "/edit":
				 break;
				 case "/update":
				 break;
				 default:
				 listNotes(request, response);
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
	// Step 1: Prepare list of variables used for database connections
		private String jdbcURL = "jdbc:mysql://localhost:3306/mynotesapp";
		private String jdbcUsername = "root";
		private String jdbcPassword = "password";
		// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
		// database
		private static final String INSERT_NOTES_SQL = "INSERT INTO notes"
				+ " (userid,title,note,datetime) VALUES " + " (?, ?, ?,?);";
		private static final String SELECT_NOTE_BY_USERID = "select userid,title,note,datetime from notes where userid =?;";
		private static final String SELECT_ALL_NOTES = "select * from notes ";
		private static final String DELETE_NOTES_SQL = "delete from notes where userid = ?;";
		private static final String UPDATE_NOTES_SQL = "update notes set title = ?,note= ?,datetime=? where userid = ?;";

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
