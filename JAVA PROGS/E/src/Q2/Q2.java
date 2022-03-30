package Q2;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;

public class Q2 {

	public static void main(String args[])throws ClassNotFoundException
	{
		String dbName="student5";
		try
		{
			Connection con=DBConnection.initialize(dbName);
			String query1="SELECT * FROM student55 WHERE cgpa<9";
			String query2="SELECT * FROM student55";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query1);
			while(rs.next())
			{
				String usn=rs.getString(1);
				String name=rs.getString(2);
			    Float cgpa=rs.getFloat(3);
			    System.out.println("usn,name,cgpa: " + usn+ ", "+name+", " +cgpa);
			}
			
			  st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			  rs=st.executeQuery(query2);
			  System.out.println("updated");
			  while(rs.next())
			  {
				  if(rs.getString(2).equals("john"))
				  {
					  rs.updateDouble(3,8.9);
					  rs.updateRow();
				  }
				  
				  
				  
				  String usn=rs.getString(1);
					String name=rs.getString(2);
				    Float cgpa=rs.getFloat(3);
				    System.out.println("usn,name,cgpa: " + usn+ ", "+name+", " +cgpa);
				} 
			  }
		catch(Exception e)
		{
			e.printStackTrace();
			
			
		}
		
		
	}
		
	}
	


