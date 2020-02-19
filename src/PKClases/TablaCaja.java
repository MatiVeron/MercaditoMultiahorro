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


public class TablaCaja {
    PreparedStatement ps;
    DefaultTableModel modelo;
    Connection con = ConexionBD.getConexion();    
    
    
     public void llenar_tabla_cierre(JTable jTableConsultaCaja) { /* Llenar la tabla  con las ventas Cerradas*/
    try{
        
        
        String[] titulos = {"Fecha de apertura","Monto de apertura","Abrio","Monto final","Arqueo","Total ventas registrado","Fecha de cierre","Cerro"};/*ArrayList con los header de la tabla*/
        String sql= "SELECT a.monto_inicial, a.fecha_hora_apertura,u.nombre, c.monto_final,c.arqueo,c.total_ventas,c.fecha_hora_cierre, u2.nombre\n"+
                    "FROM `apertura` a\n"+
                    "INNER JOIN cierre c on a.id_caja = c.id_caja\n"+
                    "INNER JOIN usuarios u on a.id_usuario = u.id_usuario\n"+ 
                    "INNER JOIN usuarios u2 on c.id_usuario = u2.id_usuario\n"+
                    "WHERE a.id_estado_caja = 2";
                //"ORDER BY venta.fecha ASC";
        
        modelo = new DefaultTableModel(null,titulos);
        
        ps = con.prepareStatement(sql);

        ResultSet resultado = ps.executeQuery();

        String [] fila = new String[8];/*ArrayList con el resultado de la consulta a la BD*/
            
            while(resultado.next()){        /*Metodo .next ayuda a recorrer el interior de un objeto, mostrando el siguiente*/
           
            fila[0]= resultado.getString("a.fecha_hora_apertura");
            fila[1]= resultado.getString("a.monto_inicial");
            fila[2]= resultado.getString("u.nombre");
            fila[3] = resultado.getString("c.monto_final");
            fila[4] = resultado.getString("c.arqueo");
            fila[5] = resultado.getString("c.total_ventas");
            fila[6] = resultado.getString("c.fecha_hora_cierre");
            fila[7] = resultado.getString("u2.nombre");
            modelo.addRow(fila);
            
            }
            jTableConsultaCaja.setModel(modelo);
            
            }
   catch(Exception e){
           
               JOptionPane.showMessageDialog(null, e);
           
           
           }   }
    
public void filtrar_tabla_por_fechas(String fechaDesde,String fechaHasta,JTable jTableConsultaCaja){
   try{ 

        String[] fila = new String [8];


        String[] titulos = {"Fecha de apertura","Monto de apertura","Abrio","Monto final","Arqueo","Total ventas registrado","Fecha de cierre","Cerro"};/*ArrayList con los header de la tabla*/
        String sql= "SELECT a.monto_inicial, a.fecha_hora_apertura,u.nombre, c.monto_final,c.arqueo,c.total_ventas,c.fecha_hora_cierre, u2.nombre\n"+
                    "FROM `apertura` a\n"+
                    "INNER JOIN cierre c on a.id_caja = c.id_caja\n"+
                    "INNER JOIN usuarios u on a.id_usuario = u.id_usuario\n"+ 
                    "INNER JOIN usuarios u2 on c.id_usuario = u2.id_usuario\n"+
                    "WHERE DATE (a.fecha_hora_apertura) BETWEEN  ? AND  ? \n"+
                    " ORDER BY a.fecha_hora_apertura ASC";
        
        modelo = new DefaultTableModel(null,titulos);

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, fechaDesde);
        ps.setString(2, fechaHasta);





        ResultSet resultado = ps.executeQuery();

        while(resultado.next()){

            fila[0]= resultado.getString("a.fecha_hora_apertura");
            fila[1]= resultado.getString("a.monto_inicial");
            fila[2]= resultado.getString("u.nombre");
            fila[3] = resultado.getString("c.monto_final");
            fila[4] = resultado.getString("c.arqueo");
            fila[5] = resultado.getString("c.total_ventas");
            fila[6] = resultado.getString("c.fecha_hora_cierre");
            fila[7] = resultado.getString("u2.nombre");


                 modelo.addRow(fila);

            }


       jTableConsultaCaja.setModel(modelo);
           
   
   }catch(Exception e){
           
               JOptionPane.showMessageDialog(null, e);
           
           
           }}






}
