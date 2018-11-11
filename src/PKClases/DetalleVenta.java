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

    public void  insertarDetalleVenta(String IdDetalleVenta,String numVent, String codProd,String importe,String cantProd){
        

        String SQL="INSERT INTO detalleventa(id_detalle,numero_venta,id_producto,importe,cantidad_prod) VALUES (?,?,?,?,?)";
       
    
        try {
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1,IdDetalleVenta);
            pst.setString(2,numVent);
            pst.setString(3,codProd);
            pst.setString(4,importe);
            pst.setString(5,cantProd);
            
          
           pst.executeUpdate();
        
           
                
        
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+ e.getMessage());
        }}}
    
    

