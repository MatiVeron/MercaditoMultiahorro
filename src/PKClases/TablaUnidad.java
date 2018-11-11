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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matias
 */
public class TablaUnidad {

    Connection con;
    Statement sent;
    DefaultTableModel modelo;
    
 public void LlenarTabla(JTable jTableUnidad) {
       try{ 
           
            con = ConexionBD.getConexion();
            String[] titulos = {"codigo","Nombre"};/*ArrayList con los header de la tabla*/
            String sql= "SELECT * FROM unidades";
       
            
            modelo = new DefaultTableModel(null,titulos);
            
            sent = con.createStatement();
           
            
            
            ResultSet resultado = sent.executeQuery(sql);/*Metodo para crear un objeto con el almacenamiento de un resultado de una consulta sql*/
            
            
            String [] fila = new String[2];/*ArrayList con el resultado de la consulta a la BD*/
            
            while(resultado.next()){        /*Metodo .next ayuda a recorrer el interior de un objeto, mostrando el siguiente*/
                fila[0] = resultado.getString("id_unidad");
                fila[1] = resultado.getString("nombre_unidad");
                
                
                
                /*LAS LINEAS COMENTADAS SON PARA VISUALIZAR LA CATEGORIA EN LA TABLA DE PRODUCTOS!!*/
                
                modelo.addRow(fila);
            }
            
            jTableUnidad.setModel(modelo);/*Llenar el default tabla con el modelo de la tabla deseada*/
       
       } catch(Exception e){
           e.printStackTrace();
       }
    
 
    


 }


}
    
