import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

public class Admin {

	protected int id;
	protected String username;
	protected String password;
	protected String email;
	protected String address;
	protected String phone;

	public Admin(String username, String password, String email, String address, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public Admin(int id, String username, String password, String email, String address, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private String jdbcURL = "jdbc:mysql://localhost:3306/mynotesapp";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	// CRUD Statements
//		private static final String INSERT_USERS_SQL = "INSERT INTO UserDetails" + " (name, password, email, language) VALUES " + " (?, ?, ?);";
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

	public boolean deletUser(int id) {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			int i = statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateUser(int id) {
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
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean updateProfile(int id) {
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
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean listUsers() {
		List<Admin> users = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");

				users.add(new Admin(id, username, password, email, address, phone));
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return false;

	}

	public boolean showEditForm(int id) {
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
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return false;
	}
	public boolean showUpdateForm(int id) {
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
			return true;
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	return false;
	}
	
}
