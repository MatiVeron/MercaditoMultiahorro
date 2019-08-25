
package PKInterface;

import BD.ConexionBD;
import PKClases.Categoria;
import PKClases.Fecha;
import PKClases.Marca;
import PKClases.Producto;
import PKClases.Sql;
import PKClases.TablaCategorias;
import PKClases.TablaMarcas;
import PKClases.TablaProductos;
import PKClases.TablaFamilia;
import PKClases.Familia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class RegistrarProductos extends javax.swing.JFrame {
    Fecha fecha = new Fecha();
    
    
    public RegistrarProductos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.disabledTexto();
        this.DeshabilitarTexto();
        
       
        
        TablaProductos tablaProductos = new TablaProductos();
        tablaProductos.LlenarTabla(jTableProductos);
        
        DefaultTableModel modelo = (DefaultTableModel) jTableProductos.getModel();
        int contador = modelo.getRowCount();
        jTextFieldConteo.setText(" "+ contador);
        
        TablaMarcas tablaMarcas = new TablaMarcas();
        tablaMarcas.LlenarTabla(jTableMarca);
        
        TablaFamilia tablaFamilia = new TablaFamilia();
        tablaFamilia.LlenarTabla(jTableFamilia);
        
        TablaCategorias tablaCategoria = new TablaCategorias();
        tablaCategoria.LlenarTabla(jTableCategoria);
        
        Categoria categoria = new Categoria();
        categoria.mostrarCategoria(jComboBoxCategoria);/*muestra la categoria desde un combo box, cada categoria es un objeto de la calse categoria*/
        
        Marca marca = new Marca();
        marca.mostrarMarca(jComboBoxMarca);
        
        Familia familia = new Familia();
        familia.mostrarFamilia(jComboBoxFamilia);
        
        jLabelFecha.setText(fecha.fechaActual());
    }

    public void mostrarFormulario(){
        this.setVisible(true);
    }
    
    
    private void disabledTexto(){
        jTextFieldNombreDelProducto.setEnabled(false);
        jTextFieldCodigo.setEnabled(false);
        jTextFieldCantidad.setEnabled(false);
        jTextFieldPrecio1.setEnabled(false);
        jComboBoxCategoria.setEnabled(false);
        jComboBoxMarca.setEnabled(false);
        jComboBoxFamilia.setEnabled(false);
        jTextFieldCodigoBarras.setEnabled(false);
    }
    private void enabledTexto(){
        jTextFieldNombreDelProducto.setEnabled(true);
        jTextFieldCodigo.setEnabled(true);
        jTextFieldCantidad.setEnabled(true);
        jTextFieldPrecio1.setEnabled(true);
        jComboBoxCategoria.setEnabled(true);
        jComboBoxMarca.setEnabled(true);
        jComboBoxFamilia.setEnabled(true);
        jTextFieldCodigoBarras.setEnabled(true);
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
        jTextFieldCodigoBarras.setText("");
        
    }
    
    private void HabilitarTexto(){
        jTextFieldNombreDelProducto.setEditable(true);
        jTextFieldNombreDelProducto.setEnabled(true);
        jTextFieldCodigo.setEditable(true);
        jTextFieldCantidad.setEditable(true);
        jTextFieldPrecio1.setEditable(true);
        jTextFieldCodigo.setEditable(false);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogMarcas = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldNombreMarca = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMarca = new javax.swing.JTable();
        jButtonGuardarMarca = new javax.swing.JButton();
        jTextFieldBuscadorMarcas = new javax.swing.JTextField();
        jDialogCategorias = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jTextFieldNombreCategoria = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCategoria = new javax.swing.JTable();
        jTextFieldBuscadorCategorias = new javax.swing.JTextField();
        jButtonGuardarCategoria = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDialogFamilia = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jTextFieldNombreUnidad = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableFamilia = new javax.swing.JTable();
        jButtonGuardarUnidad = new javax.swing.JButton();
        jTextFieldBuscadorUnidades = new javax.swing.JTextField();
        jDialogProducto = new javax.swing.JDialog();
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
        jLabel10 = new javax.swing.JLabel();
        jComboBoxMarca = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxFamilia = new javax.swing.JComboBox<>();
        jButtonAñadirCategoria = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldCodigoBarras = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabelFecha = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonModificar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelStock = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        jPanel8 = new javax.swing.JPanel();
        jButtonNuevo = new javax.swing.JButton();
        jTextFieldConteo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jToggleButtonSalir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldBusqueda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxFiltro = new javax.swing.JComboBox<>();
        try {
            jButtonBusqueda =(javax.swing.JButton)java.beans.Beans.instantiate(getClass().getClassLoader(), "PKInterface.RegistrarProductos_jButton1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        jLabel17 = new javax.swing.JLabel();

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de marcas"));

        jTextFieldNombreMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreMarcaActionPerformed(evt);
            }
        });

        jLabel13.setText("Nombre:");

        jTableMarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nombre"
            }
        ));
        jScrollPane2.setViewportView(jTableMarca);

        jButtonGuardarMarca.setText("Guardar");
        jButtonGuardarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarMarcaActionPerformed(evt);
            }
        });

        jTextFieldBuscadorMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscadorMarcasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldBuscadorMarcas, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jTextFieldNombreMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonGuardarMarca)))
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGuardarMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBuscadorMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogMarcasLayout = new javax.swing.GroupLayout(jDialogMarcas.getContentPane());
        jDialogMarcas.getContentPane().setLayout(jDialogMarcasLayout);
        jDialogMarcasLayout.setHorizontalGroup(
            jDialogMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogMarcasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogMarcasLayout.setVerticalGroup(
            jDialogMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogMarcasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de categorias"));

        jTextFieldNombreCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreCategoriaActionPerformed(evt);
            }
        });

        jLabel15.setText("Nombre");

        jTableCategoria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTableCategoria);

        jTextFieldBuscadorCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscadorCategoriasActionPerformed(evt);
            }
        });

        jButtonGuardarCategoria.setText("Guardar");
        jButtonGuardarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextFieldNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGuardarCategoria))
                    .addComponent(jTextFieldBuscadorCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGuardarCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBuscadorCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialogCategoriasLayout = new javax.swing.GroupLayout(jDialogCategorias.getContentPane());
        jDialogCategorias.getContentPane().setLayout(jDialogCategoriasLayout);
        jDialogCategoriasLayout.setHorizontalGroup(
            jDialogCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCategoriasLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jDialogCategoriasLayout.setVerticalGroup(
            jDialogCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCategoriasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel14.setText("jLabel14");

        jButton1.setText("jButton1");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de familias"));

        jTextFieldNombreUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreUnidadActionPerformed(evt);
            }
        });

        jLabel16.setText("Nombre:");

        jTableFamilia.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTableFamilia);

        jButtonGuardarUnidad.setText("Guardar");
        jButtonGuardarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarUnidadActionPerformed(evt);
            }
        });

        jTextFieldBuscadorUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscadorUnidadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldBuscadorUnidades, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jTextFieldNombreUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonGuardarUnidad)))
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGuardarUnidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBuscadorUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogFamiliaLayout = new javax.swing.GroupLayout(jDialogFamilia.getContentPane());
        jDialogFamilia.getContentPane().setLayout(jDialogFamiliaLayout);
        jDialogFamiliaLayout.setHorizontalGroup(
            jDialogFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogFamiliaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogFamiliaLayout.setVerticalGroup(
            jDialogFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogFamiliaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("PRECIO UNI.:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 80, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("CODIGO INTERNO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jTextFieldCodigo.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldCodigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextFieldCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCodigo.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 100, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("DESCRIPCION:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 87, 20));

        jTextFieldNombreDelProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jTextFieldNombreDelProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreDelProductoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNombreDelProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 350, 30));

        jTextFieldCantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jTextFieldCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 74, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Categoria:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("CANTIDAD/STOCK:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, -1, 20));

        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 130, 30));

        jTextFieldPrecio1.setEditable(false);
        jTextFieldPrecio1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jTextFieldPrecio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecio1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 70, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Familia:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jComboBoxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMarcaActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 130, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Marca:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, -1, -1));

        jComboBoxFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFamiliaActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxFamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 94, 30));

        jButtonAñadirCategoria.setText("añadir");
        jButtonAñadirCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAñadirCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, 30));

        jButton2.setText("añadir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, -1, -1));

        jButton3.setText("añadir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("CODIGO DE BARRAS:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        jTextFieldCodigoBarras.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jTextFieldCodigoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoBarrasActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldCodigoBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 270, 30));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        jLabelFecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelFecha.setText("jLabel12");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Fecha:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFecha)
                .addGap(18, 18, 18))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelFecha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, -1, 30));

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonModificar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Editar.png"))); // NOI18N
        jButtonModificar.setText("Guardar cambios");
        jButtonModificar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonGuardar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonBorrar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonBorrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Borrar (2).png"))); // NOI18N
        jButtonBorrar.setText("Borrar");
        jButtonBorrar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 380, 60));

        javax.swing.GroupLayout jDialogProductoLayout = new javax.swing.GroupLayout(jDialogProducto.getContentPane());
        jDialogProducto.getContentPane().setLayout(jDialogProductoLayout);
        jDialogProductoLayout.setHorizontalGroup(
            jDialogProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogProductoLayout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(866, 866, 866))
            .addGroup(jDialogProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDialogProductoLayout.setVerticalGroup(
            jDialogProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelStock.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanelStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTableProductos.setBackground(new java.awt.Color(204, 204, 204));
        jTableProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableProductos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTableProductos.setForeground(new java.awt.Color(0, 0, 0));
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
        jTableProductos.setGridColor(new java.awt.Color(51, 102, 255));
        jTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProductos);

        jPanel8.setBackground(java.awt.SystemColor.activeCaption);
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonNuevo.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNuevo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus (1).png"))); // NOI18N
        jButtonNuevo.setText("Nuevo ");
        jButtonNuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });

        jTextFieldConteo.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldConteo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextFieldConteo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldConteoActionPerformed(evt);
            }
        });

        jLabel6.setText("Total de productos en stock:");

        jToggleButtonSalir.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jToggleButtonSalir.setText("Salir");
        jToggleButtonSalir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToggleButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jButtonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldConteo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldConteo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(jButtonNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButtonSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Opciones de busqueda"));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Buscar:");

        jTextFieldBusqueda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextFieldBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBusquedaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Filtrar por:");

        jComboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Categorias", "Marcas", "Familia" }));
        jComboBoxFiltro.setToolTipText("");
        jComboBoxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFiltroActionPerformed(evt);
            }
        });

        jButtonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonBusqueda)
                .addGap(83, 83, 83))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBusqueda, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelStockLayout = new javax.swing.GroupLayout(jPanelStock);
        jPanelStock.setLayout(jPanelStockLayout);
        jPanelStockLayout.setHorizontalGroup(
            jPanelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStockLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelStockLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(jLabel17))
                    .addGroup(jPanelStockLayout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanelStockLayout.setVerticalGroup(
            jPanelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStockLayout.createSequentialGroup()
                .addGroup(jPanelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelStockLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelStockLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Stock de productos", jPanelStock);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 510));

        setBounds(0, 0, 982, 549);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void jButtonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBusquedaActionPerformed
        String busqueda = jTextFieldBusqueda.getText();
        String filtro = jComboBoxFiltro.getSelectedItem().toString();
        
        Producto p = new Producto();
        p.buscarProducto(busqueda, filtro, jTableProductos);
        
       
    }//GEN-LAST:event_jButtonBusquedaActionPerformed

    private void jTextFieldNombreMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreMarcaActionPerformed

    private void jTextFieldBuscadorMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscadorMarcasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscadorMarcasActionPerformed

    private void jTextFieldNombreCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreCategoriaActionPerformed

    private void jTextFieldBuscadorCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscadorCategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscadorCategoriasActionPerformed

    private void jButtonGuardarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarMarcaActionPerformed
     Marca marca = new Marca();
     Sql sql = new Sql();
    
     int id = sql.id_autoincrementalMarca();
     String nombre =  jTextFieldNombreMarca.getText();
     
     
     
     
     marca.agregarMarca(id, nombre);
     TablaMarcas tablaMarcas = new TablaMarcas();
     tablaMarcas.LlenarTabla(jTableMarca);
     jComboBoxMarca.removeAllItems();
     marca.mostrarMarca(jComboBoxMarca);
     
     jTextFieldNombreMarca.setText(" ");
     
     
    }//GEN-LAST:event_jButtonGuardarMarcaActionPerformed

    private void jButtonGuardarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarCategoriaActionPerformed
     Categoria categoria = new Categoria();
     Sql sql = new Sql();
    
     int id = sql.id_autoincrementalCategoria();
     String nombre =  jTextFieldNombreCategoria.getText();
     
     
     
     
     categoria.agregarCategoria(id, nombre);
     TablaCategorias tablaCategoria = new TablaCategorias();
     tablaCategoria.LlenarTabla(jTableCategoria);
     
     jComboBoxCategoria.removeAllItems();
     categoria.mostrarCategoria(jComboBoxCategoria);
     
    jTextFieldNombreCategoria.setText(" ");
    }//GEN-LAST:event_jButtonGuardarCategoriaActionPerformed

    private void jTextFieldNombreUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreUnidadActionPerformed

    private void jButtonGuardarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarUnidadActionPerformed
     Familia familia = new Familia();
     Sql sql = new Sql();
    
     int id = sql.id_autoincrementalFamilia();
     String nombre =  jTextFieldNombreUnidad.getText();
     
     
     
     
     familia.agregarFamilia(id, nombre);
     TablaFamilia tablaUnidad = new TablaFamilia();
     tablaUnidad.LlenarTabla(jTableFamilia);
     jComboBoxFamilia.removeAllItems();
     familia.mostrarFamilia(jComboBoxFamilia);
     
     jTextFieldNombreUnidad.setText(" ");
    }//GEN-LAST:event_jButtonGuardarUnidadActionPerformed

    private void jTextFieldBuscadorUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscadorUnidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscadorUnidadesActionPerformed

    private void jToggleButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jToggleButtonSalirActionPerformed

    private void jTextFieldCodigoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoBarrasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jDialogFamilia.setVisible(true);
        jDialogFamilia.setSize(400, 350);
        jDialogFamilia.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jDialogMarcas.setVisible(true);
        jDialogMarcas.setSize(400, 350);
        jDialogMarcas.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonAñadirCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirCategoriaActionPerformed
        jDialogCategorias.setVisible(true);
        jDialogCategorias.setSize(400,350);
        jDialogCategorias.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonAñadirCategoriaActionPerformed

    private void jComboBoxFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFamiliaActionPerformed

    }//GEN-LAST:event_jComboBoxFamiliaActionPerformed

    private void jComboBoxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMarcaActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed

        String codigo = jTextFieldCodigo.getText();
        String codigoBarras = jTextFieldCodigoBarras.getText();
        String nombre = jTextFieldNombreDelProducto.getText();
        String precio = jTextFieldPrecio1.getText();
        String cantidad = jTextFieldCantidad.getText();

        Categoria categoria = (Categoria) jComboBoxCategoria.getSelectedItem();
        String id = categoria.getCategoria().toString();

        Marca marca =(Marca) jComboBoxMarca.getSelectedItem();
        String idMarca = marca.getMarca().toString();

        Familia familia =(Familia) jComboBoxFamilia.getSelectedItem();
        String idFamilia = familia.getFamilia().toString();

        Producto p = new Producto();
        p.modificarProducto(nombre, precio, cantidad, id, codigo, idMarca, idFamilia, codigoBarras);

        TablaProductos tablaProductos = new TablaProductos();
        tablaProductos.LlenarTabla(jTableProductos);

        this.disabledTexto();
        this.LimpiarTexto();
        this.DeshabilitarTexto();
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        Producto p = new Producto ();
        String codigo = jTextFieldCodigo.getText();
        p.eliminarProducto(codigo);

        this.LimpiarTexto();
        this.DeshabilitarTexto();

        TablaProductos tablaProductos = new TablaProductos();
        tablaProductos.LlenarTabla(jTableProductos);
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        String cod = jTextFieldCodigo.getText();

        String nombre =  jTextFieldNombreDelProducto.getText();
        String precio =  jTextFieldPrecio1.getText();
        String cantidad = jTextFieldCantidad.getText();
        String codigoBarras = jTextFieldCodigoBarras.getText();
        Categoria categoria =(Categoria) jComboBoxCategoria.getSelectedItem();
        String id = categoria.getCategoria();

        Marca marca =(Marca) jComboBoxMarca.getSelectedItem();
        String idMarca = marca.getMarca();

        Familia familia =(Familia) jComboBoxFamilia.getSelectedItem();
        String idFamilia = familia.getFamilia();

        
        Producto p = new Producto();
        p.agregarProducto(cod, nombre, precio, cantidad, id, idMarca, idFamilia, codigoBarras);
        this.LimpiarTexto();
                    
                
 
      
        
        
        TablaProductos tablaProductos = new TablaProductos();
        tablaProductos.LlenarTabla(jTableProductos);

    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jTextFieldPrecio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecio1ActionPerformed

    }//GEN-LAST:event_jTextFieldPrecio1ActionPerformed

    private void jTextFieldCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantidadActionPerformed

    }//GEN-LAST:event_jTextFieldCantidadActionPerformed

    private void jTextFieldNombreDelProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreDelProductoActionPerformed

    }//GEN-LAST:event_jTextFieldNombreDelProductoActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        jButtonGuardar.setVisible(true);
        jButtonModificar.setVisible(false);
        jButtonBorrar.setVisible(false);
        jDialogProducto.setVisible(true);
        jDialogProducto.setSize(879, 355);
        jDialogProducto.setLocationRelativeTo(null);
        this.enabledTexto();
        this.LimpiarTexto();
        this.HabilitarTexto();
        Sql s = new Sql();
        jTextFieldPrecio1.requestFocus();
        jTextFieldCodigo.setText(""+s.id_autoincrementalProducto());

    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jComboBoxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFiltroActionPerformed
        jTextFieldBusqueda.requestFocus();
    }//GEN-LAST:event_jComboBoxFiltroActionPerformed

    private void jTextFieldBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBusquedaActionPerformed

    }//GEN-LAST:event_jTextFieldBusquedaActionPerformed

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked

        if(evt.getClickCount()== 2){
            jButtonModificar.setVisible(true);
            jButtonGuardar.setVisible(false);
            jDialogProducto.setVisible(true);
            jDialogProducto.setSize(879, 355);
            jDialogProducto.setLocationRelativeTo(null);
            
            try{

                int fila = jTableProductos.getSelectedRow();
                this.enabledTexto();
                this.HabilitarTexto();
                jTextFieldCodigo.setEditable(false);
                jTextFieldCodigo.setEnabled(false);

                jTextFieldCodigo.setText(jTableProductos.getValueAt(fila, 0).toString());
                jTextFieldNombreDelProducto.setText(jTableProductos.getValueAt(fila, 1).toString());
                jTextFieldPrecio1.setText(jTableProductos.getValueAt(fila, 4).toString());
                jTextFieldCantidad.setText(jTableProductos.getValueAt(fila, 5).toString());

               
                jComboBoxCategoria.setModel((ComboBoxModel<Categoria>) jTableProductos.getValueAt(fila, 6));
                String codigo = jTableProductos.getValueAt(fila, 0).toString();

                Connection con = ConexionBD.getConexion();

                String sql = "select productos.codigo_barras,categorias.nombre_categoria,marcas.nombre_marca,familias.nombre_familia \n" +
                "from productos\n" +
                "inner join categorias  on productos.id_categoria = categorias.id_categoria\n" +
                "inner join marcas  on  productos.id_marca = marcas.id_marca \n" +
                "inner join familias  on productos.id_familia = familias.id_familia "
                +"where productos.id_producto ="+ codigo;

                PreparedStatement ps = con.prepareStatement(sql);
                String [] categoria = new String[2];
                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    jTextFieldCodigoBarras.setText( rs.getString("productos.codigo_barras"));
                    categoria[1] = rs.getString("categorias.nombre_categoria");
                    categoria[2] = rs.getString("categorias.id_categoria");
                    jComboBoxFamilia.getModel().setSelectedItem(rs.getObject(("familias.nombre_familia")));
                    jComboBoxMarca.getModel().setSelectedItem(rs.getObject(("marcas.nombre_marca")));
                    jComboBoxFamilia.getModel().setSelectedItem(rs.getObject(("familias.nombre_familia")));
                }
                
               
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);}

        }

    }//GEN-LAST:event_jTableProductosMouseClicked

    private void jTextFieldConteoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldConteoActionPerformed
    
        DefaultTableModel modelo = (DefaultTableModel) jTableProductos.getModel();
        int contador = modelo.getColumnCount();
        jTextFieldConteo.setText(""+contador);
         
         
    }//GEN-LAST:event_jTextFieldConteoActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAñadirCategoria;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonBusqueda;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonGuardarCategoria;
    private javax.swing.JButton jButtonGuardarMarca;
    private javax.swing.JButton jButtonGuardarUnidad;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JComboBox<Categoria> jComboBoxCategoria;
    private javax.swing.JComboBox<PKClases.Familia> jComboBoxFamilia;
    private javax.swing.JComboBox<String> jComboBoxFiltro;
    private javax.swing.JComboBox<Marca> jComboBoxMarca;
    private javax.swing.JDialog jDialogCategorias;
    private javax.swing.JDialog jDialogFamilia;
    private javax.swing.JDialog jDialogMarcas;
    private javax.swing.JDialog jDialogProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelStock;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTableCategoria;
    private javax.swing.JTable jTableFamilia;
    private javax.swing.JTable jTableMarca;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTextFieldBuscadorCategorias;
    private javax.swing.JTextField jTextFieldBuscadorMarcas;
    private javax.swing.JTextField jTextFieldBuscadorUnidades;
    private javax.swing.JTextField jTextFieldBusqueda;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldCodigoBarras;
    private javax.swing.JTextField jTextFieldConteo;
    private javax.swing.JTextField jTextFieldNombreCategoria;
    private javax.swing.JTextField jTextFieldNombreDelProducto;
    private javax.swing.JTextField jTextFieldNombreMarca;
    private javax.swing.JTextField jTextFieldNombreUnidad;
    private javax.swing.JTextField jTextFieldPrecio1;
    private javax.swing.JButton jToggleButtonSalir;
    // End of variables declaration//GEN-END:variables

}
