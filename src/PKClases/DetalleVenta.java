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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matias
 */
public class DetalleVenta {
    
    DefaultTableModel modelo;
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
            JOptionPane.showMessageDialog(null, "error "+ e.getMessage());
        }}
    
    
    public void consultarDetalle(String idDetalle ,JTable jTableDetalleVentas2){
        try{ 
            
        String[] titulos = {"Codigo","Nombre","Precio","Cantidad","Importe"};
         String [] fila = new String[5];
        modelo = new DefaultTableModel(null,titulos);
        
        String sql = "SELECT productos.id_producto,productos.nombre_producto,productos.precio_producto,detalleventa.cantidad_prod,detalleventa.importe \n"+
                     " FROM productos INNER JOIN detalleventa ON productos.id_producto = detalleventa.id_producto\n"+
                     " WHERE detalleventa.id_detalle = ?";
        
       
        
       
            
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idDetalle);


            ResultSet resultado = ps.executeQuery();
        
       
        
       
        while (resultado.next()){
          
                fila[0] = resultado.getString("productos.id_producto");
                fila[1] = resultado.getString("productos.nombre_producto");
                fila[2] = resultado.getString("productos.precio_producto");
                fila[3] = resultado.getString("detalleventa.cantidad_prod");
                fila[4] = resultado.getString("detalleventa.importe"); 
          
            modelo.addRow(fila);
            
        }
        
        jTableDetalleVentas2.setModel(modelo);
        
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
        
        
        }
    
    }
        
        
        
    }

    
    
    
    
    
    

