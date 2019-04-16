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


public class Familia {
    
    private String IdFamilia;
    private String nombreFamilia;
    Connection con;
    Statement sent;
    
    
    
    
    public Familia(String id ,String nombre){
        
        this.IdFamilia = id;
        this.nombreFamilia = nombre;}
    
    public Familia(){}

   
    
    public String getFamilia(){
        return this.IdFamilia;   
    }
    
    public void setFamilia(String id){
        this.IdFamilia= id;
    }
    
     public String getNombre(){
        return this.nombreFamilia;   
    
     }
     
      public void setNombre(String nombre){
        this.nombreFamilia = nombre;   
    }
      
      
       public void agregarFamilia(int id,String descripcion){
      
      try{
        con = ConexionBD.getConexion();

        String sql = "INSERT INTO familias (id_familia,nombre_familia)"+" VALUES (?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,id);
        ps.setString(2, descripcion);


        ps.executeUpdate();

      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
      }
      
      }
       
       public void eliminarFamilia(String idFamilia){
       
      int  confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este producto?");
       
        if(confirmar == JOptionPane.YES_OPTION){
            
            try{
                String sql = "DELETE FROM familias WHERE id_familia = ?";
                
                
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setString(1, idFamilia);
                
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
    public void mostrarFamilia(JComboBox<Familia>jComboBoxFamilia){
        
        try{
            con = ConexionBD.getConexion();
            String sql="SELECT * FROM familias ORDER BY id_familia";
            sent = con.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            
            
            while (rs.next()){
                jComboBoxFamilia.addItem(new Familia(
                            rs.getString("id_familia"),    
                            rs.getString("nombre_familia")
                        )
                                );
            }
            
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"error");
             
        
        
        }
    
    }
    
    public String toString(){
        return nombreFamilia;
    }}