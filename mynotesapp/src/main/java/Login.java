

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String n = request.getParameter("username");
		String p = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		try { 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/users", "root", "password");	
			 PreparedStatement pst = con.prepareStatement("select * from USERSINFO where username = ? and password = ?");
			 pst.setString(1, n);
			 pst.setString(2, p);			 
			 
			 ResultSet rs = pst.executeQuery();
			 if (rs.next()) {
				 session.setAttribute("id", rs.getInt("id"));
				 session.setAttribute("username", rs.getString("username"));
				 session.setAttribute("password", rs.getString("password"));
				 session.setAttribute("email", rs.getString("email"));
				 session.setAttribute("phone", rs.getString("address"));
				 session.setAttribute("address", rs.getString("phone"));

				 dispatcher = request.getRequestDispatcher("index.jsp");
//				 dispatcher = request.getRequestDispatcher("Profile.jsp");

				 
			 } else {
				 request.setAttribute("status", "failed");
				 dispatcher = request.getRequestDispatcher("login.jsp");
			 }
			 dispatcher.forward(request, response);
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
