
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
 
public class ConsultaBaseDeDatos {
 
    /**
    * @param args
    * @throws SQLException
    */
    public static void main(String[] args) throws SQLException {
 
        Connection con = DriverManager.getConnection("jdbc:derby:bbddnotodocodigo;create=true");
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from usuario");
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
 
        if (statement != null)  statement.close();
        if (con != null)  con.close();
    }
}