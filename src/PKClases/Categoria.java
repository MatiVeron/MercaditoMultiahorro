
package PKClases;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Categoria {
    
    private String IdCategoria;
    private String nombreCategoria;
    Connection con;
    Statement sent;
    
    
    
    
    public Categoria(String id ,String nombre){
        
        this.IdCategoria = id;
        this.nombreCategoria = nombre;}
    
    public Categoria(){}
    
    public String getCategoria(){
        return this.IdCategoria;   
    }
    
    public void setCategoria(String id){
        this.IdCategoria = id;
    }
    
     public String getNombre(){
        return this.nombreCategoria;   
    
     }
     
      public void setNombre(String nombre){
        this.nombreCategoria = nombre;   
    }
      
      public void agregarCategoria(int id,String descripcion){
      
      try{
        con = ConexionBD.getConexion();

        String sql = "INSERT INTO categorias (id_categoria,nombre_categoria)"+" VALUES (?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,id);
        ps.setString(2, descripcion);


        ps.executeUpdate();

      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
      }
      
      }
      
      
      public void eliminarCategoria(String idCategoria){
 
        int  confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este producto?");
       
        if(confirmar == JOptionPane.YES_OPTION){
            
            try{
                con = ConexionBD.getConexion();
                String sql = "DELETE FROM categorias WHERE id_categoria= ?";
                
                
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setString(1, idCategoria);
                
                if(ps.executeUpdate()> 0){
                    
                    JOptionPane.showMessageDialog(null,"Categoria eliminada");
                    
                }else{

                    JOptionPane.showMessageDialog(null,"No se pudo eliminar categoria");
                    
                }
                        
            }catch(Exception e){
                    
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        
        
        }
   
   
   }
      
      public void buscar_Categoria(String busqueda, JTable jtableCategoria){
        con = ConexionBD.getConexion();
        String[] titulos = {"Codigo","Nombre"};
        String [] fila = new String[2];
        DefaultTableModel ModeloTabla = new DefaultTableModel(null,titulos);      
        PreparedStatement ps;
        String sql;
    
  
         sql = "SELECT categorias.id_categoria, categorias.nombre_categoria FROM categorias WHERE categorias.nombre_categoria LIKE '%"+busqueda+"%' ";              
    try {

        
         ps = con.prepareStatement(sql);
       
        
        ResultSet resultado = ps.executeQuery();
        
        while (resultado.next()){
          
                fila[0] = resultado.getString("categorias.id_categoria");
                fila[1] = resultado.getString("categorias.nombre_categoria");


            ModeloTabla.addRow(fila);
           
        }
        
         jtableCategoria.setModel(ModeloTabla);

    }catch (SQLException e) {


        JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
    
    
    
    }
    
    }    
      
      
      
      
      
      
       /*mostrar los objetos categoria en combo box*/ 
    public void mostrarCategoria(JComboBox<Categoria>jComboBoxCategoria){
        
        try{
            con = ConexionBD.getConexion();
            String sql="SELECT * FROM categorias ORDER BY id_categoria";
            sent = con.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            
            
            while (rs.next()){
                jComboBoxCategoria.addItem(
                        new Categoria (
                            rs.getString("id_categoria"),    
                            rs.getString("nombre_categoria")
                        )
                                );
            }
            
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"error");
             
        
        
        }
    
    }
    
    public String toString(){
        return nombreCategoria;
    }
      
      public Object[] [] obtener_categoria (int id_categoria ,String nombre_categoria){
          int registros = 0;
          con = ConexionBD.getConexion();
    
          
          Object[][] data = new Object[registros][2];
          
          int id;
          String name;
           try{
                String sql="SELECT id_categoria,nombre_categoria FROM categorias WHERE nombre_categoria = '"+id_categoria+"'AND id_categoria = '"+nombre_categoria+"'";
                PreparedStatement pstm = con.prepareStatement(sql);
                ResultSet res  = pstm.executeQuery();
                int i= 0;
                while(res.next()) {
                    
                    id = res.getInt("id_categoria");
                    name = res.getString("nombre_categoria");
                    
                    data[i][0] = id;
                    data[i][1] = name;
                    
                    i++;
                    
                }
                res.close();
                  }catch(SQLException e){
                System.out.print(e);
            }
      
      
      
      return data;
      }
              public int obtener_idCategoria(int id_producto){
            
        con = ConexionBD.getConexion();
        int id_categoria = 0;
    
        String sql;
    

         sql = "select categorias.id_categoria, categorias.nombre_categoria\n" +
                  "from categorias\n"+
                  "inner join productos on categorias.id_categoria = productos.id_categoria\n"
                  + "WHERE productos.id_producto = ?";
      
        try {

        
        PreparedStatement ps = con.prepareStatement(sql);
       
        ps.setInt(1,id_producto);
        
        ResultSet resultado = ps.executeQuery();
 
        while (resultado.next()){
          
               id_categoria = resultado.getInt("categorias.id_categoria");

        }
        
     
        }catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
    
    }
        return id_categoria;}
              
          public String obtener_NombreCategoria(int id_categoria){
            
        con = ConexionBD.getConexion();
        String nombre_categoria = "";
    
        String sql;

         sql = "select categorias.id_categoria, categorias.nombre_categoria\n" +
                  "from categorias\n"
                  + "WHERE categorias.id_categoria = ?";
      
        try {

        PreparedStatement ps = con.prepareStatement(sql);
       
        ps.setInt(1,id_categoria);
        
        ResultSet resultado = ps.executeQuery();
 
        while (resultado.next()){
          
               nombre_categoria = resultado.getString("categorias.nombre_categoria");

        }
        
     
        }catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
    
    }
        return nombre_categoria;}            
    
    
              
              
              
              
              
              
              
    }
    

