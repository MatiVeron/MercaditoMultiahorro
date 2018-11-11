
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
    Statement sent3;
    Statement sent4;
    


 public void LlenarTabla(JTable jTableProductos ) {
       try{ 
           
            con = ConexionBD.getConexion();
            String[] titulos = {"Codigo","Descripcion","Marca","Unidad","Precio","Cantidad","Categoria"};/*ArrayList con los header de la tabla*/
            
            String sql= "select productos.id_producto, productos.nombre_producto, productos.precio_producto,productos.cantidad,categorias.nombre_categoria,marcas.nombre_marca,unidades.nombre_unidad \n" +
            "from   productos\n" +
            "inner  join categorias  on productos.id_categoria = categorias.id_categoria\n" +
            "inner  join marcas  on  productos.id_marca = marcas.id_marca \n" +
            "inner  join unidades  on productos.id_unidad = unidades.id_unidad ";
            
                
            
            modelo = new DefaultTableModel(null,titulos);
            sent = con.createStatement();
           
        
            
            ResultSet resultado = sent.executeQuery(sql);/*Metodo para crear un objeto con el almacenamiento de un resultado de una consulta sql*/
            
            
            
            String [] fila = new String[7];/*ArrayList con el resultado de la consulta a la BD*/
            
            while(resultado.next()){        /*Metodo .next ayuda a recorrer el interior de un objeto, mostrando el siguiente*/
                fila[0] = resultado.getString("productos.id_producto");
                fila[1] = resultado.getString("productos.nombre_producto");
                fila[2] = resultado.getString("marcas.nombre_marca");
                fila[3] = resultado.getString("unidades.nombre_unidad");
                fila[4] = resultado.getString("productos.precio_producto");
                fila[5] = resultado.getString("productos.cantidad");
                fila[6] = resultado.getString("categorias.nombre_categoria"); 
                
                
                /*LAS LINEAS COMENTADAS SON PARA VISUALIZAR LA CATEGORIA EN LA TABLA DE PRODUCTOS!!*/
                
                modelo.addRow(fila);
            }
            
            jTableProductos.setModel(modelo);/*Llenar el default tabla con el modelo de la tabla deseada*/
       
       } catch(Exception e){
           e.printStackTrace();
       }
    
 
    


 }


}