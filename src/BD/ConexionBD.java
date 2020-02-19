
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBD {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String cadenaConexion = "jdbc:mysql://localhost/bd";
    private static final String zonaHorarioHost = "?useTimezone=true&serverTimezone=America/Argentina/Buenos_Aires";
    private static final  String usuario = "root";
    private static final  String pass = "";
    public static Connection con;
    
  
   public static  Connection getConexion(){
        try{
        Class.forName(driver);
        con = DriverManager.getConnection(cadenaConexion+zonaHorarioHost, usuario, pass);
        
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"ERROR AL CONECTAR"+e.getMessage());
        
        }
     return con;   
    }
   
}