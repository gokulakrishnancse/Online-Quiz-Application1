package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet2() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String name=request.getParameter("name");
			String password=request.getParameter("pass");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb1","root","1234");
			
			out.println("<h1 style='color:red'>Your Registration successfully</h1>");
			
			Statement st=con.createStatement();
			st.executeUpdate("insert into table2 values('"+name+"','"+password+"')");
			//out.println("data inserted successfully");
		
			out.println("<a href='login.html'>Login</a>");
			}catch(Exception e){
				e.printStackTrace();
			}
	}

}
