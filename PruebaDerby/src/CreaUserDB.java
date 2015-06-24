import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class CreaUserDB 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		TreatmentDB tdb = new TreatmentDB();
			
		tdb.CreateConnection();
		System.out.println("Conexión Creada");
		
		User u = tdb.getUsers(1);
		
		System.out.println(u.getId());
		System.out.println("\n" + u.getName());
		System.out.println("\n" + u.getLastName());
		System.out.println("\n" + u.getPhone());
		System.out.println("\n" + u.getMail());
		System.out.println("\n" + u.getRoutineId());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		TreatmentDB tdb = new TreatmentDB();
		String name = "Neus";
		int routinId = 12345;
		Connection conn = null;
		UsersDB usersDB = new UsersDB();
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		CreaDB creaDb = new CreaDB(conn);
		
		String dbName="Gimnasio";
		StringBuffer connectionURL = new StringBuffer("jdbc:derby:");
			connectionURL.append(dbName);
			connectionURL.append(";create=true");					

		tdb.CreateConnection();
		
		try {
			Statement s = tdb.getConnection().createStatement();
			
			UsersDB udb = new UsersDB(tdb.getConnection());
			s.getResultSet()
			ResultSet results = udb.getAllUsers();
		//ResultSetMetaData rsmd = results.getMetaData();


				 while(results.next())
		            {
		                int id = results.getInt(1);
		                String restName = results.getString(2);
		                String cityName = results.getString(3);
		                System.out.println(id + "\t\t" + restName + "\t\t" + cityName);
		            }
		            results.close();

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			try 
			{
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(String.valueOf(connectionURL));		    
			    creaDb.Users(conn);
			    usersDB.addUser(conn, name, routinId);
			    
			} catch(SQLException e) {
				System.out.println(e.getMessage() + e.getErrorCode());
				System.out.println("\n" + e.getSQLState());
				e.printStackTrace();

				try {
					conn = DriverManager.getConnection(String.valueOf(connectionURL));
					usersDB.addUser(conn, name, routinId);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}  catch (Throwable e)  {   
			   e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	*/		
	}		
}
