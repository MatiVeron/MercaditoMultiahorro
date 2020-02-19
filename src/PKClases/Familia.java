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


public class Familia {
    
    private String IdFamilia;
    private String nombreFamilia;
    Connection con;
    Statement sent;

    
    
    
    
    public Familia(String id ,String nombre){
        
        this.IdFamilia = id;
        this.nombreFamilia = nombre;}
    
    public Familia(){}

   
    
    public String getFamilia(){
        return this.IdFamilia;   
    }
    
    public void setFamilia(String id){
        this.IdFamilia= id;
    }
    
     public String getNombre(){
        return this.nombreFamilia;   
    
     }
     
      public void setNombre(String nombre){
        this.nombreFamilia = nombre;   
    }
      
      
       public void agregarFamilia(int id,String descripcion, int id_estado){
      
      try{
        con = ConexionBD.getConexion();

        String sql = "INSERT INTO familias (id_familia,nombre_familia,id_estado)"+" VALUES (?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,id);
        ps.setString(2, descripcion);
        ps.setInt(3, id_estado);


        ps.executeUpdate();

      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
      }
      
      }
       
       public void eliminarFamilia(String idFamilia){
      con=ConexionBD.getConexion();
      int  confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este producto?");
       
        if(confirmar == JOptionPane.YES_OPTION){
            
            try{
                String sql = "DELETE FROM familias WHERE id_familia = ?";
                
                
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setString(1, idFamilia);
                
                if(ps.executeUpdate()> 0){
                    
                    JOptionPane.showMessageDialog(null,"Familia eliminada");
                   
                }else{

                    JOptionPane.showMessageDialog(null,"No se pudo eliminar familia");
                   
                }
                        
            }catch(Exception e){
                    
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        
        
        }
   
   
   }
       
      
      
      
      
       /*mostrar los objetos categoria en combo box*/ 
    public void mostrarFamilia(JComboBox<Familia>jComboBoxFamilia){
        
        try{
            con = ConexionBD.getConexion();
            String sql="SELECT * FROM familias WHERE id_estado = 1 ORDER BY id_familia";
            sent = con.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            
            
            while (rs.next()){
                jComboBoxFamilia.addItem(new Familia(
                            rs.getString("id_familia"),    
                            rs.getString("nombre_familia")
                        )
                                );
            }
            
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"error");
             
        
        
        }
    
    }
    
    public String toString(){
        return nombreFamilia;
    }

     public void buscar_Familia(String busqueda, JTable jtableFamilia){
         con = ConexionBD.getConexion();
        String[] titulos = {"Codigo","Nombre"};;
        String [] fila = new String[2];
        DefaultTableModel ModeloTabla = new DefaultTableModel(null,titulos);      
    
    String sql;
    

         sql = "select familias.id_familia, familias.nombre_familia\n" +
                  "from familias\n" 
                  + "WHERE familias.nombre_familia LIKE '%"+busqueda+"%'";
      
        try {

        
        PreparedStatement ps = con.prepareStatement(sql);
       
        
        ResultSet resultado = ps.executeQuery();
        
        while (resultado.next()){
          
                fila[0] = resultado.getString("familias.id_familia");
                fila[1] = resultado.getString("familias.nombre_familia");
         
          
            ModeloTabla.addRow(fila);
           
        }
        
      jtableFamilia.setModel(ModeloTabla);

    }catch (SQLException e) {


        JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
    
    
    
    }
        

    
    }



        public int obtener_idFamilia(int id_producto){
            
        con = ConexionBD.getConexion();
        int id_familia = 0;
    
        String sql;
    

         sql = "select familias.id_familia, familias.nombre_familia\n" +
                  "from familias\n"+
                  "inner join productos on familias.id_familia = productos.id_familia\n"
                  + "WHERE productos.id_producto = ?";
      
        try {

        
        PreparedStatement ps = con.prepareStatement(sql);
       
        ps.setInt(1,id_producto);
        
        ResultSet resultado = ps.executeQuery();
 
        while (resultado.next()){
          
               id_familia = resultado.getInt("familias.id_familia");

        }
        
     
        }catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
    
    }
        return id_familia;}
        
        
        public String obtener_NombreFamilia(int id_familia){
            
        con = ConexionBD.getConexion();
        String nombre_familia = "";
    
        String sql;

         sql = "select familias.id_familia, familias.nombre_familia\n" +
                  "from familias\n"
                  + "WHERE familias.id_familia = ?";
      
        try {

        PreparedStatement ps = con.prepareStatement(sql);
       
        ps.setInt(1,id_familia);
        
        ResultSet resultado = ps.executeQuery();
 
        while (resultado.next()){
          
               nombre_familia = resultado.getString("familias.nombre_familia");

        }
        
     
        }catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
    
    }
        return nombre_familia;}


public void inactivarFamilia(int id_familia){
    
    int confirmar = JOptionPane.showConfirmDialog(null, "¿Inactivar esta familia?");
     con = ConexionBD.getConexion();

    if(confirmar == JOptionPane.YES_OPTION){



        try {



            String sql = "UPDATE familias SET  id_estado = 2 \n"+" WHERE id_familia= ?";

            PreparedStatement ps = con.prepareStatement(sql);

            

            ps.setInt(1, id_familia);
            



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


}}