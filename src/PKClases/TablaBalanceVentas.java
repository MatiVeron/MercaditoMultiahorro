/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKClases;

import BD.ConexionBD;
import java.sql.Connection;
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
    
 
    DefaultTableModel modelo;
    Connection con = ConexionBD.getConexion();    
    
    
public void FiltrarTabla(JTable jTableBalanceVentas,String fechaDesde , String fechaHasta){
   try{ 
    String[] titulos = {"Codigo","Fecha","Comprobante","Total "};
    String[] fila = new String [4];
    modelo = new DefaultTableModel(null,titulos);
    
    String sql = "select * from venta where fecha Between '"+fechaDesde+"' and '"+fechaHasta+"'";
    
    Statement sent = con.createStatement();
    
    ResultSet rs = sent.executeQuery(sql);
    
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
