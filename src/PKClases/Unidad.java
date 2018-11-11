/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package PKClases;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class Unidad {
    
    private String IdUnidad;
    private String nombreUnidad;
    Connection con;
    Statement sent;
    
    
    
    
    public Unidad(String id ,String nombre){
        
        this.IdUnidad = id;
        this.nombreUnidad = nombre;}
    
    public Unidad(){}
    
    public String getUnidad(){
        return this.IdUnidad;   
    }
    
    public void setUnidad(String id){
        this.IdUnidad = id;
    }
    
     public String getNombre(){
        return this.nombreUnidad;   
    
     }
     
      public void setNombre(String nombre){
        this.nombreUnidad = nombre;   
    }
      
      
       public void agregarUnidad(int id,String descripcion){
      
      try{
        con = ConexionBD.getConexion();

        String sql = "INSERT INTO unidades (id_unidad,nombre_unidad)"+" VALUES (?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,id);
        ps.setString(2, descripcion);


        ps.executeUpdate();

      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
      }
      
      }
       
       public void eliminarUnidad(String idUnidad){
       
      int  confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este producto?");
       
        if(confirmar == JOptionPane.YES_OPTION){
            
            try{
                String sql = "DELETE FROM unidades WHERE id_unidad = ?";
                
                
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setString(1, idUnidad);
                
                if(ps.executeUpdate()> 0){
                    
                    JOptionPane.showMessageDialog(null,"Unidad eliminada");
                    con.close();
                }else{

                    JOptionPane.showMessageDialog(null,"No se pudo eliminar unidad");
                    con.close();
                }
                        
            }catch(Exception e){
                    
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        
        
        }
   
   
   }
      
      
      
      
       /*mostrar los objetos categoria en combo box*/ 
    public void mostrarUnidad(JComboBox<Unidad>jComboBoxUnidad){
        
        try{
            con = ConexionBD.getConexion();
            String sql="SELECT * FROM unidades ORDER BY id_unidad";
            sent = con.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            
            
            while (rs.next()){
                jComboBoxUnidad.addItem(
                        new Unidad(
                            rs.getString("id_unidad"),    
                            rs.getString("nombre_unidad")
                        )
                                );
            }
            
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"error");
             
        
        
        }
    
    }
    
    public String toString(){
        return nombreUnidad;
    }}