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


public class TablaUsuario {
    Connection con = ConexionBD.getConexion();
    DefaultTableModel modelo;
    Statement sent;
    
    


 public void LlenarTabla(JTable jTableUsuarios ) {
       try{ 
           
            con = ConexionBD.getConexion();
            String[] titulos = {"Codigo","Nombre","Tipo"};/*ArrayList con los header de la tabla*/
            
            String sql= "select  usuarios.id_usuario, usuarios.nombre,tipousuarios.nombre_tipo \n" +
            "from   usuarios\n" +
            "inner  join tipousuarios  on usuarios.id_tipo = tipousuarios.id_tipo\n";
            
            
                
            
            modelo = new DefaultTableModel(null,titulos);
            sent = con.createStatement();
           
        
            
            ResultSet resultado = sent.executeQuery(sql);/*Metodo para crear un objeto con el almacenamiento de un resultado de una consulta sql*/
            
            
            
            String [] fila = new String[3];/*ArrayList con el resultado de la consulta a la BD*/
            
            while(resultado.next()){        /*Metodo .next ayuda a recorrer el interior de un objeto, mostrando el siguiente*/
                fila[0] = resultado.getString("usuarios.id_usuario");
                fila[1] = resultado.getString("usuarios.nombre");
                fila[2] = resultado.getString("tipousuarios.nombre_tipo");
                
                
                modelo.addRow(fila);
            }
            
            jTableUsuarios.setModel(modelo);/*Llenar el default tabla con el modelo de la tabla deseada*/
       
       } catch(Exception e){
           e.printStackTrace();
       }
    
 
    


 }


}
