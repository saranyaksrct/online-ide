

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class servlet1
 */
@WebServlet("/mainservlet")
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet1() {
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
					String us=request.getParameter("us");
					String ps=request.getParameter("pw");
					//System.out.println(us);	
					password pa=new password();
					boolean check=pa.checkpassword(us, ps);
					if(check)
					{
						HttpSession session=request.getSession();
						session.setAttribute("usern", us);
						session.setAttribute("pswrd", ps);
						request.setAttribute("us",us);
						request.setAttribute("ps", ps);
						RequestDispatcher rd=request.getRequestDispatcher("ui.jsp");
						//rd.include(request, response);
						rd.forward(request, response);
					}
					else
					{
						response.setContentType("text/html");
						PrintWriter out=response.getWriter();
						RequestDispatcher rd=request.getRequestDispatcher("home.html");
						rd.include(request, response);
						out.println("<center>");
						out.println("<h2>");
						out.println("Sorry,your username or password is incorrect!");
						out.println("</h2>");
						out.println("</center>");
					}
				}
	}

}
