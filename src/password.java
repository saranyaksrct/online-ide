

	import java.sql.Connection;

	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;


	public class password {
		Connection cn=database.getDBConnection();
		PreparedStatement p;
		public boolean checkpassword(String us, String ps)
		{
			String aa=null;
			try
			{
				p=cn.prepareStatement("select password from login where username=?");
				p.setString(1, us);
				ResultSet rs=p.executeQuery();
				while(rs.next()){
				aa=rs.getString(1);
				}
				if(ps.equals(aa))
						{
					return true;
						}
				cn.close();
			}
	  catch (SQLException e) {
		  System.out.println(e.getMessage());
		return false;
	}
			return false;
			
		}

	}


