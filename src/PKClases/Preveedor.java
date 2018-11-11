/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKClases;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Matias
 */
public class Preveedor {




public class Proveedor {
    
    private String IdProveedor;
    private String nombreProveedor;
    private String razonSocialProveedor;
    private String direccionProveedor;
    private String telefonoProveedor;
    Connection con;
    Statement sent;
    
    
    
    
    public Proveedor(String id ,String nombre){
        
        this.IdProveedor = id;
        this.nombreProveedor = nombre;}
    
    public Proveedor(){}
    
    public String getProveedor(){
        return this.IdProveedor;  
    }
    
    public void setUnidad(String id){
        this.IdProveedor = id;
    }
    
     public String getNombre(){
        return this.nombreProveedor;   
    
     }
     
      public void setNombre(String nombre){
        this.nombreProveedor = nombre;   
    }
       /*mostrar los objetos en combo box*/ 
    public void mostrarProveedor(JComboBox<Proveedor>jComboBoxProveedor){
        
        try{
            con = ConexionBD.getConexion();
            String sql="SELECT * FROM proveedores ORDER BY id_proveedor";
            sent = con.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            
            
            while (rs.next()){
                jComboBoxProveedor.addItem(
                        new Proveedor(
                            rs.getString("id_proveedor"),    
                            rs.getString("nombre_proveedor")
                        )
                                );
            }
            
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"error");
             
        
        
        }
    
    }
    
    public String toString(){
        return nombreProveedor;
    }}
    
}
