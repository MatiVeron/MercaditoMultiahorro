
package PKClases;

import BD.ConexionBD;
import static BD.ConexionBD.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Matias
 */
public class Venta {
    
    
    
    public void InsertarVenta(String idVenta,String numVent,String total,String fecha,String idDetalle,String idEstado, int idUsuario,int idCaja){
     try{
            String sql=" INSERT INTO venta (id_venta,numero_venta,total,fecha,id_detalle,id_estado,id_usuario,id_caja)" +
           "Values (?,?,?,?,?,?,?,?) ";
                
            
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,idVenta);
            ps.setString(2,numVent);
            ps.setString(3,total);
            ps.setString(4,fecha);
            ps.setString(5, idDetalle);
            ps.setString(6, idEstado);
            ps.setInt(7, idUsuario);
            ps.setInt(8, idCaja);
            
           
            
            int n=ps.executeUpdate();
        
            if(n>0)
                JOptionPane.showMessageDialog(null, "datos de la venta guardados");
                
        
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error en la venta"+ e.getMessage());
        }}
    
     
    public void  descontarStock(String codi,String cant){
       int des = Integer.parseInt(cant);
       String cap="";
       int desfinal;
       String sql="SELECT * FROM productos WHERE  id_producto='"+codi+"'";
        try {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next())
            {
                cap= rs.getString(4);
            }
            
            
        } catch (Exception e) {}
        
        desfinal=Integer.parseInt(cap)-des;
        String modi="UPDATE productos SET cantidad='"+desfinal+"' WHERE id_producto = '"+codi+"'";
        
        try {
            PreparedStatement pst = con.prepareStatement(modi);
            pst.executeUpdate();} 
        
        catch (Exception e) {}}
    
  
     public double calcular_ventas (int id_caja){
         PreparedStatement ps;
         con = ConexionBD.getConexion();
         double total = 0.0;
         
         String sql = "SELECT SUM(venta.total) as total FROM venta WHERE venta.id_caja = ? AND id_estado = 1";
         try{
         ps = con.prepareStatement(sql);
         
         ps.setInt(1, id_caja);
         
         ResultSet rs = ps.executeQuery();
         while (rs.next()){
             total = rs.getDouble("total");
         
         }
         
         }catch(Exception e){
         
         JOptionPane.showMessageDialog(null,"Error");
         
         
         }
     return total;
     
     }

}




 
    
    

