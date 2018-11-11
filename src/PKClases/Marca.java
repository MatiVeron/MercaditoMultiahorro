/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKClases;

import BD.ConexionBD;
import static BD.ConexionBD.con;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Matias
 */

    



public class Marca{
    
    private String IdMarca;
    private String nombreMarca;
    Connection con;
    Statement sent;
    
    
    
    
    public Marca(String id ,String nombre){
        
        this.IdMarca = id;
        this.nombreMarca = nombre;}
    
    public Marca(){}
    
    public String getMarca(){
        return this.IdMarca;   
    }
    
    public void setMarca(String id){
        this.IdMarca = id;
    }
    
     public String getNombre(){
        return this.nombreMarca;   
    
     }
     
      public void setNombre(String nombre){
        this.nombreMarca = nombre;   
    }
       
      
       public void agregarMarca( int id ,String nombre ){
     try{
            con = ConexionBD.getConexion();
            String sql=" INSERT INTO marcas (id_marca,nombre_marca)" + "Values (?,?) ";
                
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setInt(1,id);
            ps.setString(2,nombre);
           
            
           
            
            ps.executeUpdate();
        
            
                
        
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+ e.getMessage());
        }}
       
       
    public void eliminarMarca(String  idMarca){
       
      int  confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar esta marca?");
       
        if(confirmar == JOptionPane.YES_OPTION){
            
            try{
                String sql = "DELETE FROM marcas WHERE id_marca = ?";
                
                
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setString(1, idMarca);
                
                if(ps.executeUpdate()> 0){
                    
                    JOptionPane.showMessageDialog(null,"Marca eliminada");
                    con.close();
                }else{

                    JOptionPane.showMessageDialog(null,"No se pudo eliminar marca");
                    con.close();
                }
                        
            }catch(Exception ex){
                    
                JOptionPane.showMessageDialog(null, ex.getMessage()+"se pudrio");
            }
        
        
        }
   
   
   }

    
      
      
      /*mostrar los objetos categoria en combo box*/ 
    public void mostrarMarca(JComboBox<Marca>jComboBoxMarca){
        
        try{
            con = ConexionBD.getConexion();
            String sql="SELECT * FROM marcas ORDER BY id_marca";
            sent = con.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            
            
            while (rs.next()){
                jComboBoxMarca.addItem(
                        new Marca (
                            rs.getString("id_marca"),    
                            rs.getString("nombre_marca")
                        )
                                );
            }
            
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"error");
             
        
        
        }
    
    }
    
    public String toString(){
       return  nombreMarca;
    }
      
      
      
    
    
    }
    

