/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKClases;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Matias
 */
public class DetalleVenta {
    
    Connection con = ConexionBD.getConexion();

    public void  insertarDetalleVenta(String IdDetalleVenta, String codProd,String importe,String cantProd){
        

        String SQL="INSERT INTO detalleventa(id_detalle,id_producto,importe,cantidad_prod) VALUES (?,?,?,?)";
       
    
        try {
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1,IdDetalleVenta);
            
            pst.setString(2,codProd);
            pst.setString(3,importe);
            pst.setString(4,cantProd);
            
          
           pst.executeUpdate();
        
           
                
        
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+ e.getMessage());
        }}}
    
    

