/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKClases;
import BD.ConexionBD;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Ivan
 */
public class Usuarios {
    public String Usuario;
    public String Password;
    public String repeatPassword;
    Connection con = ConexionBD.getConexion();
    
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
    
    public void insertUsuario(String Usuario,String Password){
        try {
            PreparedStatement pstm1 = con.prepareStatement("INSERT INTO usuarios(nombre,password)" + "VALUES(?,?)" );
            pstm1.setString(1, Usuario);
            pstm1.setString(2,Password);
            pstm1.executeUpdate();
            pstm1.close();
            JOptionPane.showMessageDialog(null,"El usuario  "+Usuario+"  ha sido insertado con exito");  
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,"El usuario no ha sido insertado");
        }
    
    }

    
    public Object[][] Acceder(String Usuario,String Password){
           int registros = 0;
           
        try{
            PreparedStatement pstm = con.prepareStatement("SELECT count(1) as cont" + "FROM usuarios");
            
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("cont");
            res.close();
        }catch(SQLException ex){
            
        }
        Object[][] data = new Object[registros][2];
        if(Usuario.length() !=0 && Password.length() !=0 )
        {
            String name;
            String pass;
            
            try{
                String strql="SELECT nombre,password FROM usuarios WHERE nombre = '"+Usuario+"'AND password = '"+Password+"'";
                PreparedStatement pstm = con.prepareStatement(strql);
                ResultSet res  = pstm.executeQuery();
                int i= 0;
                while(res.next())
                {
                    name = res.getString("nombre");
                    pass = res.getString("password");
                    
                    data[i][0] = name;
                    data[i][1] = pass;
                    
                    i++;
                    
                }
                res.close();
            }catch(SQLException e){
                System.out.print(e);
            }
                
        }
    return data;
    }
    
}
