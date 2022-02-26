package mynotesapp;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Reminders {

	protected int id;
	
	protected int userid;
	
	protected String startdate;
	
	protected String enddate;
	
	protected String task;

	public Reminders(int id, int userid, String startdate, String enddate, String task) {
		super();
		this.id = id;
		this.userid = userid;
		this.startdate = startdate;
		this.enddate = enddate;
		this.task = task;
	}
	
	public Reminders(int userid, String startdate, String enddate, String task) {
		super();
		this.userid = userid;
		this.startdate = startdate;
		this.enddate = enddate;
		this.task = task;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	
	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
	public boolean createReminder (int id) {
				try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection con = DriverManager.getConnection(
				 "jdbc:mysql://localhost:3306/mynotesapp", "root", "password");
				//Step 4: implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
				 PreparedStatement ps = con.prepareStatement("insert into REMINDERS (startdate, enddate, task) values(?,?,?)");
				//Step 5: parse in the data retrieved from the web form request into the prepared statement accordingly
				 ps.setString(1, startdate);
				 ps.setString(2, enddate);
				 ps.setString(3, task);
				//Step 6: perform the query on the database using the prepared statement
				 int i = ps.executeUpdate();
				//Step 7: check if the query had been successfully execute, return “You are successfully registered” via the response,
				 if (i > 0){
//				PrintWriter writer = response.getWriter();
//				writer.println("<h1>" + "You have successfully created a reminder!" +
//				"</h1>");
//				writer.close();
				 	} return true;
				 }
				//Step 8: catch and print out any exception
				catch (Exception exception) {
				 System.out.println(exception);
				 return false;
				}
	}
	
	public boolean getReminder(int id) {
		List<Reminders> reminder = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REMINDERS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				int i = rs.getInt("id");
				String startdate = rs.getString("startdate");
				String enddate = rs.getString("enddate");
				String task = rs.getString("task");
				reminder.add(new Reminders(id, startdate, enddate, task));
				System.out.println(id);
			} return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean updateReminder(int id) {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_REMINDERS_SQL);) {
			statement.setInt(1, id);
			statement.setString(2, startdate);
			statement.setString(3, enddate);
			statement.setString(4, task);
			statement.setInt(5, id);
			int i = statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// Step 3: redirect back to UserServlet (note: remember to change the url to
			// your project name)
			return false;
		}
	}
	
	public boolean deleteReminder (int id) {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_REMINDERS_SQL);){
			statement.setInt(1,id);
			int i = statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

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
}
