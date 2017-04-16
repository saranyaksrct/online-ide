

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;


/**
 * Servlet implementation class servlet2
 */
@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("submit").equals("submit"))
		{
			String username=request.getParameter("username");
			String emailid=request.getParameter("emailid");
			String password=request.getParameter("password");
			String confirmpassword=request.getParameter("confirmpassword");
			int i=0;
			if(username!=null && emailid!=null && password!=null && confirmpassword!=null && password.length()>=8 && password.length()<=15 && password.equals(confirmpassword))
			{
				
				try
				{
					Connection cn=database.getDBConnection();//to connect database
					PreparedStatement ps=cn.prepareStatement("insert into login values(?,?,?,?)");//query to be execute
					ps.setString(1, username);
					ps.setString(2, emailid);
					ps.setString(3, password);
					ps.setString(4, confirmpassword);
					i=ps.executeUpdate();//query execution
				
				}
				catch(SQLException e)
				{
					e.printStackTrace();			
				}
				if(i>0)
				{
					System.out.println("Insertion successful");
					RequestDispatcher rd=request.getRequestDispatcher("ui.jsp");
					rd.forward(request, response);
				
				}
				else
					System.out.println("Insetion not successful");
			
			}
			else
			{
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				RequestDispatcher rd=request.getRequestDispatcher("signup.html");
				rd.include(request, response);//include the content in request object to signup page
				out.println("<left>");
				out.println("Please enter the valid Inputs");
				out.println("</left>");
			}
		}
	}

}

