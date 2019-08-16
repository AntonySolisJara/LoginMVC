package Config;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Antony
 */
public class Conexion {
    
    Connection con;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/bd_ventas";
    String user = "root";
    String pass = "root";
    
    public Connection Conexion(){
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Conexion establecida");
            }
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar " + e);
        }
        return con;
    }
}