/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKInterface;

import BD.ConexionBD;
import static BD.ConexionBD.con;
import PKClases.DetalleVenta;
import PKClases.Fecha;
import PKClases.TablaEstadoDeVentas;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Matias
 */
public class EstadosDeLasVentasConDetalle extends javax.swing.JFrame {
    
    TablaEstadoDeVentas tablaEstados = new TablaEstadoDeVentas();
    Fecha fecha = new Fecha();

    
    public EstadosDeLasVentasConDetalle() {
        initComponents();
        
        tablaEstados.LlenarTabla(jTableEstadoDeVentas);
        jLabelFecha.setText(fecha.fechaActual());
        this.setResizable(false);
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogVenta = new javax.swing.JDialog();
        jTextFieldEstado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTextFieldTotalVentaEspera = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldFecha = new javax.swing.JTextField();
        jTextFieldComprobante = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableDetalleVentas2 = new javax.swing.JTable();
        filtros = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableEstadoDeVentas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jDateChooserDesde = new com.toedter.calendar.JDateChooser();
        jDateChooserHasta = new com.toedter.calendar.JDateChooser();
        jRadioButtonCerrado = new javax.swing.JRadioButton();
        jRadioButtonAnulado = new javax.swing.JRadioButton();
        jRadioButtonEnEspera = new javax.swing.JRadioButton();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonTodos = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabelFecha = new javax.swing.JLabel();

        jTextFieldEstado.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jTextFieldEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEstadoActionPerformed(evt);
            }
        });

        jLabel1.setText("ESTADO:");

        jLabel2.setText("NRO COMPROBANTE:");

        jLabel16.setText("FECHA:");

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextFieldTotalVentaEspera.setText("TOTAL");
        jTextFieldTotalVentaEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalVentaEsperaActionPerformed(evt);
            }
        });

        jLabel17.setText("TOTAL:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTotalVentaEspera, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTotalVentaEspera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(15, 15, 15))
        );

        jTextFieldFecha.setText("jTextField4");
        jTextFieldFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFechaActionPerformed(evt);
            }
        });

        jTextFieldComprobante.setText("jTextField5");

        jTableDetalleVentas2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTableDetalleVentas2);

        javax.swing.GroupLayout jDialogVentaLayout = new javax.swing.GroupLayout(jDialogVenta.getContentPane());
        jDialogVenta.getContentPane().setLayout(jDialogVentaLayout);
        jDialogVentaLayout.setHorizontalGroup(
            jDialogVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialogVentaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogVentaLayout.setVerticalGroup(
            jDialogVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldFecha)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialogVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addComponent(jTextFieldComprobante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel9.setBackground(java.awt.SystemColor.inactiveCaptionBorder);

        jTableEstadoDeVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableEstadoDeVentas.setCellSelectionEnabled(true);
        jTableEstadoDeVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEstadoDeVentasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableEstadoDeVentas);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10))); // NOI18N

        filtros.add(jRadioButtonCerrado);
        jRadioButtonCerrado.setText("CERRADO");
        jRadioButtonCerrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCerradoActionPerformed(evt);
            }
        });

        filtros.add(jRadioButtonAnulado);
        jRadioButtonAnulado.setText("ANULADO");
        jRadioButtonAnulado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAnuladoActionPerformed(evt);
            }
        });

        filtros.add(jRadioButtonEnEspera);
        jRadioButtonEnEspera.setText("EN ESPERA");
        jRadioButtonEnEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEnEsperaActionPerformed(evt);
            }
        });

        jTextField3.setText("jTextField3");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/investigacion .png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("DESDE:");

        jLabel6.setText("HASTA:");

        filtros.add(jRadioButtonTodos);
        jRadioButtonTodos.setText("TODOS");
        jRadioButtonTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTodosActionPerformed(evt);
            }
        });

        jCheckBox1.setText("NRO COMPROBANTE:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooserDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jDateChooserHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButtonCerrado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonEnEspera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonAnulado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButtonCerrado)
                                .addComponent(jRadioButtonAnulado)
                                .addComponent(jRadioButtonEnEspera)
                                .addComponent(jRadioButtonTodos)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDateChooserDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDateChooserHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox1)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10))); // NOI18N

        jLabelFecha.setText("jLabel4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFecha)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelFecha)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Estado de las ventas", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableEstadoDeVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEstadoDeVentasMouseClicked
        if(evt.getClickCount()== 2){
            jDialogVenta.setVisible(true);
            jDialogVenta.setSize(610,425);
            

            try{
                int fila = jTableEstadoDeVentas.getSelectedRow();

                String idVenta = jTableEstadoDeVentas.getValueAt(fila,0).toString();
                
               

                jTextFieldEstado.setText(jTableEstadoDeVentas.getValueAt(fila, 4).toString());
                   
                
                jTextFieldFecha.setText(jTableEstadoDeVentas.getValueAt(fila, 1).toString());
                jTextFieldComprobante.setText(jTableEstadoDeVentas.getValueAt(fila, 2).toString());

                con = ConexionBD.getConexion();

                String sql = "SELECT venta.id_detalle,venta.total FROM venta  WHERE venta.id_venta = ?";
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1,idVenta);

                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    String idDetalle = rs.getString("venta.id_detalle");
                    jTextFieldTotalVentaEspera.setText(rs.getString("venta.total"));
                    DetalleVenta tablaDetalle2 = new DetalleVenta();
                    tablaDetalle2.consultarDetalle(idDetalle, jTableDetalleVentas2);
                }

            }catch(Exception e){}

        }
    }//GEN-LAST:event_jTableEstadoDeVentasMouseClicked

    private void jTextFieldEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEstadoActionPerformed

    private void jTextFieldFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFechaActionPerformed

    private void jTextFieldTotalVentaEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalVentaEsperaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalVentaEsperaActionPerformed

    private void jRadioButtonEnEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEnEsperaActionPerformed
        if(jRadioButtonEnEspera.isSelected()){
           String estado = "2";
        
           TablaEstadoDeVentas tablaEstadoVentas = new TablaEstadoDeVentas();
           tablaEstadoVentas.FiltrarTablaPorEstados(estado, jTableEstadoDeVentas);
        
        
        }
    }//GEN-LAST:event_jRadioButtonEnEsperaActionPerformed

    private void jRadioButtonTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTodosActionPerformed
        if(jRadioButtonTodos.isSelected()){
        
           TablaEstadoDeVentas tablaEstadoVentas = new TablaEstadoDeVentas();
           tablaEstadoVentas.LlenarTabla(jTableEstadoDeVentas);
        
        
        }
    }//GEN-LAST:event_jRadioButtonTodosActionPerformed

    private void jRadioButtonCerradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCerradoActionPerformed
       if(jRadioButtonCerrado.isSelected()){
           String estado = "1";
        
           TablaEstadoDeVentas tablaEstadoVentas = new TablaEstadoDeVentas();
           tablaEstadoVentas.FiltrarTablaPorEstados(estado, jTableEstadoDeVentas);
        
        
        }
    }//GEN-LAST:event_jRadioButtonCerradoActionPerformed

    private void jRadioButtonAnuladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAnuladoActionPerformed
       if(jRadioButtonAnulado.isSelected()){
           String estado = "3";
        
           TablaEstadoDeVentas tablaEstadoVentas = new TablaEstadoDeVentas();
           tablaEstadoVentas.FiltrarTablaPorEstados(estado, jTableEstadoDeVentas);
        
        
        }
    }//GEN-LAST:event_jRadioButtonAnuladoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Date fechaInicial =  jDateChooserDesde.getDate();
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");
        String fechaDesde = formatoFecha.format(fechaInicial);
        
        Date fechaFinal =  jDateChooserHasta.getDate();
        String fechaHasta = formatoFecha.format(fechaFinal);
        
        
        TablaEstadoDeVentas tablaEstadoVentas = new TablaEstadoDeVentas();
        tablaEstadoVentas.FiltrarTablaPorFechas(fechaDesde, fechaHasta, jTableEstadoDeVentas);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(EstadosDeLasVentasConDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstadosDeLasVentasConDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstadosDeLasVentasConDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstadosDeLasVentasConDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstadosDeLasVentasConDetalle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup filtros;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooserDesde;
    private com.toedter.calendar.JDateChooser jDateChooserHasta;
    private javax.swing.JDialog jDialogVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButtonAnulado;
    private javax.swing.JRadioButton jRadioButtonCerrado;
    private javax.swing.JRadioButton jRadioButtonEnEspera;
    private javax.swing.JRadioButton jRadioButtonTodos;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableDetalleVentas2;
    private javax.swing.JTable jTableEstadoDeVentas;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextFieldComprobante;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldTotalVentaEspera;
    // End of variables declaration//GEN-END:variables
}
