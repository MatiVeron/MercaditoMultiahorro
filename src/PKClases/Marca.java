/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKClases;

import BD.ConexionBD;
import static BD.ConexionBD.con;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matias
 */

    



public class Marca{
    
    private String IdMarca;
    private String nombreMarca;
    Connection con;
    Statement sent;
    
    
    
    
    public Marca(String id ,String nombre){
        
        this.IdMarca = id;
        this.nombreMarca = nombre;}
    
    public Marca(){}
    
    public String getMarca(){
        return this.IdMarca;   
    }
    
    public void setMarca(String id){
        this.IdMarca = id;
    }
    
     public String getNombre(){
        return this.nombreMarca;   
    
     }
     
      public void setNombre(String nombre){
        this.nombreMarca = nombre;   
    }
       
      
       public void agregarMarca( int id ,String nombre, int id_estado ){
     try{
            con = ConexionBD.getConexion();
            String sql=" INSERT INTO marcas (id_marca,nombre_marca,id_estado)" + "Values (?,?,?) ";
                
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setInt(1,id);
            ps.setString(2,nombre);
            ps.setInt(3,id_estado);
           
            
           
            
            ps.executeUpdate();
        
            
                
        
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error"+ e.getMessage());
        }}
       
       
    public void eliminarMarca(String  idMarca){
        con = ConexionBD.getConexion();
        int  confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar esta marca?");
       
        if(confirmar == JOptionPane.YES_OPTION){
            
            try{
                String sql = "DELETE FROM marcas WHERE id_marca = ?";
                
                
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setString(1, idMarca);
                
                if(ps.executeUpdate()> 0){
                    
                    JOptionPane.showMessageDialog(null,"Marca eliminada");
                   
                }else{

                    JOptionPane.showMessageDialog(null,"No se pudo eliminar marca");
                   
                }
                        
            }catch(Exception ex){
                    
                JOptionPane.showMessageDialog(null, ex.getMessage()+"se pudrio");
            }
        
        
        }
   
   
   }

    
      
      
      /*mostrar los objetos categoria en combo box*/ 
    public void mostrarMarca(JComboBox<Marca>jComboBoxMarca){
        
        try{
            con = ConexionBD.getConexion();
            String sql="SELECT * FROM marcas WHERE id_estado = 1 ORDER BY id_marca";
            sent = con.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            
            
            while (rs.next()){
                jComboBoxMarca.addItem(
                        new Marca (
                            rs.getString("id_marca"),    
                            rs.getString("nombre_marca")
                        )
                                );
            }
            
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"error");
             
        
        
        }
    
    }

    public String toString(){
       return  nombreMarca;
    }
    
      
     public void buscar_Marca(String busqueda, JTable jtableMarca){
         con = ConexionBD.getConexion();
        String[] titulos = {"Codigo","Nombre"};;
        String [] fila = new String[2];
        DefaultTableModel ModeloTabla = new DefaultTableModel(null,titulos);      
    
    String sql;
    

         sql = "select marcas.id_marca, marcas.nombre_marca\n" +
                  "from marcas\n" 
                  + "WHERE marcas.nombre_marca LIKE '%"+busqueda+"%'";
      
        try {

        
        PreparedStatement ps = con.prepareStatement(sql);
       
        
        ResultSet resultado = ps.executeQuery();
        
        while (resultado.next()){
          
                fila[0] = resultado.getString("marcas.id_marca");
                fila[1] = resultado.getString("marcas.nombre_marca");
         
          
            ModeloTabla.addRow(fila);
           
        }
        
      jtableMarca.setModel(ModeloTabla);

    }catch (SQLException e) {


        JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
    
    
    
    }
    
    }
     
     public int obtener_idMarca(int id_producto){
            
        con = ConexionBD.getConexion();
        int id_marca = 0;
    
        String sql;
    

         sql = "select marcas.id_marca, marcas.nombre_marca\n" +
                  "from marcas\n"+
                  "inner join productos on marcas.id_marca = productos.id_marca\n"
                  + "WHERE productos.id_producto = ?";
      
        try {

        
        PreparedStatement ps = con.prepareStatement(sql);
       
        ps.setInt(1,id_producto);
        
        ResultSet resultado = ps.executeQuery();
 
        while (resultado.next()){
          
               id_marca = resultado.getInt("marcas.id_marca");

        }
        
     
        }catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
    
    }
        return id_marca;}
     
     
     public String obtener_NombreMarca(int id_marca){
            
        con = ConexionBD.getConexion();
        String nombre_marca = "";
    
        String sql;

         sql = "select marcas.id_marca, marcas.nombre_marca\n" +
                  "from marcas\n"
                  + "WHERE marcas.id_marca = ?";
      
        try {

        PreparedStatement ps = con.prepareStatement(sql);
       
        ps.setInt(1,id_marca);
        
        ResultSet resultado = ps.executeQuery();
 
        while (resultado.next()){
          
               nombre_marca = resultado.getString("marcas.nombre_marca");

        }
        
     
        }catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
    
    }
        return nombre_marca;}   
    
    
    public void inactivarMarca(int id_marca){
    
    int confirmar = JOptionPane.showConfirmDialog(null, "¿Inactivar esta Marca?");
     con = ConexionBD.getConexion();

    if(confirmar == JOptionPane.YES_OPTION){



        try {



            String sql = "UPDATE marcas SET  id_estado = 2 \n"+" WHERE id_marca= ?";

            PreparedStatement ps = con.prepareStatement(sql);

            

            ps.setInt(1, id_marca);
            



            if(ps.executeUpdate() > 0){

                JOptionPane.showMessageDialog(null, "Los datos han sido borrados de la tabla con éxito", "Operación Exitosa", 
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
    
    


