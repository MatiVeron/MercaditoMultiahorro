
package PKInterface;

import PKClases.Categoria;
import PKClases.Producto;
import PKClases.TablaProductos;


public class RegistrarProductos extends javax.swing.JFrame {
    
    
    
    public RegistrarProductos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.DeshabilitarTexto();
        TablaProductos tablaProductos = new TablaProductos();
        tablaProductos.LlenarTabla(jTableProductos);
        Categoria categoria = new Categoria();
        categoria.mostrarCategoria(jComboBoxCategoria);/*muestra la categoria desde un combo box, cada categoria es un objeto de la calse categoria*/
        
    }

    

    private void DeshabilitarTexto(){
        jTextFieldNombreDelProducto.setEditable(false);
        jTextFieldCodigo.setEditable(false);
        jTextFieldCantidad.setEditable(false);
        jTextFieldPrecio1.setEditable(false);
        jComboBoxCategoria.setEditable(false);
        
    }
    
    private void LimpiarTexto(){
        jTextFieldNombreDelProducto.setText("");
        jTextFieldCodigo.setText("");
        jTextFieldCantidad.setText("");
        jTextFieldPrecio1.setText("");
        
    }
    
    private void HabilitarTexto(){
        jTextFieldNombreDelProducto.setEditable(true);
        jTextFieldNombreDelProducto.setEnabled(true);
        jTextFieldCodigo.setEditable(true);
        jTextFieldCantidad.setEditable(true);
        jTextFieldPrecio1.setEditable(true);
        jTextFieldCodigo.requestFocus();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jButtonGuardar = new javax.swing.JButton();
        jToggleButtonSalir = new javax.swing.JButton();
        jTextFieldBusqueda = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButtonNuevo = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        try {
            jButtonBusqueda =(javax.swing.JButton)java.beans.Beans.instantiate(getClass().getClassLoader(), "PKInterface.RegistrarProductos_jButton1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNombreDelProducto = new javax.swing.JTextField();
        jTextFieldCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        try {
            jComboBoxCategoria =(javax.swing.JComboBox)java.beans.Beans.instantiate(getClass().getClassLoader(), "PKInterface.RegistrarProductos_jComboBoxCategoria");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        jTextFieldPrecio1 = new javax.swing.JTextField();
        jComboBoxFiltro = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("STOCK DE PRODUCTOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Productos Ingresados");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo", "nombre", "categoria", "precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProductos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 700, 232));

        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 110, -1));

        jToggleButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jToggleButtonSalir.setText("Salir");
        jToggleButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 97, -1));

        jTextFieldBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBusquedaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 270, 20));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jButtonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus (1).png"))); // NOI18N
        jButtonNuevo.setText("Nuevo producto");
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonNuevo);
        jButtonNuevo.setBounds(10, 7, 129, 30);

        jButtonBorrar.setText("Borrar producto");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonBorrar);
        jButtonBorrar.setBounds(10, 50, 130, 30);

        jButtonModificar.setText("Modificar producto");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonModificar);
        jButtonModificar.setBounds(10, 90, 130, 30);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 150, 140));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 270, 50));

        jButtonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBusquedaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bannerProd.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 30));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Precio:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 80, 38, 14);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Codigo:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 20, 41, 14);
        jPanel1.add(jTextFieldCodigo);
        jTextFieldCodigo.setBounds(60, 20, 100, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 50, 47, 20);

        jTextFieldNombreDelProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreDelProductoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNombreDelProducto);
        jTextFieldNombreDelProducto.setBounds(60, 50, 450, 20);

        jTextFieldCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldCantidad);
        jTextFieldCantidad.setBounds(60, 110, 100, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Categoría:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(290, 80, 58, 14);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Cantidad:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(0, 110, 60, 20);

        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxCategoria);
        jComboBoxCategoria.setBounds(360, 80, 150, 20);

        jTextFieldPrecio1.setEditable(false);
        jTextFieldPrecio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecio1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldPrecio1);
        jTextFieldPrecio1.setBounds(60, 80, 100, 20);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 540, 140));

        jComboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "codigo", "nombre" }));
        jComboBoxFiltro.setToolTipText("");
        jComboBoxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFiltroActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        jLabel4.setText("Buscar por:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed

        String cod = jTextFieldCodigo.getText();
        String nombre =  jTextFieldNombreDelProducto.getText();
        String precio =  jTextFieldPrecio1.getText();
        String cantidad = jTextFieldCantidad.getText();
        Categoria categoria =(Categoria) jComboBoxCategoria.getSelectedItem();
        String id = categoria.getCategoria();
            
        Producto p = new Producto();
        p.agregarProducto(cod, nombre, precio, cantidad, id);

        this.LimpiarTexto();

        TablaProductos tablaProductos = new TablaProductos();
        tablaProductos.LlenarTabla(jTableProductos);
            
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jToggleButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jToggleButtonSalirActionPerformed

    private void jTextFieldCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantidadActionPerformed
        
    }//GEN-LAST:event_jTextFieldCantidadActionPerformed

    private void jTextFieldNombreDelProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreDelProductoActionPerformed
        
    }//GEN-LAST:event_jTextFieldNombreDelProductoActionPerformed

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void jTextFieldBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBusquedaActionPerformed
       
       
    }//GEN-LAST:event_jTextFieldBusquedaActionPerformed

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        this.LimpiarTexto();
        this.HabilitarTexto();
    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        
        String codigo = jTextFieldCodigo.getText();
        String nombre = jTextFieldNombreDelProducto.getText();
        String precio = jTextFieldPrecio1.getText();
        String cantidad = jTextFieldCantidad.getText();
        Categoria categoria = (Categoria) jComboBoxCategoria.getSelectedItem();
        String id = categoria.getCategoria().toString();
        
        Producto p = new Producto();
        p.modificarProducto(nombre, precio, cantidad, id, codigo);
        
        
        TablaProductos tablaProductos = new TablaProductos();
        tablaProductos.LlenarTabla(jTableProductos);
        
        this.LimpiarTexto();
        this.DeshabilitarTexto();
        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jTextFieldPrecio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecio1ActionPerformed
        
    }//GEN-LAST:event_jTextFieldPrecio1ActionPerformed

    private void jButtonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBusquedaActionPerformed
        String busqueda = jTextFieldBusqueda.getText();
        String filtro = jComboBoxFiltro.getSelectedItem().toString();
        
        Producto p = new Producto();
        p.buscarProducto(busqueda, filtro, jTableProductos);
        
       
    }//GEN-LAST:event_jButtonBusquedaActionPerformed

    private void jComboBoxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFiltroActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        Producto p = new Producto ();
        String codigo = jTextFieldCodigo.getText();
        p.eliminarProducto(codigo);
        
        this.LimpiarTexto();
        this.DeshabilitarTexto();
        
        TablaProductos tablaProductos = new TablaProductos();
        tablaProductos.LlenarTabla(jTableProductos);
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked
        if(evt.getClickCount()== 2){
            
            int fila = jTableProductos.getSelectedRow();
            
            this.HabilitarTexto();
            jTextFieldCodigo.setEditable(false);
            
            jTextFieldCodigo.setText(jTableProductos.getValueAt(fila, 0).toString());
            jTextFieldNombreDelProducto.setText(jTableProductos.getValueAt(fila, 1).toString());
            jTextFieldPrecio1.setText(jTableProductos.getValueAt(fila, 2).toString());
            jTextFieldCantidad.setText(jTableProductos.getValueAt(fila, 3).toString());
            
            
            Categoria categoria = (Categoria) jComboBoxCategoria.getSelectedItem();
            String id = categoria.getCategoria().toString();
            
            
        
            jComboBoxCategoria.setSelectedItem(jTableProductos.getValueAt(fila, 4));
        }   /*El combo box no funciona porque este valor no esta mostrado en tabla y no se obtiene de la misma con jTable...*/

            
            
        
    }//GEN-LAST:event_jTableProductosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonBusqueda;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JComboBox<Categoria> jComboBoxCategoria;
    private javax.swing.JComboBox<String> jComboBoxFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTextFieldBusqueda;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNombreDelProducto;
    private javax.swing.JTextField jTextFieldPrecio1;
    private javax.swing.JButton jToggleButtonSalir;
    // End of variables declaration//GEN-END:variables

}
