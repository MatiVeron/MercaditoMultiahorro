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
import java.text.SimpleDateFormat;
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
        String[] titulos = {"Codigo","Fecha","Comprobante","Total","Estado"};/*ArrayList con los header de la tabla*/
        String sql= "SELECT venta.id_venta, venta.fecha, venta.numero_venta,venta.total, estadoventa.nombre_estado\n"+
                " FROM `venta` INNER JOIN estadoventa on venta.id_estado = estadoventa.id_estado\n"+
                " ORDER BY venta.fecha ASC";
        
        modelo = new DefaultTableModel(null,titulos);
        
        sent = con.createStatement();
                
        ResultSet resultado = sent.executeQuery(sql);
        
        String [] fila = new String[5];/*ArrayList con el resultado de la consulta a la BD*/
            
            while(resultado.next()){        /*Metodo .next ayuda a recorrer el interior de un objeto, mostrando el siguiente*/
            fila[0]= resultado.getString("venta.id_venta");
            
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY"); /*Lleno la tabla con la fecha en formato dd/MM/YYYY*/
            fila[1]= formatoFecha.format(resultado.getDate("venta.fecha"));
            
            fila[2]= resultado.getString("venta.numero_venta");
            fila[3]= resultado.getString("venta.total")+" ARS";
            fila[4]= resultado.getString("estadoventa.nombre_estado");
            
           
            
            modelo.addRow(fila);
            
            }
            jTableBalanceVentas.setModel(modelo);
            
            }
   catch(Exception e){
           
               JOptionPane.showMessageDialog(null, e);
           
           
           }   }
    
    
    
public void LlenarTablaEspera(JTable jTableBalanceVentas) { /* Llenar la tabla  con las ventas en ESPERA*/
    try{
        String[] titulos = {"Codigo","Fecha","Comprobante","Total","Estado"};/*ArrayList con los header de la tabla*/
        String sql= "SELECT venta.id_venta, venta.fecha, venta.numero_venta,venta.total, estadoventa.nombre_estado\n"+
                " FROM `venta` INNER JOIN estadoventa on venta.id_estado = estadoventa.id_estado\n"+
                " WHERE venta.id_estado = 2 ORDER BY venta.fecha ASC";
        
        modelo = new DefaultTableModel(null,titulos);
        
        sent = con.createStatement();
                
        ResultSet resultado = sent.executeQuery(sql);
        
        String [] fila = new String[5];/*ArrayList con el resultado de la consulta a la BD*/
            
            while(resultado.next()){        /*Metodo .next ayuda a recorrer el interior de un objeto, mostrando el siguiente*/
            fila[0]= resultado.getString("venta.id_venta");
            
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY"); /*Lleno la tabla con la fecha en formato dd/MM/YYYY*/
            fila[1]= formatoFecha.format(resultado.getDate("venta.fecha"));
            
            fila[2]= resultado.getString("venta.numero_venta");
            fila[3]= resultado.getString("venta.total")+" ARS";
            
            fila[4]= resultado.getString("estadoventa.nombre_estado");
            
           
            
            modelo.addRow(fila);
            
            }
            jTableBalanceVentas.setModel(modelo);
            
            }
   catch(Exception e){
           
               JOptionPane.showMessageDialog(null, e);
           
           
           }   }
    
    

public void FiltrarTablaPorFechas(JTable jTableBalanceVentas2,String fechaDesde , String fechaHasta){
    try{ 
        String[] titulos = {"Codigo","Fecha","Comprobante","Total","Estado"};
        String[] fila = new String [5];
        modelo = new DefaultTableModel(null,titulos);


        String sql= "SELECT venta.id_venta, venta.fecha, venta.numero_venta, venta.total, estadoventa.nombre_estado\n"+
                    " FROM `venta` INNER JOIN estadoventa on venta.id_estado = estadoventa.id_estado\n"+
                    "WHERE venta.id_estado = 2 AND venta.fecha BETWEEN  ? AND  ?  \n"+
                    " ORDER BY venta.fecha ASC";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, fechaDesde);
        ps.setString(2, fechaHasta);





        ResultSet rs = ps.executeQuery();

        while(rs.next()){

                fila[0]= rs.getString("venta.id_venta");


                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
                fila[1]= formatoFecha.format(rs.getDate("venta.fecha"));

                fila[2]= rs.getString("venta.numero_venta");
                fila[3]= rs.getString("venta.total")+" ARS";
                fila[4] = rs.getString("estadoventa.nombre_estado");


                 modelo.addRow(fila);

            }


       jTableBalanceVentas2.setModel(modelo);
           
   
   }catch(Exception e){
           
               JOptionPane.showMessageDialog(null, e);
    

}}
public void FiltrarTablaPorComprobanteCerrado(String comprobante,JTable jTableBalanceVentas2){
   try{ 
    String[] titulos = {"Codigo","Fecha","Comprobante","Total","Estado"};
    String[] fila = new String [5];
    modelo = new DefaultTableModel(null,titulos);
    
    String sql= "SELECT venta.id_venta, venta.fecha, venta.numero_venta, venta.total, estadoventa.nombre_estado\n"+
                " FROM `venta` INNER JOIN estadoventa on venta.id_estado = estadoventa.id_estado\n"+
                "WHERE venta.id_estado = 1 AND venta.numero_venta = ? \n"+
                " ORDER BY venta.numero_venta ASC";
    
    PreparedStatement ps = con.prepareStatement(sql);
    
            
    ps.setString(1,comprobante);
    
    
   
    
    ResultSet rs = ps.executeQuery();
    
        while(rs.next()){

             fila[0]= rs.getString("venta.id_venta");
 
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
            fila[1]= formatoFecha.format(rs.getDate("venta.fecha"));
            
            fila[2]= rs.getString("venta.numero_venta");
            fila[3]= rs.getString("venta.total")+" ARS";
            fila[4] = rs.getString("estadoventa.nombre_estado");

        modelo.addRow(fila);
    
        }
   
   
   jTableBalanceVentas2.setModel(modelo);
           
   
   }catch(Exception e){
           
               JOptionPane.showMessageDialog(null, e);
           
           
           }

} 

 

public void FiltrarTablaPorComprobante(String comprobante,JTable jTableBalanceVentas2){
   try{ 
    String[] titulos = {"Codigo","Fecha","Comprobante","Total","Estado"};
    String[] fila = new String [5];
    modelo = new DefaultTableModel(null,titulos);
    
    String sql= "SELECT venta.id_venta, venta.fecha, venta.numero_venta, venta.total, estadoventa.nombre_estado\n"+
                " FROM `venta` INNER JOIN estadoventa on venta.id_estado = estadoventa.id_estado\n"+
                "WHERE venta.id_estado = 2 AND venta.numero_venta = ? \n"+
                " ORDER BY venta.numero_venta ASC";
    
    PreparedStatement ps = con.prepareStatement(sql);
    
            
    ps.setString(1,comprobante);
    
    
   
    
    ResultSet rs = ps.executeQuery();
    
        while(rs.next()){

             fila[0]= rs.getString("venta.id_venta");
 
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
            fila[1]= formatoFecha.format(rs.getDate("venta.fecha"));
            
            fila[2]= rs.getString("venta.numero_venta");
            fila[3]= rs.getString("venta.total")+" ARS";
            fila[4] = rs.getString("estadoventa.nombre_estado");

        modelo.addRow(fila);
    
        }
   
   
   jTableBalanceVentas2.setModel(modelo);
           
   
   }catch(Exception e){
           
               JOptionPane.showMessageDialog(null, e);
           
           
           }

} 








public void LlenarTablaVentasHoy(String fechaHoy,JTable jTableBalanceVentas) { /* Llenar la tabla  con las ventas en ESPERA*/
    try{
        String[] titulos = {"Codigo","Fecha","Comprobante","Total","Estado"};/*ArrayList con los header de la tabla*/
        String sql= "SELECT venta.id_venta, venta.fecha, venta.numero_venta,venta.total, estadoventa.nombre_estado\n"+
                " FROM `venta` INNER JOIN estadoventa on venta.id_estado = estadoventa.id_estado \n"+
                " WHERE venta.fecha = ? AND venta.id_estado = 1";
        
        modelo = new DefaultTableModel(null,titulos);
       
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, fechaHoy);
        

        
        
                
        ResultSet resultado = ps.executeQuery();
        
        String [] fila = new String[5];/*ArrayList con el resultado de la consulta a la BD*/
            
            while(resultado.next()){        /*Metodo .next ayuda a recorrer el interior de un objeto, mostrando el siguiente*/
            fila[0]= resultado.getString("venta.id_venta");
            
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY"); /*Lleno la tabla con la fecha en formato dd/MM/YYYY*/
            fila[1]= formatoFecha.format(resultado.getDate("venta.fecha"));
            
            fila[2]= resultado.getString("venta.numero_venta");
            fila[3]= resultado.getString("venta.total")+" ARS";
            fila[4]= resultado.getString("estadoventa.nombre_estado");
            
           
            
            modelo.addRow(fila);
            
            }
            jTableBalanceVentas.setModel(modelo);
            
            }
   catch(Exception e){
           
               JOptionPane.showMessageDialog(null, e);
           
           
           }   }


    







}  


   
 





 
    
    
    

