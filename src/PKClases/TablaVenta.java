/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKClases;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matias
 */
public class TablaVenta {
    DefaultTableModel modelo;
    Connection con = ConexionBD.getConexion();
    




public void agregarRegistro(JTable jTableVenta,String codigo,String nombre,String precio,String cant){
        modelo = (DefaultTableModel) jTableVenta.getModel() ;
        modelo.addRow(new Object[]{codigo,nombre,precio,cant});
}



public void modificarCantidad(int cantidad, String codigo ){ 

    if(cantidad > 0){
                try{

                    String sql = "UPDATE productos SET cantidad = cantidad - "+cantidad+" WHERE id_producto ="+codigo+" ";

                    PreparedStatement sent = con.prepareStatement(sql);

                    sent.executeUpdate();

                    con.close();

                }catch(Exception e){

                    JOptionPane.showMessageDialog(null, e, "error en BD",JOptionPane.ERROR_MESSAGE);


                }}else{
        
        
        }}


public void quitarRegistro(JTable jTableVenta,int filaSelec){
    filaSelec =jTableVenta.getSelectedRow();
    modelo.removeRow(filaSelec);

}


public Double SubTotal(JTable jTableVenta){
    
    Double total = new Double(0.0);
    double fila = 0;
    
    
    if (jTableVenta.getColumnCount()>0){
        for (int i = 0;i< jTableVenta.getRowCount();i++){
            
            fila = Double.parseDouble(jTableVenta.getValueAt(i,2).toString());
            total+= fila;
        
     }
        
    } return total;
    



}}



    


        


