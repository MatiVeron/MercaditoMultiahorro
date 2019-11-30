
package PKClases;

import BD.ConexionBD;
import static BD.ConexionBD.con;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class Producto {
    private int codigo;
    private String nombre;
    private String[] categoria;
    private float precio;
    
    
    public Producto(){}

    
    public Producto( int codigo, String nombre,String[] categoria, float precio){
        this.codigo =  codigo;
        this.nombre =  nombre;
        this.categoria =  categoria;
        this.precio =  precio;
        
    }
    /*Set*/
    public void setCodigo(int c){
    this.codigo = c; 
} 
    public void setNombre(String n){
        this.nombre = n; 
    } 
    
    public void setCategoria(String[] cat){
        this.categoria = cat; 
    } 
    
    public void setPrecio(float pre){
        this.precio = pre; 
    } 

    /*Get*/
    public int getCodigo(){

        return this.codigo;
    }
    public String getNombre(){

        return this.nombre;
    }
     
    public String[]  getCategoria(){

        return this.categoria;
    }
    
     public float getPrecio(){

        return this.precio;
    }
    
     public void agregarProducto(String cod, String nombre, String precio,String cantidad,String id,String idMarca,String idFamilia,String codigoBarras ){
     try{
            String sql=" INSERT INTO productos (id_producto,nombre_producto,precio_producto,cantidad,id_categoria,id_marca,id_familia,codigo_barras)" +
           "Values (?,?,?,?,?,?,?,?) ";
                
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,cod);
            ps.setString(2,nombre);
            ps.setString(3, precio);
            ps.setString(4,cantidad);
            ps.setString(5,id);
            ps.setString(6,idMarca);
            ps.setString(7,idFamilia);
            ps.setString(8,codigoBarras);
            
            
           
            
            int n=ps.executeUpdate();
        
            if(n>0)
                JOptionPane.showMessageDialog(null, "datos guardados");
                
        
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+ e.getMessage());
        }}
    
     
      
    
    
    public void buscarProducto(String busqueda, String filtro, JTable jtableProd){

    String[] titulos = {"Codigo","Descripcion","Cod.Barras","Marca","Familia","Precio","Cantidad","Categoria"};;
    String [] fila = new String[8];
    DefaultTableModel ModeloTabla = new DefaultTableModel(null,titulos);      
    
    String sql;
    
    if(filtro.equals("Categorias")){
         sql = "select productos.id_producto, productos.nombre_producto,productos.codigo_barras, productos.precio_producto,productos.cantidad,categorias.nombre_categoria,marcas.nombre_marca,familias.nombre_familia\n" +
                  "from productos\n" +
                  "inner join categorias  on productos.id_categoria = categorias.id_categoria\n" +
                  "inner join marcas  on  productos.id_marca = marcas.id_marca \n" +
                  "inner join familias  on productos.id_familia = familias.id_familia "
                  + "WHERE categorias.nombre_categoria LIKE '%"+busqueda+"%'  ORDER BY categorias.id_categoria ASC";
    }else{
        
           if(filtro.equals("Marcas")){
    
            sql = "select productos.id_producto, productos.nombre_producto,productos.codigo_barras, productos.precio_producto,productos.cantidad,categorias.nombre_categoria,marcas.nombre_marca,familias.nombre_familia \n" +
                  "from productos\n" +
                  "inner join categorias  on productos.id_categoria = categorias.id_categoria\n" +
                  "inner join marcas  on  productos.id_marca = marcas.id_marca \n" +
                  "inner join familias  on productos.id_familia = familias.id_familia "
                  + "WHERE marcas.nombre_marca LIKE '%"+busqueda+"%'  ORDER BY marcas.id_marca ASC";
            
           }else{
  
    if(filtro.equals("Codigo")){
    
            sql = "select productos.id_producto, productos.nombre_producto,productos.codigo_barras, productos.precio_producto,productos.cantidad,categorias.nombre_categoria,marcas.nombre_marca,familias.nombre_familia \n" +
                  "from productos\n" +
                  "inner join categorias  on productos.id_categoria = categorias.id_categoria\n" +
                  "inner join marcas  on  productos.id_marca = marcas.id_marca \n" +
                  "inner join familias  on productos.id_familia = familias.id_familia "
                  + "WHERE productos.id_producto LIKE '%"+busqueda+"%'  ORDER BY productos.id_producto ASC";
       
    }else{
        if(filtro.equals("Familia")){
    
            sql = "select productos.id_producto, productos.nombre_producto,productos.codigo_barras, productos.precio_producto,productos.cantidad,categorias.nombre_categoria,marcas.nombre_marca,familias.nombre_familia \n" +
                  "from productos\n" +
                  "inner join categorias  on productos.id_categoria = categorias.id_categoria\n" +
                  "inner join marcas  on  productos.id_marca = marcas.id_marca \n" +
                  "inner join familias  on productos.id_familia = familias.id_familia "
                  + "WHERE familias.nombre_familia LIKE '%"+busqueda+"%'  ORDER BY familias.id_familia ASC";
        }else{
        
        sql =   "select productos.id_producto, productos.nombre_producto,productos.codigo_barras, productos.precio_producto,productos.cantidad,categorias.nombre_categoria,marcas.nombre_marca,familias.nombre_familia \n" +
                  "from productos\n" +
                  "inner join categorias  on productos.id_categoria = categorias.id_categoria\n" +
                  "inner join marcas  on  productos.id_marca = marcas.id_marca \n" +
                  "inner join familias  on productos.id_familia = familias.id_familia "
                  + "WHERE productos.nombre_producto LIKE '%"+busqueda+"%'  ORDER BY productos.id_producto ASC";
        
    }}}}
     
         
    try {

        
        PreparedStatement ps = con.prepareStatement(sql);
       
        
        ResultSet resultado = ps.executeQuery();
        
        while (resultado.next()){
          
                fila[0] = resultado.getString("productos.id_producto");
                fila[1] = resultado.getString("productos.nombre_producto");
                fila[2] = resultado.getString("productos.codigo_barras");
                fila[3] = resultado.getString("marcas.nombre_marca");
                fila[4] = resultado.getString("familias.nombre_familia");
                fila[5] = resultado.getString("productos.precio_producto");
                fila[6] = resultado.getString("productos.cantidad");
                fila[7] = resultado.getString("categorias.nombre_categoria"); 
          
            ModeloTabla.addRow(fila);
           
        }
        
         jtableProd.setModel(ModeloTabla);

    }catch (SQLException e) {


        JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
    
    
    
    }
    
    }
    
    
   public void eliminarProducto(int codigo){
       
      int  confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este producto?");
       
        if(confirmar == JOptionPane.YES_OPTION){
            
            try{
                String sql = "DELETE FROM productos WHERE id_producto = ?";
                
                
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setInt(1, codigo);
                
                if(ps.executeUpdate()> 0){
                    
                    JOptionPane.showMessageDialog(null,"Producto eliminado");
                    con.close();
                }else{

                    JOptionPane.showMessageDialog(null,"No se pudo eliminar producto");
                    con.close();
                }
                        
            }catch(Exception e){
                    
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        
        
        }
   
   
   }




public void modificarProducto (String nombre, double precio, int cantidad, int id_categoria, int id_producto,int id_marca,int id_familia, String codigoBarras){

    int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos del producto?");
   

    if(confirmar == JOptionPane.YES_OPTION){



        try {



            String sql = "UPDATE productos SET  nombre_producto=?, precio_producto=?, cantidad=?, id_categoria=?, id_marca = ?,id_familia = ?, codigo_barras = ?  WHERE id_producto=?";

            PreparedStatement ps = con.prepareStatement(sql);

            
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3,cantidad );
            ps.setInt(4, id_categoria);
            ps.setInt(5, id_marca);
            ps.setInt(6, id_familia);
            ps.setString(7, codigoBarras);
            ps.setInt(8, id_producto);
            



            if(ps.executeUpdate() > 0){

                JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa", 
                                              JOptionPane.INFORMATION_MESSAGE);

            }else{

                JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                              + "Inténtelo nuevamente.", "Error en la operación", 
                                              JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                              + "Inténtelo nuevamente.\n"
                                              + "Error: "+e, "Error en la operación", 
                                              JOptionPane.ERROR_MESSAGE);

        }

        }


    }

} 

       

  


    
    
    
    

