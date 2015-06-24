import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CreaDB 
{
	private Connection _connection = null;
	private Statement _statement = null;
	private StringBuffer _createString = new StringBuffer();
	
	public CreaDB()	{}
	
	public CreaDB(Connection c) 
	{
		this._connection = c;
	}
	
	public void Users(Connection c)	
	{
		if(_connection == null && c != null)
		{
			_connection = c;			
		}
		_createString.append("CREATE TABLE USERS  ");				
		_createString.append("(USER_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), ");
		_createString.append(" USER_NAME VARCHAR(50) NOT NULL,  ");
		_createString.append(" USER_LASTNAME VARCHAR(75),  ");
		_createString.append(" USER_PHONE INT,  ");   		
		_createString.append(" USER_MAIL VARCHAR(32),  ");
		_createString.append(" ROUTINE_ID INT NOT NULL,  ");
		_createString.append(" DATA_CREATED TIMESTAMP NOT NULL,  ");
		_createString.append(" DATA_MODIFY TIMESTAMP,  ");
		_createString.append(" CONSTRAINT primary_key PRIMARY KEY (USER_ID))");
		
		try 
		{					    
			_statement = _connection.createStatement();
			_statement.execute(String.valueOf(_createString));	
			_statement.close();
		    
		} catch(SQLException e) {
			System.out.println(e.getMessage() + e.getErrorCode());
			System.out.println("\n" + e.getSQLState());
			e.printStackTrace();			
		}		
	}
}
