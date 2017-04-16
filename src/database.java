

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class database 
{
	public static Connection getDBConnection()
	{
		Connection con=null;
		try
		{		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl1","hr","hr");
			System.out.println(con);
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.out.println("error");
			e.printStackTrace();
		}
		return con;
	}

}
