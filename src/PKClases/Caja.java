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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Matias
 */
public class Caja {
        Connection con;
        private int IdCaja;
        private String montoInicial;
        private String montoFinal;
        private String retirado;
        private String adicionado;
        private String total;
        private String saldo_final;
        private String arqueoCaja;
        private int  idUsuario;
        private String fecha_apertura;
        private String fecha_cierre;

    public String getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public String getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(String fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

        
        
        
    public void setIdCaja(int IdCaja) {
        this.IdCaja = IdCaja;
    }

    public int getIdCaja() {
        return IdCaja;
    }        
        
        
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

   

    public String getMontoInicial() {
        return montoInicial;
    }

    public String getMontoFinal() {
        return montoFinal;
    }

    public String getRetirado() {
        return retirado;
    }

    public String getAdicionado() {
        return adicionado;
    }

    public String getTotal() {
        return total;
    }

    public String getSaldo_final() {
        return saldo_final;
    }

    public String getArqueoCaja() {
        return arqueoCaja;
    }



    public void setArqueoCaja(String arqueoCaja) {
        this.arqueoCaja = arqueoCaja;
    }

   

    public void setMontoInicial(String montoInicial) {
        this.montoInicial = montoInicial;
    }

    public void setMontoFinal(String montoFinal) {
        this.montoFinal = montoFinal;
    }

    public void setRetirado(String retirado) {
        this.retirado = retirado;
    }

    public void setAdicionado(String adicionado) {
        this.adicionado = adicionado;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setSaldo_final(String saldo_final) {
        this.saldo_final = saldo_final;
    }

 
      
        
        
        
        public void inicio_caja(int id_caja, double monto_inicial,String fecha_apertura,int id_user,int id_estado_caja){
            
            try {
            con = ConexionBD.getConexion();
            PreparedStatement ps;
            
            String sql = "INSERT INTO `apertura` (`id_caja`, `monto_inicial`, `fecha_hora_apertura`, `id_usuario`,id_estado_caja)"+
                    "VALUES (?,?,?, ?,?)";
               
                ps = con.prepareStatement(sql);
                
                ps.setInt(1, id_caja);
                ps.setDouble(2, monto_inicial);       
                ps.setString(3, fecha_apertura);
                ps.setInt(4, id_user);
                ps.setInt(5, id_estado_caja);
                
                
        
                int n=ps.executeUpdate();
                
        
            if(n>0)
                JOptionPane.showMessageDialog(null, "Se ha abierto una nueva caja");                
            
            
            } catch (SQLException ex) {
                Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Problemas al inciar la caja");
            }
            
        
        
        
        }
        
        public void cerrar_caja(int id_cierre,double monto_final, String fecha_cierre,double total_ventas,double arqueo,int id_usuario,int id_apertura ){
             try {
            con = ConexionBD.getConexion();
            PreparedStatement ps;
            
            String sql = "INSERT INTO cierre (id_cierre, monto_final, fecha_hora_cierre, total_ventas,arqueo,id_usuario,id_caja)"+
                    "VALUES (?,?,?,?,?,?,?)";
               
                ps = con.prepareStatement(sql);
                
                ps.setInt(1, id_cierre);
                ps.setDouble(2, monto_final);       
                ps.setString(3, fecha_cierre);
                ps.setDouble(4,total_ventas);
                ps.setDouble(5, arqueo);
                ps.setInt(6, id_usuario);
                ps.setInt(7, id_apertura);
                
                
        
                int n=ps.executeUpdate();
                
        
            if(n>0)
                JOptionPane.showMessageDialog(null, "Caja cerrada exitosamente");                
            
            
            } catch (SQLException ex) {
                Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Problemas al cerrar la caja");
            }
        
        
        
        
        }
        
        public int obtener_idCaja(){
        int id = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Connection con = ConexionBD.getConexion();
        
        try{
            String sql = "SELECT MAX(id_caja)FROM apertura;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                id = rs.getInt(1);
               }
        
        
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        
        }
        return id;
        }
        
        
        
        public int consultar_estado(int id_caja){
        
        int estado = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Connection con = ConexionBD.getConexion();
        
        try{
            String sql = "SELECT id_estado_caja FROM apertura WHERE id_caja = ?";
            ps = con.prepareStatement(sql);
            
            
            ps.setInt(1, id_caja);
            
            rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                estado = rs.getInt("apertura.id_estado_caja");
               }
        
        
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        
        }
        return estado;
        }
        
        public void cambiar_estado(int id_estado,int id_caja){        
  
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Connection con = ConexionBD.getConexion();
        
        try{
            String sql = "UPDATE apertura SET id_estado_caja = ? WHERE id_caja = ?";
            ps = con.prepareStatement(sql);
            
            
            ps.setInt(1,id_estado );
            ps.setInt(2,id_caja );
            ps.executeUpdate();
                       
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        
        }
      
        }
        
        
        
        
        
        
        
        public double mostrar_monto_inicial (int id_caja){
        
        double monto_inicial = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Connection con = ConexionBD.getConexion();
        
        try{
            String sql = "SELECT monto_inicial FROM apertura WHERE id_caja = ?";
            ps = con.prepareStatement(sql);
            
            
            ps.setInt(1, id_caja);
            
            rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                monto_inicial= rs.getInt("apertura.monto_inicial");
               }
        
        
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        
        }
        return monto_inicial;
        }
        
        
        
}
        
        
        
        
        
        
        
        
        
  
    

