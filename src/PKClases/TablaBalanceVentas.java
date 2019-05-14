/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKClases;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matias
 */
public class TablaBalanceVentas {
    
    Statement sent;
    DefaultTableModel modelo;
    Connection con = ConexionBD.getConexion();    
    
    
public void LlenarTabla(JTable jTableBalanceVentas) { /* Llenar la tabla  con las ventas en ESPERA*/
    try{
        String[] titulos = {"Codigo","Fecha","Comprobante","Estado"};/*ArrayList con los header de la tabla*/
        String sql= "SELECT venta.id_venta, venta.fecha, venta.numero_venta, estadoventa.nombre_estado\n"+
                " FROM `venta` INNER JOIN estadoventa on venta.id_estado = estadoventa.id_estado\n"+
                " WHERE venta.id_estado = 2 ORDER BY venta.fecha ASC";
        
        modelo = new DefaultTableModel(null,titulos);
        
        sent = con.createStatement();
                
        ResultSet resultado = sent.executeQuery(sql);
        
        String [] fila = new String[4];/*ArrayList con el resultado de la consulta a la BD*/
            
            while(resultado.next()){        /*Metodo .next ayuda a recorrer el interior de un objeto, mostrando el siguiente*/
            fila[0]= resultado.getString("venta.id_venta");
            fila[1]= resultado.getString("venta.fecha");
            fila[2]= resultado.getString("venta.numero_venta");
            fila[3]= resultado.getString("estadoventa.nombre_estado");
            
           
            
            modelo.addRow(fila);
            
            }
            jTableBalanceVentas.setModel(modelo);
            
            }
   catch(Exception e){
           
               JOptionPane.showMessageDialog(null, e);
           
           
           }   }
    
    

public void FiltrarTabla(JTable jTableBalanceVentas,String fechaDesde , String fechaHasta){
   try{ 
    String[] titulos = {"Codigo","Fecha","Comprobante","Total "};
    String[] fila = new String [4];
    modelo = new DefaultTableModel(null,titulos);
    
    String sql = "select * from venta where fecha Between ? and ? " ;
    
    PreparedStatement ps = con.prepareStatement(sql);
    
            
    ps.setString(1,fechaDesde);
    ps.setString(2,fechaHasta);
    
   
    
    ResultSet rs = ps.executeQuery();
    
        while(rs.next()){

            fila[0]= rs.getString("id_venta");
            fila[1]= rs.getString("fecha");
            fila[2]= rs.getString("numero_venta");
            fila[3]= rs.getString("total");


        modelo.addRow(fila);
    
        }
   
   
   jTableBalanceVentas.setModel(modelo);
           
   
   }catch(Exception e){
           
               JOptionPane.showMessageDialog(null, e);
           
           
           }
    
    
    
    
 
    
    
    
    
    
    



}    
   
    
    
    
    
    
}
