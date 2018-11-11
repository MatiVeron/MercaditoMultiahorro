
package PKClases;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class Categoria {
    
    private String IdCategoria;
    private String nombreCategoria;
    Connection con;
    Statement sent;
    
    
    
    
    public Categoria(String id ,String nombre){
        
        this.IdCategoria = id;
        this.nombreCategoria = nombre;}
    
    public Categoria(){}
    
    public String getCategoria(){
        return this.IdCategoria;   
    }
    
    public void setCategoria(String id){
        this.IdCategoria = id;
    }
    
     public String getNombre(){
        return this.nombreCategoria;   
    
     }
     
      public void setNombre(String nombre){
        this.nombreCategoria = nombre;   
    }
      
      public void agregarCategoria(int id,String descripcion){
      
      try{
        con = ConexionBD.getConexion();

        String sql = "INSERT INTO categorias (id_categoria,nombre_categoria)"+" VALUES (?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,id);
        ps.setString(2, descripcion);


        ps.executeUpdate();

      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
      }
      
      }
      
      
      public void eliminarCategoria(String idCategoria){
 
        int  confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este producto?");
       
        if(confirmar == JOptionPane.YES_OPTION){
            
            try{
                con = ConexionBD.getConexion();
                String sql = "DELETE FROM categorias WHERE id_categoria= ?";
                
                
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setString(1, idCategoria);
                
                if(ps.executeUpdate()> 0){
                    
                    JOptionPane.showMessageDialog(null,"Categoria eliminado");
                    con.close();
                }else{

                    JOptionPane.showMessageDialog(null,"No se pudo eliminar categoria");
                    con.close();
                }
                        
            }catch(Exception e){
                    
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        
        
        }
   
   
   }
      
      
      
      
      
       /*mostrar los objetos categoria en combo box*/ 
    public void mostrarCategoria(JComboBox<Categoria>jComboBoxCategoria){
        
        try{
            con = ConexionBD.getConexion();
            String sql="SELECT * FROM categorias ORDER BY id_categoria";
            sent = con.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            
            
            while (rs.next()){
                jComboBoxCategoria.addItem(
                        new Categoria (
                            rs.getString("id_categoria"),    
                            rs.getString("nombre_categoria")
                        )
                                );
            }
            
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"error");
             
        
        
        }
    
    }
    
    public String toString(){
        return IdCategoria+"-"+nombreCategoria;
    }
      
      
      
    
    
    }
    

