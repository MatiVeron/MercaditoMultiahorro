/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKInterface;

import BD.ConexionBD;
import static BD.ConexionBD.con;
import PKClases.AutoCompletar;
import PKClases.TablaBalanceVentas;
import com.mxrck.autocompleter.TextAutoCompleter;
import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matias
 */
public class BalanceVentas extends javax.swing.JFrame {
    Connection con = ConexionBD.getConexion();
    ResultSet rs;
    AutoCompletar autoc = new AutoCompletar();
    DefaultTableModel modelo;

    
    public BalanceVentas() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.desHabilitarComponentes();
        this.AutoCompletar();
   
        
        
        
       
    }
    
    public void mostrarFormulario(){
     this.setVisible(true);
        
    }
    
    
    
    
     public void AutoCompletar() {
        
       
        TextAutoCompleter textAutoCComprobante = new TextAutoCompleter(jTextFieldComprobante);
        
        
        try {
            String sql = "SELECT * FROM venta";
            Statement sent = con.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            
           
            while (rs.next()) {
              
                
                textAutoCComprobante.addItem(rs.getString("numero_venta"));
                
                
                
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    
    private void desHabilitarComponentes(){
        jDateChooserDesde.setEnabled(false);
        jDateChooserHasta.setEnabled(false);
        
        jTextFieldComprobante.setEnabled(false);
    
    
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filtro = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldComprobante = new javax.swing.JTextField();
        jDateChooserDesde = new com.toedter.calendar.JDateChooser();
        jDateChooserHasta = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBalanceVentas = new javax.swing.JTable();
        jTextFieldCantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        filtro.add(jRadioButton2);
        jRadioButton2.setText("Por fechas:");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        filtro.add(jRadioButton1);
        jRadioButton1.setText("Por registro:");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("N° de comprobante:");

        jTextFieldComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldComprobanteActionPerformed(evt);
            }
        });
        jTextFieldComprobante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldComprobanteKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Desde:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Hasta:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jDateChooserDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooserHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel5)
                                .addGap(93, 93, 93)
                                .addComponent(jLabel6)))))
                .addGap(52, 52, 52)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jRadioButton2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooserDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTableBalanceVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo ", "Fecha", "Comprobante", "Total"
            }
        ));
        jTableBalanceVentas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTableBalanceVentas);
        if (jTableBalanceVentas.getColumnModel().getColumnCount() > 0) {
            jTableBalanceVentas.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTableBalanceVentas.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTableBalanceVentas.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        jLabel7.setText("Ventas registradas:");

        jLabel4.setText("Ganancias ventas:");

        jTextFieldTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextFieldTotal.setForeground(new java.awt.Color(0, 255, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4)
                        .addGap(11, 11, 11)
                        .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(224, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta de ventas", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    double total = 0.0;
    
    
    if( jRadioButton2.isSelected()){
        Date desde = new Date();
        SimpleDateFormat sdfDesde = new SimpleDateFormat("dd-MM-yyyy");

        desde = jDateChooserDesde.getDate();
        String fechaDesde = sdfDesde.format(desde);

        Date hasta = new Date();
        SimpleDateFormat sdfHasta = new SimpleDateFormat("dd-MM-yyyy");
        
        hasta = jDateChooserHasta.getDate();
        String fechaHasta = sdfHasta.format(hasta);
        
        
        if(desde.before(hasta) ){
            
    
    
   
        TablaBalanceVentas tablaBalance = new TablaBalanceVentas();
        tablaBalance.FiltrarTabla(jTableBalanceVentas, fechaDesde, fechaHasta);

        modelo =(DefaultTableModel) jTableBalanceVentas.getModel();
    
    
     for(int i=0;i<jTableBalanceVentas.getRowCount();i++){
        String filTot = jTableBalanceVentas.getValueAt(i,3).toString();
        
        total = total + Double.parseDouble(filTot);
        jTextFieldTotal.setText(""+total);
        
        int cantidad = jTableBalanceVentas.getRowCount();
        
        jTextFieldCantidad.setText(""+cantidad);}}
        
       
        
     }else{
        
        
        String comprobante = jTextFieldComprobante.getText();
        
        if(!comprobante.isEmpty()){
          try{ 
                String[] fila = new String [4];
                String[] titulos = {"Codigo","Fecha","Comprobante","Total"};
                modelo = new DefaultTableModel(null,titulos);
                
               
           
               
               Connection con = ConexionBD.getConexion();
               String sql= "select * from venta where numero_venta= "+comprobante;
               
               Statement sent  = con.createStatement();
               
                rs = sent.executeQuery(sql);
               
               while(rs.next()){
                   fila[0] = rs.getString("id_venta");
                   fila[1] = rs.getString("fecha");
                   fila[2] = rs.getString("numero_venta");
                   fila[3] = rs.getString("total");
               
                   
                   modelo.addRow(fila);
               
               
               jTableBalanceVentas.setModel(modelo);
               }
               
               
               
            modelo =(DefaultTableModel) jTableBalanceVentas.getModel();


            for(int i=0;i<jTableBalanceVentas.getRowCount();i++){
            String filTot = jTableBalanceVentas.getValueAt(i,3).toString();

            total = total + Double.parseDouble(filTot);
            jTextFieldTotal.setText(""+total);

            int cantidad = jTableBalanceVentas.getRowCount();

            jTextFieldCantidad.setText(""+cantidad);
     
     
     }
                 }catch(Exception e){}
          
         
           
       }else{
           JOptionPane.showMessageDialog(null, "Ingrese un numero de comprobante!!");
       
       }}
        
       
        
        
    

    
    
    
    
    
    

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldComprobanteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldComprobanteKeyTyped
       
    
        
       try{
        ResultSet rs = autoc.findCodigoComprobante(jTextFieldComprobante.getText());
            
              if(rs.next()){
                  jTextFieldComprobante.setText(rs.getString("numero_venta"));}
                  
                 
                  
                 
                  
              }catch(Exception ex){
                   JOptionPane.showMessageDialog(null, ex.getMessage());}
       
       
     
       
    }//GEN-LAST:event_jTextFieldComprobanteKeyTyped

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
            jDateChooserDesde.setEnabled(false);
            jDateChooserHasta.setEnabled(false);
            
            jTextFieldComprobante.setEnabled(true);    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
            jDateChooserDesde.setEnabled(true);
            jDateChooserHasta.setEnabled(true);
          
            jTextFieldComprobante.setEnabled(false);

    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTextFieldComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldComprobanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldComprobanteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BalanceVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BalanceVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BalanceVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BalanceVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BalanceVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup filtro;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooserDesde;
    private com.toedter.calendar.JDateChooser jDateChooserHasta;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableBalanceVentas;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldComprobante;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables
}
