/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKClases;

import static BD.ConexionBD.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Matias
 */
public class Venta {
    
    
    
    public void InsertarVenta(String idVenta,String subTotal,String total,String fecha,String idDetalle){
     try{
            String sql=" INSERT INTO venta (id_venta,subtotal,total,fecha,id_detalle)" +
           "Values (?,?,?,?,?) ";
                
            
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,idVenta);
            ps.setString(2,subTotal);
            ps.setString(3,total);
            ps.setString(4, fecha);
            ps.setString(5, idDetalle);
            
           
            
            int n=ps.executeUpdate();
        
            if(n>0)
                JOptionPane.showMessageDialog(null, "datos de la venta guardados");
                
        
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+ e.getMessage());
        }}
    
     public void  descontarStock(String codi,String cant){
       int des = Integer.parseInt(cant);
       String cap="";
       int desfinal;
       String sql="SELECT * FROM productos WHERE  id_producto='"+codi+"'";
        try {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next())
            {
                cap= rs.getString(4);
            }
            
            
        } catch (Exception e) {}
        
        desfinal=Integer.parseInt(cap)-des;
        String modi="UPDATE productos SET cantidad='"+desfinal+"' WHERE id_producto = '"+codi+"'";
        
        try {
            PreparedStatement pst = con.prepareStatement(modi);
            pst.executeUpdate();} 
        
        catch (Exception e) {}}
    
    
    }
 
    
    

