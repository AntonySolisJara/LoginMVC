package Modelo;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antony
 */
public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    
    public List buscar(String texto){
        
        List<Empleado> lista = new ArrayList<>();
        String sql = "select * from empleado where Dni like '%"+texto+"%' or User like '%"+texto+"%'";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Empleado em = new Empleado();
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
                lista.add(em);
            }
        }
        catch (SQLException e){
            
        }
        return lista;
    }
    
    
    public Empleado validar(String user, String dni){
        Empleado em = new Empleado();
        String sql = "select * from empleado where User = ? and Dni = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while(rs.next()){
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
        }
        catch (SQLException e){
            
        }
        return em;
    }
}
