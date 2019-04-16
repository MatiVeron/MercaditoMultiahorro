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
import javax.swing.JOptionPane;


public class AutoCompletar {
    
       Connection con = ConexionBD.getConexion();
       ResultSet rs = null;
       PreparedStatement ps = null;
       
       
       public ResultSet find(String s){
           try{
           ps = con.prepareStatement("SELECT * FROM productos WHERE id_producto = ?");
           ps.setString(1,s);
           rs = ps.executeQuery();
           
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
       }
       
   

       public ResultSet findNombre(String s){
           try{
           ps = con.prepareStatement("SELECT * FROM productos WHERE nombre_producto = ?");
           ps.setString(1,s);
           rs = ps.executeQuery();
           
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
       
       
}
       
            public ResultSet findCodigoBarras(String s){
           try{
           ps = con.prepareStatement("SELECT * FROM productos WHERE codigo_barras = ?");
           ps.setString(1,s);
           rs = ps.executeQuery();
           
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;}
           
           
   public ResultSet findCodigoVenta(String s){
           try{
           ps = con.prepareStatement("SELECT * FROM venta WHERE id_venta = ?");
           ps.setString(1,s);
           rs = ps.executeQuery();
           
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;}
           
           
           public ResultSet findCodigoComprobante(String s){
           try{
           ps = con.prepareStatement("SELECT * FROM venta WHERE numero_venta = ?");
           ps.setString(1,s);
           rs = ps.executeQuery();
           
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
}}

    
    

