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

 
      
        
        
        
        public void inicio_caja(int id_caja, double monto_inicial,String fecha_apertura,int id_user){
            
            try {
            con = ConexionBD.getConexion();
            PreparedStatement ps;
            
            String sql = "INSERT INTO `apertura` (`id_caja`, `monto_inicial`, `fecha_hora_apertura`, `id_usuario`)"+
                    "VALUES (?,?,?, ?)";
               
                ps = con.prepareStatement(sql);
                
                ps.setInt(1, id_caja);
                ps.setDouble(2, monto_inicial);       
                ps.setString(3, fecha_apertura);
                ps.setInt(4, id_user);
                
                
        
                int n=ps.executeUpdate();
                
        
            if(n>0)
                JOptionPane.showMessageDialog(null, "Se ha abierto una nueva caja");                
            
            
            } catch (SQLException ex) {
                Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Problemas al inciar la caja");
            }
            
        
        
        
        }
        
        
          /* public void mostrar_caja(int id_caja, double monto_inicial,String fecha_apertura,int id_user){
            PreparedStatement ps;
           
            
            try {
            con = ConexionBD.getConexion();
            
            String sql = "SELECT * FROM inciocaja";
                    
               
                ps = con.prepareStatement(sql);
                ps.setInt(1, id_caja);
                ps.setDouble(2, monto_inicial);       
                ps.setString(3, fecha_apertura);
                ps.setInt(4, id_user);
                
                ps.executeQuery();
        
                
                JOptionPane.showMessageDialog(null,"problem");
        
                           
            
            
            } catch (SQLException ex) {
                Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"ni ahi ameo");
            }
            
        
        
        
        }*/
      
    
}
