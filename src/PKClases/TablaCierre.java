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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TablaCierre {
    PreparedStatement ps;
    DefaultTableModel modelo;
    Connection con = ConexionBD.getConexion();    
    
    
     public void llenar_tabla_cierre(JTable jTableBalanceVentas, int id_caja) { /* Llenar la tabla  con las ventas Cerradas*/
    try{
        
        
        String[] titulos = {"Fecha","Comprobante","Total","Estado de venta","Usuario","Inicio caja"};/*ArrayList con los header de la tabla*/
        String sql= "SELECT  venta.fecha, venta.numero_venta,venta.total, estadoventa.nombre_estado,usuarios.nombre,apertura.monto_inicial\n"+
                "FROM `venta` INNER JOIN estadoventa on venta.id_estado = estadoventa.id_estado\n"+
                "INNER JOIN usuarios on venta.id_usuario = usuarios.id_usuario\n"+
                "INNER JOIN apertura on venta.id_caja = ? \n"+
                "ORDER BY venta.fecha ASC";
        
        modelo = new DefaultTableModel(null,titulos);
        
        ps = con.prepareStatement(sql);
        
        ps.setInt(1, id_caja);
                
        
        
        ResultSet resultado = ps.executeQuery();
        
        
        
        
        
        String [] fila = new String[6];/*ArrayList con el resultado de la consulta a la BD*/
            
            while(resultado.next()){        /*Metodo .next ayuda a recorrer el interior de un objeto, mostrando el siguiente*/

            
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss"); /*Lleno la tabla con la fecha en formato dd/MM/YYYY*/
            fila[0]= formatoFecha.format(resultado.getDate("venta.fecha"));
            
            fila[1]= resultado.getString("venta.numero_venta");
            fila[2]= resultado.getString("venta.total")+" ARS";
            fila[3]= resultado.getString("estadoventa.nombre_estado");
            fila[4] = resultado.getString("usuarios.nombre");
            fila[5] = resultado.getString("apertura.monto_inicial");
            
            modelo.addRow(fila);
            
            }
            jTableBalanceVentas.setModel(modelo);
            
            }
   catch(Exception e){
           
               JOptionPane.showMessageDialog(null, e);
           
           
           }   }
    
}
