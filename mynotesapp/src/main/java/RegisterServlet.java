

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		response.setContentType("text/html");
		//Step 1: Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		//Step 2: retrieve the four parameters from the request from the web form
		String n = request.getParameter("username");
		String p = request.getParameter("password");
		String e = request.getParameter("email");
		String ph = request.getParameter("phone");
		String a = request.getParameter("address");
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(
			 "jdbc:mysql://localhost:3308/users?useSSL=false", "root", "password");
			 PreparedStatement ps = con.prepareStatement("insert into USERSINFO (username, password, email, address, phone) values(?,?,?,?,?)");
			 ps.setString(1, n);
			 ps.setString(2, p);
			 ps.setString(3, e);
			 ps.setString(4, ph);
			 ps.setString(5, a);

			 
			 int i = ps.executeUpdate();
			 dispatcher = request.getRequestDispatcher("register.jsp");
			 if (i > 0){
				 request.setAttribute("status", "success");
//				 PrintWriter writer = response.getWriter();
//				 writer.println("<h1>" + "You have successfully registered an account!" +
//				 "</h1>");
//				 writer.close();
				 } else {
					 request.setAttribute("status", "failed");

				 }
			 
			 dispatcher.forward(request, response);
		}
		catch (Exception exception ) {
			exception.printStackTrace();
//			 System.out.println(exception);
//			 out.close();
			} finally {
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
