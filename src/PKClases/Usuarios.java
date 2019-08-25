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
    public int id_usuario;
    public String Usuario;
    public String Password;
    public String repeatPassword;
    private String last_sesion;
    private int id_tipo;
    Connection con = ConexionBD.getConexion();

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getLast_sesion() {
        return last_sesion;
    }
    
    public void setLast_sesion(String last_sesion) {
        this.last_sesion = last_sesion;
    }
    
        public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

   
    
   
    
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
    
    public void insertUsuario(int idUsuario ,String Usuario,String Password , String idTipo){
        try {
            PreparedStatement pstm1 = con.prepareStatement("INSERT INTO usuarios(id_usuario, nombre , password,id_tipo)" + "VALUES(?,?,?,?)" );
            pstm1.setInt(1,idUsuario);
            pstm1.setString(2,Usuario);
            pstm1.setString(3,Password);
            pstm1.setString(4, idTipo);
            pstm1.executeUpdate();
          
            JOptionPane.showMessageDialog(null,"El usuario  "+Usuario+"  ha sido insertado con exito");  
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,"El usuario no ha sido insertado");
        }
    
    }
    
      public boolean login(Usuarios usuario){
        ResultSet rs;
          try {
            
            PreparedStatement pstm1 = con.prepareStatement("SELECT id_usuario, nombre, password , id_tipo\n"+
                                                           " FROM usuarios  WHERE nombre = ?" );
            pstm1.setString(1,usuario.getUsuario());
            rs = pstm1.executeQuery();
            
          if(rs.next()){
             
              if(usuario.getPassword().equals(rs.getString(3))){
                 JOptionPane.showMessageDialog(null, "Bienvenido");  
                  PreparedStatement pstm;

                  String sqlUpdate = "UPDATE usuarios SET last_sesion = ? WHERE id_usuario = ?";
                  pstm = con.prepareStatement(sqlUpdate);
                  pstm.setString(1,usuario.getLast_sesion());
                  pstm.setInt(2,rs.getInt(1));
                  pstm.execute();
                  
                  usuario.setId_usuario(rs.getInt(1));
                  usuario.setUsuario(rs.getString(2));
                  usuario.setId_tipo(rs.getInt(4));
                  
                  return true;
              
              }else{
                  return false;
              }
          
          }
          
          
              
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "cabe");
            
        }
        return false;  
      }
    
    
    public int existeUsuario( String usuario ){
        
        ResultSet rs = null;
           try {      
            PreparedStatement pstm1 = con.prepareStatement("SELECT count(id_usuario) FROM usuarios WHERE usuarios.nombre = ?");
            
            pstm1.setString(1,usuario);
            rs = pstm1.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            
            }
            
            return 1;
            
          }catch(SQLException e){
              
              return 1;
    
    
    }}
    
    

    
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
