
package PKClases;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TablaProductos {
    Connection con = ConexionBD.getConexion();
    DefaultTableModel modelo;
    Statement sent;
    Statement sent2;
    


 public void LlenarTabla(JTable jTableProductos ) {
       try{ 
           
            con = ConexionBD.getConexion();
            String[] titulos = {"Codigo","Nombre","Precio","Cantidad","Categoria"};/*ArrayList con los header de la tabla*/
            String sql= "SELECT * FROM productos";
            
            String sql2 = "SELECT nombre_categoria FROM categorias INNER JOIN productos ON categorias.id_categoria = productos.id_categoria ";
            
            modelo = new DefaultTableModel(null,titulos);
            sent = con.createStatement();
           
            sent2 = con.createStatement();
            
            ResultSet resultado = sent.executeQuery(sql);/*Metodo para crear un objeto con el almacenamiento de un resultado de una consulta sql*/
            
            ResultSet resultado2 = sent2.executeQuery(sql2);
            
            String [] fila = new String[5];/*ArrayList con el resultado de la consulta a la BD*/
            
            while(resultado.next() & resultado2.next()){        /*Metodo .next ayuda a recorrer el interior de un objeto, mostrando el siguiente*/
                fila[0] = resultado.getString("id_producto");
                fila[1] = resultado.getString("nombre_producto");
                fila[2] = resultado.getString("precio_producto");
                fila[3] = resultado.getString("cantidad");
                fila[4] = resultado2.getString("nombre_categoria"); 
                
                
                /*LAS LINEAS COMENTADAS SON PARA VISUALIZAR LA CATEGORIA EN LA TABLA DE PRODUCTOS!!*/
                
                modelo.addRow(fila);
            }
            
            jTableProductos.setModel(modelo);/*Llenar el default tabla con el modelo de la tabla deseada*/
       
       } catch(Exception e){
           e.printStackTrace();
       }
    
 
    


 }


}