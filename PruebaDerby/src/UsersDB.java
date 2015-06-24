import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersDB
{
	private        Connection        _conn      = null;
	private static StringBuffer      _query     = new StringBuffer();
	private static Statement         _statement = null;
	private static ResultSet         _resultSet = null;
	private static ResultSetMetaData _metadata  = null;	
	
	public UsersDB() {}
	
	public UsersDB(Connection c) 
	{
		this._conn = c;
	}
	
	public void addUser(Connection c, String name, int routinId) 
	{
		if(_conn == null && c != null)
		{
			_conn = c;			
		}
		
		_query.append(" INSERT INTO USERS");
		_query.append(" (USER_NAME, ROUTINE_ID, DATA_CREATED)");
		_query.append(" VALUES('");
		_query.append(name);
		_query.append("', ");
		_query.append(routinId);
		_query.append(", CURRENT_TIMESTAMP)");
	
		try 
		{	
			_statement = _conn.createStatement();			
			_statement.execute(String.valueOf(_query));
			_statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			_query = null;			
		}
		
	}
	
	public ResultSet getAllUsers() 
	{
		
		_query.append("SELECT * FROM USERS");
		
		try 
		{			
			_statement = _conn.createStatement();
			_resultSet=_statement.executeQuery(String.valueOf(_query));
			_statement.close();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			
		} catch (Exception exception) {
			exception.printStackTrace();
			
		} finally {
			_query = null;		
		}
		
		return _resultSet;
	}
	
	public User getOneUser(int userId) 
	{				
		_query.append("SELECT * FROM USERS");
		_query.append("WHERE USER_ID = ");
		_query.append(userId);
		User u = new User();
		
		try 
		{
			_statement = _conn.createStatement();
			_resultSet = _statement.executeQuery(String.valueOf(_query));
			_metadata = _resultSet.getMetaData();	
								
			System.out.println(_resultSet.getRow());
            while(_resultSet.next())
            {
            	System.out.println(_resultSet.getInt(1)+ _resultSet.getString(2));
            	u.setId(_resultSet.getInt(1));
            	u.setName(_resultSet.getString(2));
            	u.setLastName(_resultSet.getString(3));
            	u.setPhone(_resultSet.getInt(4));
            	u.setMail(_resultSet.getString(5));
            	u.setRoutineId(_resultSet.getInt(6));            	              
            }
            _resultSet.close();
            _statement.close();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			_query = null;
		}
		
		return u;
	}

	public void updateUser(int userId, String name, String lastName, int phone, String mail, int routineId)
	{
		_query.append("UPDATE USERS ");
		_query.append("SET USER_NAME = '");
		_query.append(name);
		_query.append("', USER_LASTNAME = '");
		_query.append(lastName);
		_query.append("', USER_PHONE = ");
		_query.append(phone);
		_query.append(", USER_MAIL = '");
		_query.append(mail);
		_query.append("', ROUTINE_ID = ");
		_query.append(routineId);
		_query.append(", DATA_MODIFY = CURRENT_TIMESTAMP");
		_query.append(" WHERE USER_ID = ");
		_query.append(userId);	
		
		try 
		{		
			_statement = _conn.createStatement();
			_statement.execute(String.valueOf(_query));
			_statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			_query = null;			
		}
	}

	public void removeUser(int userId) 
	{
		_query.append(" DELETE FROM USERS");
		_query.append(" WHERE USER_ID =");
	
		try 
		{			
			_statement = _conn.createStatement();
			_statement.execute(String.valueOf(_query));
			_statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			_query = null;			
		}
		
	}
}
