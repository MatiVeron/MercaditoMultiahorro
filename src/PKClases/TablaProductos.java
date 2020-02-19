
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
    
    


 public void LlenarTabla(JTable jTableProductos ) {
       try{ 
           
            con = ConexionBD.getConexion();
            String[] titulos = {"Codigo","Descripcion","Cod.Barras","Marca","Familia","Precio","Cantidad","Categoria"};/*ArrayList con los header de la tabla*/
            
            String sql= "select productos.id_producto, productos.nombre_producto, productos.precio_producto,productos.cantidad,productos.codigo_barras,categorias.nombre_categoria,marcas.nombre_marca,familias.nombre_familia \n" +
            "from   productos\n" +
            "inner  join categorias  on productos.id_categoria = categorias.id_categoria\n" +
            "inner  join marcas  on  productos.id_marca = marcas.id_marca \n" +
            "inner  join familias on productos.id_familia = familias.id_familia "+
            "WHERE productos.id_estado = 1"     ;
            
                
            
            modelo = new DefaultTableModel(null,titulos);
            sent = con.createStatement();
           
        
            
            ResultSet resultado = sent.executeQuery(sql);/*Metodo para crear un objeto con el almacenamiento de un resultado de una consulta sql*/
            
            
            
            String [] fila = new String[8];/*ArrayList con el resultado de la consulta a la BD*/
            
            while(resultado.next()){        /*Metodo .next ayuda a recorrer el interior de un objeto, mostrando el siguiente*/
                fila[0] = resultado.getString("productos.id_producto");
                fila[1] = resultado.getString("productos.nombre_producto");
                fila[2] = resultado.getString("productos.codigo_barras");
                fila[3] = resultado.getString("marcas.nombre_marca");
                fila[4] = resultado.getString("familias.nombre_familia");
                fila[5] = resultado.getString("productos.precio_producto");
                fila[6] = resultado.getString("productos.cantidad");
                fila[7] = resultado.getString("categorias.nombre_categoria"); 
                
                
                
                
                modelo.addRow(fila);
            }
            
            jTableProductos.setModel(modelo);/*Llenar el default tabla con el modelo de la tabla deseada*/
       
       } catch(Exception e){
           e.printStackTrace();
       }
    
 
    


 }


}