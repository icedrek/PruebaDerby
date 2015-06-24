import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Principal {
	
	public static void main(String[] args) 
	{
		final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
		final String DB_URL = "jdbc:derby:Gimnasio;create=true";
				
		try 
		{
			Class.forName(DB_DRIVER).newInstance();
			Connection conn = DriverManager.getConnection(DB_URL);
			
			String query = ("SELECT * FROM USERS");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int numcol = rsmd.getColumnCount();
			
			StringBuffer sb = new StringBuffer();
			
			for(int i = 1 ; i<numcol;i++){
				sb.append(rsmd.getColumnLabel(i) + "   ");
							
			}
			System.out.println(sb);	
			while (rs.next())
			{
				System.out.println(rs.getInt("USER_ID") + " " +rs.getString("USER_NAME"));
			}
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
				
	}

}
