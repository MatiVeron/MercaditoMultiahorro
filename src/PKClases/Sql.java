/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKClases;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Matias
 */
public class Sql {
        private String nuevoNum ="";
        private int num;
    
    public int id_autoincrementalMarca(){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Connection con = ConexionBD.getConexion();
        
        try{
            String sql = "SELECT MAX(id_marca)FROM marcas;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                id = rs.getInt(1) + 1;
               }
        
        
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        
        }
        
    return id;
    }
    
    public int id_autoincrementalCategoria(){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Connection con = ConexionBD.getConexion();
        
        try{
            String sql = "SELECT MAX(id_categoria)FROM categorias;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                id = rs.getInt(1) + 1;
               }
        
        
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        
        }
        
    return id;
    }
    
    public int id_autoincrementalFamilia(){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Connection con = ConexionBD.getConexion();
        
        try{
            String sql = "SELECT MAX(id_familia)FROM familias;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                id = rs.getInt(1) + 1;
               }
        
        
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        
        }
        
    return id;
    }
    
    
        public int id_autoincrementalProducto(){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Connection con = ConexionBD.getConexion();
        
        try{
            String sql = "SELECT MAX(id_producto)FROM productos;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                id = rs.getInt(1) + 1;
               }
        
        
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        
        }
        
    return id;
    }
         public int id_autoincrementalVenta(){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Connection con = ConexionBD.getConexion();
        
        try{
            String sql = "SELECT MAX(id_venta)FROM venta;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                id = rs.getInt(1) + 1;
               }
        
        
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        
        }
        
    return id;
    }
    
          public int id_autoincrementalDetalle(){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Connection con = ConexionBD.getConexion();
        
        try{
            String sql = "SELECT MAX(id_detalle)FROM detalleventa;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                id = rs.getInt(1) + 1;
               }
        
        
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        
        }
        
    return id;
    }
          
    public int id_autoincrementalFactura(){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Connection con = ConexionBD.getConexion();
        
        try{
            String sql = "SELECT MAX(numero_venta)FROM venta;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                id = rs.getInt(1) + 1;
               }


        
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        
        }
        
    return id;
    }
    
    
    public String generarNumeroComprobante(int num) {

    this.nuevoNum = String.format("%04d", num);
    return nuevoNum;
    
}
    
        public int id_autoincrementalIdUsuario(){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Connection con = ConexionBD.getConexion();
        
        try{
            String sql = "SELECT MAX(id_usuario)FROM usuarios;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                id = rs.getInt(1) + 1;
               }
        
        
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        
        }
        
    return id;
    }
                
        public int id_caja(){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Connection con = ConexionBD.getConexion();
        
        try{
            String sql = "SELECT MAX(id_caja)FROM apertura;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                id = rs.getInt(1) + 1;
               }
        
        
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        
        }
        
    return id;
    }

        public int id_caja_cierre(){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Connection con = ConexionBD.getConexion();
        
        try{
            String sql = "SELECT MAX(id_cierre)FROM cierre;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                id = rs.getInt(1) + 1;
               }
        
        
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        
        }
        
    return id;
    }





}
