
package PKClases;

import BD.ConexionBD;
import java.sql.Connection;
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
    

