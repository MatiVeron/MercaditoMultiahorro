/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKClases;
import BD.ConexionBD;
import static BD.ConexionBD.con;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Matias
 */
public class Usuarios {
    public int id_usuario;
    public String Usuario;
    public String Password;
    public String repeatPassword;
    private String last_sesion;
    private int id_tipo;
    private String nombre_tipo;    
    Connection con = ConexionBD.getConexion();

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }


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
    
    public void insertUsuario(int idUsuario ,String Usuario,String Password , String idTipo, int id_estado){
        try {
            PreparedStatement pstm1 = con.prepareStatement("INSERT INTO usuarios(id_usuario, nombre , password,id_tipo,id_estado)" + "VALUES(?,?,?,?,?)" );
            pstm1.setInt(1,idUsuario);
            pstm1.setString(2,Usuario);
            pstm1.setString(3,Password);
            pstm1.setString(4, idTipo);
            pstm1.setInt(5, id_estado);
            pstm1.executeUpdate();
          
            JOptionPane.showMessageDialog(null,"El usuario  "+Usuario+"  ha sido insertado con exito");  
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,"El usuario no ha sido insertado");
        }
    
    }
    
      public boolean login(Usuarios usuario){
        ResultSet rs;
          try {
            
            PreparedStatement pstm1 = con.prepareStatement("SELECT usuarios.id_usuario,usuarios.nombre,usuarios.password , usuarios.id_tipo, tipousuarios.nombre_tipo\n"+
                                                           " FROM usuarios INNER JOIN tipousuarios  ON usuarios.id_tipo = tipousuarios.id_tipo  WHERE usuarios.nombre = ?" );
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
                  usuario.setNombre_tipo(rs.getString(5));
                  
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
    //Verificar que el usuario este activo
      
      
      public int verificar_activo (int id_usuario){
      ResultSet rs = null;
      int estado = 0;

           try {      
            PreparedStatement pstm1 = con.prepareStatement("SELECT id_estado FROM usuarios WHERE usuarios.id_usuario = ?");
            
            pstm1.setInt(1,id_usuario);
            rs = pstm1.executeQuery();
            if(rs.next()){
            estado = rs.getInt("usuarios.id_estado");

            }
            return estado;
            
          }catch(SQLException e){
              
              JOptionPane.showMessageDialog(null,"ño");
      
      
      } return estado;
      
      }
    
    //no repetir nombre de usuario
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
    
    
     public String modificoNombre(int id , String usuario ){
        String nombreUser = "";
        ResultSet rs = null;
           try {      
            PreparedStatement pstm1 = con.prepareStatement("SELECT nombre FROM usuarios WHERE usuarios.id_usario = ?");
            
            pstm1.setInt(1,id);
            rs = pstm1.executeQuery();
            if(rs.next()){
               nombreUser = rs.getString("usuarios.nombre");
            
            }
            return nombreUser;
            
            
          }catch(SQLException e){
              
              return nombreUser;
    
    
    }}

    
    
    
    
//Acceso al main
    
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
    

    
    //Busqueda de usuarios por barra de busqueda
    public void buscar_usuarios(String busqueda, JTable jtableUsuarios){

    String[] titulos = {"Codigo","Nombre","Tipo"};;
    String [] fila = new String[3];
    DefaultTableModel ModeloTabla = new DefaultTableModel(null,titulos);      
    
    String sql;
    
  
         sql = "select usuarios.id_usuario, usuarios.nombre, tipousuarios.nombre_tipo\n" +
                  "from usuarios\n" +
                  "inner join tipousuarios on usuarios.id_tipo = tipousuarios.id_tipo\n" 
                  + "WHERE usuarios.nombre LIKE '%"+busqueda+"%' AND id_estado = 1  ORDER BY usuarios.id_usuario ASC";              
    try {

        
        PreparedStatement ps = con.prepareStatement(sql);
       
        
        ResultSet resultado = ps.executeQuery();
        
        while (resultado.next()){
          
                fila[0] = resultado.getString("usuarios.id_usuario");
                fila[1] = resultado.getString("usuarios.nombre");
                fila[2] = resultado.getString("tipousuarios.nombre_tipo");

            ModeloTabla.addRow(fila);
           
        }
        
         jtableUsuarios.setModel(ModeloTabla);

    }catch (SQLException e) {


        JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
    
    
    
    }
    
    }
    
    //Editar nombre y tipo de usuarios
    public void modificar_usuario (int id, String nombre,int id_tipo){

    int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos del usuario?");
   

    if(confirmar == JOptionPane.YES_OPTION){



        try {

            String sql = "UPDATE usuarios SET nombre = ?, id_tipo = ?  WHERE id_usuario = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            
            ps.setString(1, nombre);
            ps.setInt(2,id_tipo);
            ps.setInt(3, id);
            
            



            if(ps.executeUpdate() > 0){

                JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa", 
                                              JOptionPane.INFORMATION_MESSAGE);

            }else{

                JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                              + "Inténtelo nuevamente.", "Error en la operación", 
                                              JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                              + "Inténtelo nuevamente.\n"
                                              + "Error: "+e, "Error en la operación", 
                                              JOptionPane.ERROR_MESSAGE);

        }

        }}
    
    
    
    public String  consultar_pass(int id){
        
        con = ConexionBD.getConexion();
        PreparedStatement ps = null;
        String pass= "";
        String Sql = "SELECT password FROM usuarios WHERE id_usuario = ? ";
        
        try {
            ps = con.prepareStatement(Sql);
            
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                pass = rs.getString("password");
        
        }
            

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                              + "Inténtelo nuevamente.\n"
                                              + "Error: "+e, "Error en la operación", 
                                              JOptionPane.ERROR_MESSAGE);

        }
    
    return pass;
    
    
    }
    
    
    
    //Editar contraseña
    public void modificar_pass (int id,String pass){

    int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea modificar las contraseñas?");
   

    if(confirmar == JOptionPane.YES_OPTION){



        try {

            String sql = "UPDATE usuarios SET password = ?  WHERE id_usuario = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            
            ps.setString(1, pass);
            ps.setInt(2, id);
            
            



            if(ps.executeUpdate() > 0){

                JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa", 
                                              JOptionPane.INFORMATION_MESSAGE);

            }else{

                JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                              + "Inténtelo nuevamente.", "Error en la operación", 
                                              JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                              + "Inténtelo nuevamente.\n"
                                              + "Error: "+e, "Error en la operación", 
                                              JOptionPane.ERROR_MESSAGE);

        }

        }}
       
    public int obtener_id_usuario(String nombre_usuario){
        con = ConexionBD.getConexion();
        PreparedStatement ps = null;
        ResultSet rs;
        int id = 0;
        String Sql = "SELECT id_usuario FROM usuarios WHERE nombre = ? ";
        
        try {
            ps = con.prepareStatement(Sql);
            
            ps.setString(1, nombre_usuario);
            rs = ps.executeQuery();
            while(rs.next()){
                
                id = rs.getInt("id_usuario");
        
        }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return id;
    }
    
    
    
    
    
    
   //Obtener el id de tipo a travez del nombre
    public int obtener_id_tipo(String nombre_tipo){
        con = ConexionBD.getConexion();
        PreparedStatement ps = null;
        int id = 0;
        String Sql = "SELECT id_tipo FROM tipousuarios WHERE nombre_tipo = ? ";
        
        try {
            ps = con.prepareStatement(Sql);
            
            ps.setString(1, nombre_tipo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                id = rs.getInt("id_tipo");
        
        }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return id;
    }
    
    
    
    
    
    public void eliminiar_usuario(int id){
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el usuario?");
   

        if(confirmar == JOptionPane.YES_OPTION){


            try {

                String sql = "DELETE FROM usuarios  WHERE id_usuario = ?";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1, id);


                if(ps.executeUpdate() > 0){

                    JOptionPane.showMessageDialog(null, "Usuario eliminado", "Operación Exitosa", 
                                                  JOptionPane.INFORMATION_MESSAGE);

                }else{

                    JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                                  + "Inténtelo nuevamente.", "Error en la operación", 
                                                  JOptionPane.ERROR_MESSAGE);

                }

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                                  + "Inténtelo nuevamente.\n"
                                                  + "Error: "+e, "Error en la operación", 
                                                  JOptionPane.ERROR_MESSAGE);

            }




        }
}
    
      public void Inactivar_usuario (int id){

    int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea desactivar este usuario?");
   

    if(confirmar == JOptionPane.YES_OPTION){



        try {

            String sql = "UPDATE usuarios SET id_estado = 2  WHERE id_usuario = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            

            ps.setInt(1, id);
            
            



            if(ps.executeUpdate() > 0){

                JOptionPane.showMessageDialog(null, "El usuario se inhabilito: Recuerde que si el usuario realizo operaciones en el sistema, estas seguiran figurando.", "Operación Exitosa", 
                                              JOptionPane.INFORMATION_MESSAGE);
                

            }else{

                JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                              + "Inténtelo nuevamente.", "Error en la operación", 
                                              JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                              + "Inténtelo nuevamente.\n"
                                              + "Error: "+e, "Error en la operación", 
                                              JOptionPane.ERROR_MESSAGE);

        }

        }}

}
        
        
    
    
    
    
    
    



        
    
    


    
    

