import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class ConsultaUserDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		String dbName="Gimnasio";
		String connectionURL = "jdbc:derby:" + dbName + ";create=true";	
		Connection conn = null;

		try{
		  Class.forName(driver);
		} catch(java.lang.ClassNotFoundException e) {
		  e.printStackTrace();
		}

		try {
		  conn = DriverManager.getConnection(connectionURL);

		  Statement st = conn.createStatement();
		  ResultSet rs=st.executeQuery("SELECT * FROM USERS");
		  ResultSetMetaData metadata = rs.getMetaData();
		  
	        //Imprimimos la cabecera de la tabla
	        int columnas = metadata.getColumnCount();
	        for (int i = 1; i <= columnas; i++) {
	            System.out.format("%15s", metadata.getColumnName(i) + " || ");
	        }
	 
	        while (rs.next()) {
	            //Imprimimos cada una de las filas de la tabla
	            System.out.println("");
	            for (int j = 1; j <= columnas; j++) {
	                 System.out.format("%15s", rs.getString(j) + " || ");
	            }
	        }
	 
	        if (st != null)  st.close();
	        if (conn != null)  conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		} catch (Throwable e)  {   
			   e.printStackTrace();
			   }
	}

}
