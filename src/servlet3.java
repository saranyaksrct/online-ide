


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet3
 */
@WebServlet("/servlet3")
public class servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet3() {
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
		String act=request.getParameter("action");//to get input from jsp file
		if(act.equals("compile") || act.equals("run"))
		{
			System.out.println("Entered.."+ "");
			String filename=request.getParameter("filename");
			String language=request.getParameter("language");
			String code=request.getParameter("hide");
			
			String input=request.getParameter("tx2");
			FileOutputStream fop1=null;
			File files1;
			files1=new File("D:\\prpproject\\server\\input.txt");//to create file for input
			fop1=new FileOutputStream(files1);
		
		    if(!files1.exists())
			files1.createNewFile();
		    byte[] contentInBytes1=input.getBytes();//to get data from string and store it in bytes
		    fop1.write(contentInBytes1);// to write file
		    fop1.flush();
		    fop1.close();
			String file="";
			switch(language)
			{
			case "C":
				file=filename+".c";
				break;
			case "C++":
				file=filename+".cpp";
				break;
			case "JAVA":
				file=filename+".java";
				String dir="D:\\prpproject\\server\\"+filename;//path for file
				boolean success=(new File(dir)).mkdir();// create a new file in java
				if(success)
				{
					System.out.println("directory created");
				}
				break;
			case "C#":
				file=filename+".cs";
				break;
			}
			String a[]={filename,language,file};
			String b[]={filename,language};
			FileOutputStream fop=null;
			File files;
			try
			{
				if(language.equals("JAVA"))
				files=new File("D:\\prpproject\\server\\"+filename+"\\"+file);
				else
				files=new File("D:\\prpproject\\server\\"+file);
				fop=new FileOutputStream(files);
			
			if(!files.exists())
				files.createNewFile();
			byte[] contentInBytes=code.getBytes();
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
			System.out.println("Done...");
			if(act.equals("compile"))
			{
				System.out.println("compile");
				String sbc=compile.compcall(a);//calling compiling function
				System.out.println(sbc.length());
				if(sbc.isEmpty())
					request.setAttribute("output","compiled successfully");
				else
					request.setAttribute("output",sbc);
			
			}
			else if(act.equals("run"))
			{
				System.out.println("run");
				String sbc=compile.compcall(a);
				if(sbc.isEmpty())
				{
					String sbr=run.runcall(b);//calling run function
					request.setAttribute("output", sbr);
				}
				else
					request.setAttribute("output", sbc);
				
			}
			request.setAttribute("language",language);
			request.setAttribute("filename", filename);
			request.setAttribute("hide", code);
			request.setAttribute("tx2",input);
			RequestDispatcher rd=request.getRequestDispatcher("/ui.jsp");//redirecting to jsp page
			rd.include(request, response);
		    }
			catch(IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					if(fop!=null)
						fop.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			
		}
	}

}
