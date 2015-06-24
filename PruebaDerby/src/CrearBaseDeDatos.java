
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class CrearBaseDeDatos {
 
 /**
  * @param args
  * @throws ClassNotFoundException
  * @throws SQLException
  */
 public static void main(String[] args) throws SQLException {
 
    Connection con = DriverManager.getConnection("jdbc:derby:bbddnotodocodigo;create=true");
 
    con.createStatement().execute("create table usuario( id_usuario INT PRIMARY KEY, " +
                                            "nombre varchar(20), " + 
                                            "apellidos varchar(20), " + 
                                            "password varchar(20) )");
    con.createStatement().execute("insert into usuario values " + 
                                            "(5, 'Carlos', 'Garcia', 'notodocodigo') ," +
                                            "(6, 'Pepe', 'Gómez', 'contraseña')");
    con.close();
    System.out.println("Se ha creado la tabla correctamente");
 }
}
