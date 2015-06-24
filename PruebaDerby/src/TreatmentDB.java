import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TreatmentDB {
	private Connection _connection = null;
	private final static String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private final static String DB_URL = "jdbc:derby:Gimnasio;create=true";
	
	public TreatmentDB(){}
	
	public void  CreateConnection()
	{
		try 
		{
			Class.forName(DB_DRIVER).newInstance();
			setConnection(DriverManager.getConnection(DB_URL));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() 
	{
		return _connection;
	}

	public void setConnection(Connection _connection) 
	{
		this._connection = _connection;
	}
	
	public User getUsers(int userId)
	{
		
		UsersDB udb = new UsersDB(getConnection());
		User u = udb.getOneUser(userId);				
		
		return u;
		
	}
}
