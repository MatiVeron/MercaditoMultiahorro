
package PKClases;

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
    
     public void agregarProducto(String cod, String nombre, String precio,String cantidad,String id ){
     try{
            String sql=" INSERT INTO productos (id_producto,nombre_producto,precio_producto,cantidad,id_categoria)" +
           "Values (?,?,?,?,?) ";
                
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,cod);
            ps.setString(2,nombre);
            ps.setString(3, precio);
            ps.setString(4,cantidad);
            ps.setString(5,id);
            
           
            
            int n=ps.executeUpdate();
        
            if(n>0)
                JOptionPane.showMessageDialog(null, "datos guardados");
                
        
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+ e.getMessage());
        }}
    
     
      
    
    
    public void buscarProducto(String busqueda, String filtro, JTable jtableProd){

    String [] columnas={"codigo","nombre","precio","cantidad"};
    String [] registro = new String[4];
    DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);      
    
    String sql;
    String sql2;
    
  
    if(filtro.equals("codigo")){
    
        sql = "SELECT id_producto, nombre_producto, precio_producto,cantidad FROM productos WHERE id_producto LIKE '%"+busqueda+"%'  ORDER BY id_producto ASC";
      
       
    }else{
        
        sql = "SELECT id_producto, nombre_producto, precio_producto,cantidad FROM productos WHERE nombre_producto LIKE '%"+busqueda+"%' ORDER BY nombre_producto ASC";
        
    }
     
         
    try {

        
        PreparedStatement ps = con.prepareStatement(sql);
       
        
        ResultSet resultado = ps.executeQuery();
        
        while (resultado.next()){
          
            registro[0]=resultado.getString("id_producto");
            registro[1]=resultado.getString("nombre_producto");
            registro[2]=resultado.getString("precio_producto");
            registro[3]=resultado.getString("cantidad");
          
            ModeloTabla.addRow(registro);
           
        }
        
         jtableProd.setModel(ModeloTabla);

    }catch (SQLException e) {


        JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
    
    
    
    }
    
    }
    
    
   public void eliminarProducto(String codigo){
       
      int  confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este producto?");
       
        if(confirmar == JOptionPane.YES_OPTION){
            
            try{
                String sql = "DELETE FROM productos WHERE id_producto = ?";
                
                
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setString(1, codigo);
                
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




public void modificarProducto (String nombre, String precio, String cantidad, String id, String codigo){

    int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos del producto?");


    if(confirmar == JOptionPane.YES_OPTION){



        try {



            String sql = "UPDATE productos SET  nombre_producto=?, precio_producto=?, cantidad=?, id_categoria=?  WHERE id_producto=?";

            PreparedStatement ps = con.prepareStatement(sql);

            
            ps.setString(1, nombre);
            ps.setString(2, precio);
            ps.setString(3,cantidad );
            ps.setString(4, id);
            ps.setString(5, codigo);



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

       

  


    
    
    
    

