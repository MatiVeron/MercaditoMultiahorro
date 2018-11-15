
package PKInterface;

import BD.ConexionBD;
import PKClases.AutoCompletar;
import PKClases.DetalleVenta;
import PKClases.Fecha;

import PKClases.Producto;
import PKClases.Sql;
import PKClases.TablaProductos;
import PKClases.TablaVenta;
import PKClases.Venta;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matias
 */
public class RegistrarVentas extends javax.swing.JFrame {
    TablaProductos tablaProductos = new TablaProductos();
    TablaVenta tablaVenta  = new TablaVenta();
    DefaultTableModel m;
    Double subtotal;
    Double total;
    Fecha fecha = new Fecha();
    Connection con = ConexionBD.getConexion();
    ResultSet rs;
    AutoCompletar autoc = new AutoCompletar();
    
    
    
    
   
    public RegistrarVentas() {
        initComponents();
        jTextFieldCodBarras.requestFocus();
        this.setLocationRelativeTo(null);
        tablaProductos.LlenarTabla(jTableProductos);
        jDialog1.setUndecorated(false);
        subtotal = 0.0;
        total = 0.0;
        
   
       
        jLabelFecha.setText(fecha.fechaActual());
        
        Sql s =new Sql();
        jLabelNumero.setText(""+s.id_autoincrementalFactura());
        jLabelIdVenta.setText(""+s.id_autoincrementalVenta());
        jLabelIdDetalle.setText(""+s.id_autoincrementalDetalle());
        
        this.ceros();
        this.AutoCompletar();
        
}
    
    
    
    public void AutoCompletar() {
        TextAutoCompleter textAutoCNombre = new TextAutoCompleter(jTextFieldNombre);
        TextAutoCompleter textAutoCCodigo= new TextAutoCompleter(jTextFieldCodigo);
        TextAutoCompleter textAutoCCodigoBarras = new TextAutoCompleter(jTextFieldCodBarras);
        
        
        try {
            
            Statement sent = con.createStatement();
            ResultSet rs = sent.executeQuery("SELECT * FROM productos");
            
           
            while (rs.next()) {
                textAutoCNombre.addItem(rs.getString("nombre_producto"));
                textAutoCCodigo.addItem(rs.getString("id_producto"));
                textAutoCCodigoBarras.addItem(rs.getString("codigo_barras"));
                
                
                
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
 
   private void ceros(){
      
       jTextFieldTotal.setText(""+0.0);
   
   }
   
   

public void mostrarFormulario(){
     this.setVisible(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jDialog1 = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }};
            jTextFieldBusqueda = new javax.swing.JTextField();
            try {
                jButtonBusqueda =(javax.swing.JButton)java.beans.Beans.instantiate(getClass().getClassLoader(), "PKInterface.RegistrarProductos_jButton1");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            jComboBoxFiltro = new javax.swing.JComboBox<>();
            jLabel25 = new javax.swing.JLabel();
            jTextFieldCant1 = new javax.swing.JTextField();
            jLabel24 = new javax.swing.JLabel();
            jButtonAgregarProducto = new javax.swing.JButton();
            jButton4 = new javax.swing.JButton();
            jDialogFinalizar = new javax.swing.JDialog();
            jPanel4 = new javax.swing.JPanel();
            jLabel11 = new javax.swing.JLabel();
            jTextFieldAbono = new javax.swing.JTextField();
            jLabel13 = new javax.swing.JLabel();
            jTextFieldTotalAbonar = new javax.swing.JTextField();
            jLabel14 = new javax.swing.JLabel();
            jTextFieldVuelto = new javax.swing.JTextField();
            jButton1 = new javax.swing.JButton();
            jButton5 = new javax.swing.JButton();
            jLabel6 = new javax.swing.JLabel();
            jButtonSalir = new javax.swing.JButton();
            jLabel2 = new javax.swing.JLabel();
            jLabelIdVenta = new javax.swing.JLabel();
            jLabelIdDetalle = new javax.swing.JLabel();
            jPanel5 = new javax.swing.JPanel();
            jPanel6 = new javax.swing.JPanel();
            jPanel7 = new javax.swing.JPanel();
            jButton2 = new javax.swing.JButton();
            jButton3 = new javax.swing.JButton();
            jToggleButton1 = new javax.swing.JToggleButton();
            jPanel1 = new javax.swing.JPanel();
            jLabel7 = new javax.swing.JLabel();
            jLabel8 = new javax.swing.JLabel();
            jLabelFecha = new javax.swing.JLabel();
            jLabelNumero = new javax.swing.JLabel();
            jPanel8 = new javax.swing.JPanel();
            jLabel3 = new javax.swing.JLabel();
            jTextFieldCodigo = new javax.swing.JTextField();
            jLabel4 = new javax.swing.JLabel();
            jTextFieldNombre = new javax.swing.JTextField();
            jLabel9 = new javax.swing.JLabel();
            jTextFieldPrecio = new javax.swing.JTextField();
            jLabel10 = new javax.swing.JLabel();
            jTextFieldCodBarras = new javax.swing.JTextField();
            jLabel12 = new javax.swing.JLabel();
            jTextFieldCantidad = new javax.swing.JTextField();
            jPanel2 = new javax.swing.JPanel();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTableVenta = new javax.swing.JTable();
            jTextFieldTotal = new javax.swing.JTextField();
            jLabel5 = new javax.swing.JLabel();

            jTextField2.setText("jTextField2");

            jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos en stock"));

            jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "codigo", "nombre", "precio", "cantidad"
                }
            ));
            jTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTableProductosMouseClicked(evt);
                }
            });
            jScrollPane2.setViewportView(jTableProductos);

            jTextFieldBusqueda.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextFieldBusquedaActionPerformed(evt);
                }
            });

            jButtonBusqueda.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonBusquedaActionPerformed(evt);
                }
            });

            jComboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre" }));
            jComboBoxFiltro.setToolTipText("");
            jComboBoxFiltro.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jComboBoxFiltroActionPerformed(evt);
                }
            });

            jLabel25.setText("Buscar por:");

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)))
                    .addGap(12, 12, 12)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );

            jTextFieldCant1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextFieldCant1ActionPerformed(evt);
                }
            });

            jLabel24.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
            jLabel24.setText("Cant.");

            jButtonAgregarProducto.setText("agregar");
            jButtonAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonAgregarProductoActionPerformed(evt);
                }
            });

            jButton4.setText("salir");
            jButton4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton4ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
            jDialog1.getContentPane().setLayout(jDialog1Layout);
            jDialog1Layout.setHorizontalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog1Layout.createSequentialGroup()
                    .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDialog1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jDialog1Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(jLabel24)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldCant1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonAgregarProducto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton4)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jDialog1Layout.setVerticalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(jTextFieldCant1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAgregarProducto)
                        .addComponent(jButton4))
                    .addContainerGap(47, Short.MAX_VALUE))
            );

            jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Indique con cuanto de abonara:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

            jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
            jLabel11.setText("ABONA CON:");

            jTextFieldAbono.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextFieldAbonoActionPerformed(evt);
                }
            });
            jTextFieldAbono.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    jTextFieldAbonoKeyReleased(evt);
                }
            });

            jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
            jLabel13.setText("TOTAL:");

            jLabel14.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
            jLabel14.setText("VUELTO DE:");

            jButton1.setText("Finalizar");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jButton5.setText("Cancelar");
            jButton5.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton5ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(29, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton5))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14))
                            .addGap(50, 50, 50)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldAbono)
                                    .addComponent(jTextFieldTotalAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextFieldVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(42, 42, 42))
            );
            jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel13)
                        .addComponent(jTextFieldTotalAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton5))
                    .addContainerGap())
            );

            javax.swing.GroupLayout jDialogFinalizarLayout = new javax.swing.GroupLayout(jDialogFinalizar.getContentPane());
            jDialogFinalizar.getContentPane().setLayout(jDialogFinalizarLayout);
            jDialogFinalizarLayout.setHorizontalGroup(
                jDialogFinalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialogFinalizarLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jDialogFinalizarLayout.setVerticalGroup(
                jDialogFinalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogFinalizarLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(16, 16, 16))
            );

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
            jLabel6.setForeground(new java.awt.Color(255, 255, 255));
            jLabel6.setText("FACTURACION");
            getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, 30));

            jButtonSalir.setText("Salir");
            jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonSalirActionPerformed(evt);
                }
            });
            getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, -1));

            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bannerProd.png"))); // NOI18N
            jLabel2.setText("Ventas");
            getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 50));

            jLabelIdVenta.setText("idVenta");
            getContentPane().add(jLabelIdVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

            jLabelIdDetalle.setText("idDetalle");
            getContentPane().add(jLabelIdDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

            jPanel5.setBackground(java.awt.SystemColor.controlShadow);
            jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle del producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

            jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            jButton2.setText("Finalizar venta");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            jButton3.setText("Agregar manualmente");
            jButton3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
                }
            });

            jToggleButton1.setBackground(new java.awt.Color(0, 0, 0));
            jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
            jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Borrar (2).png"))); // NOI18N
            jToggleButton1.setText("Quitar productos de lista");
            jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jToggleButton1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
            jPanel7.setLayout(jPanel7Layout);
            jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap(14, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );
            jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jButton2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jToggleButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton3)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 255), null));

            jLabel7.setText("N° DE COMPROBANTE:");

            jLabel8.setText("FECHA:");

            jLabelFecha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
            jLabelFecha.setText("jLabel10");

            jLabelNumero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
            jLabelNumero.setText("jLabel10");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabelFecha))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelNumero)))
                    .addContainerGap(23, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNumero)
                        .addComponent(jLabel7))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabelFecha))
                    .addGap(84, 84, 84))
            );

            jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 255), null));

            jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
            jLabel3.setText("Cod. de barras:");

            jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextFieldCodigoActionPerformed(evt);
                }
            });
            jTextFieldCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    jTextFieldCodigoKeyPressed(evt);
                }
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    jTextFieldCodigoKeyTyped(evt);
                }
            });

            jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
            jLabel4.setText("Codigo:");

            jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextFieldNombreActionPerformed(evt);
                }
            });
            jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    jTextFieldNombreKeyTyped(evt);
                }
            });

            jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
            jLabel9.setText("Descripcion:");

            jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
            jLabel10.setText("Prec.Uni:");

            jTextFieldCodBarras.setBackground(new java.awt.Color(0, 0, 0));
            jTextFieldCodBarras.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
            jTextFieldCodBarras.setForeground(new java.awt.Color(255, 255, 0));
            jTextFieldCodBarras.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextFieldCodBarrasActionPerformed(evt);
                }
            });
            jTextFieldCodBarras.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    jTextFieldCodBarrasKeyTyped(evt);
                }
            });

            jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
            jLabel12.setText("Cant disponible:");

            javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
            jPanel8.setLayout(jPanel8Layout);
            jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9)
                                    .addGap(92, 92, 92)))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel12))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGap(116, 116, 116)
                                    .addComponent(jLabel3)))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextFieldCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel4)
                        .addComponent(jLabel12))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
            jPanel6.setLayout(jPanel6Layout);
            jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );

            jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de la venta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

            jTableVenta.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Codigo", "Nombre", "Precio", "Cantidad", "Importe"
                }
            ));
            jScrollPane1.setViewportView(jTableVenta);

            jTextFieldTotal.setBackground(new java.awt.Color(0, 0, 0));
            jTextFieldTotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
            jTextFieldTotal.setForeground(new java.awt.Color(255, 255, 0));
            jTextFieldTotal.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextFieldTotalActionPerformed(evt);
                }
            });

            jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
            jLabel5.setForeground(new java.awt.Color(0, 0, 255));
            jLabel5.setText("TOTAL:");

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(30, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
            );

            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
            jPanel5.setLayout(jPanel5Layout);
            jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(12, Short.MAX_VALUE))
            );
            jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(32, Short.MAX_VALUE))
            );

            getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 840, 610));

            setBounds(0, 0, 856, 666);
        }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        int filaSelec = jTableVenta.getSelectedRow(); 
        int confirmar = JOptionPane.showConfirmDialog(null,"¿Quitar producto?");
      
        if(confirmar == JOptionPane.YES_OPTION){  
        m = (DefaultTableModel) jTableVenta.getModel();
        m.removeRow(filaSelec);
        this.ceros();
        }else{}
        
   
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jDialogFinalizar.setVisible(true);
        jDialogFinalizar.setSize(400,300);
        jDialogFinalizar.setLocationRelativeTo(null);
        jTextFieldTotalAbonar.setText(jTextFieldTotal.getText());
        jTextFieldAbono.requestFocus();
        
  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jDialog1.setVisible(true);
        jDialog1.setSize(624,350);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked
        jTextFieldCant1.requestFocus();
       
    }//GEN-LAST:event_jTableProductosMouseClicked

    private void jButtonAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarProductoActionPerformed
       int filSelec = jTableProductos.getSelectedRow();
        try{
            String codigo;
            String nombre;
            String precio;
            String cantidad;
            String importe;
            double calculo = 0.0;
            double x = 0.0;
           
                
            if(filSelec == -1){
                    JOptionPane.showMessageDialog(null,"Seleccione un producto");
                }else{
                    
                    m = (DefaultTableModel) jTableProductos.getModel();
                    codigo = jTableProductos.getValueAt(filSelec, 0).toString();
                    nombre = jTableProductos.getValueAt(filSelec, 1).toString();
                    precio = jTableProductos.getValueAt(filSelec, 4).toString();
                    cantidad = jTextFieldCant1.getText();
                    
                    x=(Double.parseDouble(precio)) * Integer.parseInt(cantidad);
                    importe = String.valueOf(x);
                   
                    
                    m = (DefaultTableModel) jTableVenta.getModel();
                    String filaRegistro [] = {codigo,nombre,precio,cantidad,importe};
                    m.addRow(filaRegistro);
                    
                    calculo = Double.parseDouble(precio)* Integer.parseInt(cantidad);
                    
                  
                    total = total + calculo;
                   
                    jTextFieldTotal.setText(""+total);
                    jTextFieldCant1.setText("");
                    
            }
        }catch(Exception e){}
       
    }//GEN-LAST:event_jButtonAgregarProductoActionPerformed

    private void jTextFieldBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBusquedaActionPerformed

    }//GEN-LAST:event_jTextFieldBusquedaActionPerformed

    private void jButtonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBusquedaActionPerformed
        String busqueda = jTextFieldBusqueda.getText();
        String filtro = jComboBoxFiltro.getSelectedItem().toString();

        Producto p = new Producto();
        p.buscarProducto(busqueda, filtro, jTableProductos);

    }//GEN-LAST:event_jButtonBusquedaActionPerformed

    private void jComboBoxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFiltroActionPerformed
        jTextFieldBusqueda.requestFocus();
    }//GEN-LAST:event_jComboBoxFiltroActionPerformed

    private void jTextFieldCant1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCant1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCant1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jDialog1.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextFieldTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jTextFieldCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoKeyPressed
   
 
    }//GEN-LAST:event_jTextFieldCodigoKeyPressed

    private void jTextFieldCodBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodBarrasActionPerformed

    private void jTextFieldCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoKeyTyped
        char tecla = evt.getKeyChar();
        String codigo = jTextFieldCodigo.getText();
            
        try{
              rs = autoc.find(jTextFieldCodigo.getText());
              if(rs.next()){
                  jTextFieldNombre.setText(rs.getString("nombre_producto"));
                  jTextFieldPrecio.setText(rs.getString("precio_producto").toString());
                  jTextFieldCodigo.setText(rs.getString("id_producto"));
                  jTextFieldCodBarras.setText(rs.getString("codigo_barras").toString());
                  jTextFieldCantidad.setText(rs.getString("cantidad").toString());
               }
                  
            }catch(Exception ex){
                   JOptionPane.showMessageDialog(null, ex.getMessage());}
            
            
        if(tecla == KeyEvent.VK_ENTER ){
           
             if(jTextFieldCodigo.getText().isEmpty()){
                 
                 if(jTextFieldNombre.getText().isEmpty()){
            
                    JOptionPane.showMessageDialog(null,"Por favor ingresar un producto");}
                
                
                }else{
                 
                    String cantidad = JOptionPane.showInputDialog("Ingrese la cantidad:").toString();


                    String nombre;
                    String precio;
                    String importe;
                    double calculo = 0.0;
                    double x = 0.0;
                
                
                    try{
                   
                        codigo = jTextFieldCodigo.getText();
                        nombre = jTextFieldNombre.getText();
                        precio = jTextFieldPrecio.getText();


                        x=(Double.parseDouble(precio)) * Integer.parseInt(cantidad);

                        importe = String.valueOf(x);


                        m = (DefaultTableModel) jTableVenta.getModel();
                        String filaRegistro [] = {codigo,nombre,precio,cantidad,importe};
                        m.addRow(filaRegistro);

                        calculo = Double.parseDouble(precio)* Integer.parseInt(cantidad);

                       
                        total = 0 + calculo;
                       
                        jTextFieldTotal.setText(""+total);
                        jTextFieldCant1.setText("");


                    }catch(Exception e){}}}
          
        
    

    }//GEN-LAST:event_jTextFieldCodigoKeyTyped

    private void jTextFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyTyped
         char tecla = evt.getKeyChar();
         String codigo = jTextFieldCodigo.getText();
   
        
         //autocompletado con la BD
         try{
         rs = autoc.findNombre(jTextFieldNombre.getText());
            
              if(rs.next()){
                  jTextFieldCodigo.setText(rs.getString("id_producto"));
                  jTextFieldPrecio.setText(rs.getString("precio_producto").toString());
                  jTextFieldCantidad.setText(rs.getString("cantidad").toString());
                  jTextFieldCodBarras.setText(rs.getString("codigo_barras"));
                  jTextFieldNombre.requestFocus();}
                  
              }catch(Exception ex){
                   JOptionPane.showMessageDialog(null, ex.getMessage());}
         
         
         
         
         if(tecla == KeyEvent.VK_ENTER ){
           
             if(jTextFieldCodigo.getText().isEmpty()){
                 
                 if(jTextFieldNombre.getText().isEmpty()){
            
                JOptionPane.showMessageDialog(null,"Por favor ingresar un producto");}
                
                
             }else{
                 
                String cantidad = JOptionPane.showInputDialog("Ingrese la cantidad:").toString();
                 
                
                String nombre;
                String precio;
                String importe;
                double calculo = 0.0;
                double x = 0.0;
                
                
                try{
                   
                    codigo = jTextFieldCodigo.getText();
                    nombre = jTextFieldNombre.getText();
                    precio = jTextFieldPrecio.getText();
                    
                    
                    x=(Double.parseDouble(precio)) * Integer.parseInt(cantidad);
                    
                    importe = String.valueOf(x);
                   
                    
                    m = (DefaultTableModel) jTableVenta.getModel();
                    String filaRegistro [] = {codigo,nombre,precio,cantidad,importe};
                    m.addRow(filaRegistro);
                    
                    calculo = Double.parseDouble(precio)* Integer.parseInt(cantidad);
                    
                    subtotal  = subtotal + calculo;
                    total = total + calculo;
                   
                    jTextFieldTotal.setText(""+total);
                    jTextFieldCant1.setText("");
                    
            
        }catch(Exception e){}}}
            
            
            
           
         
        
    }//GEN-LAST:event_jTextFieldNombreKeyTyped

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAbonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAbonoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       jDialogFinalizar.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Venta venta = new Venta();
        DetalleVenta detalleVenta = new DetalleVenta();
        
        String IdDetalleVenta = jLabelIdDetalle.getText();
        String numVent=jLabelNumero.getText();
        String IdVenta = jLabelIdVenta.getText();
        
        String total = jTextFieldTotal.getText();
        String fecha = jLabelFecha.getText();
        
       
          for(int i=0;i<jTableVenta.getRowCount();i++){
            String codProd=jTableVenta.getValueAt(i, 0).toString();
            String nombre =jTableVenta.getValueAt(i, 1).toString();
            String precprod =jTableVenta.getValueAt(i, 2).toString();
            String cantprod =jTableVenta.getValueAt(i, 3).toString();
            String importe = jTableVenta.getValueAt(i, 4).toString();
              
           detalleVenta.insertarDetalleVenta(IdDetalleVenta,codProd, importe, cantprod);
        }
        
        for(int i=0;i<jTableVenta.getRowCount();i++){
            String codi= jTableVenta.getValueAt(i, 0).toString();
            String cant= jTableVenta.getValueAt(i, 3).toString();
            venta.descontarStock(codi, cant);
            }
            
  
          
         venta.InsertarVenta(IdVenta,numVent, total, fecha, IdDetalleVenta);
         
         Sql s = new Sql();
         jLabelNumero.setText(""+s.id_autoincrementalFactura());
         jLabelIdVenta.setText(""+s.id_autoincrementalVenta());
         jLabelIdDetalle.setText(""+s.id_autoincrementalDetalle());
         
         jDialogFinalizar.dispose();
         
         jTextFieldCodigo.setText("");
         jTextFieldNombre.setText("");
         jTextFieldCantidad.setText("");
         jTextFieldPrecio.setText("");
         jTextFieldCodBarras.setText("");
         
         jTextFieldTotal.setText("");
         
        DefaultTableModel modelo = (DefaultTableModel) jTableVenta.getModel();
        int a = jTableVenta.getRowCount()-1;
        int i;
        for(i=a;i>=0;i--)
        {
            modelo.removeRow(i);
        }
      

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldCodBarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodBarrasKeyTyped
         char tecla = evt.getKeyChar();
         String codigo = jTextFieldCodigo.getText();
   
        
         //autocompletado con la BD
         try{
         rs = autoc.findCodigoBarras(jTextFieldCodBarras.getText());
            
              if(rs.next()){
                  
                  jTextFieldCodigo.setText(rs.getString("id_producto"));
                  jTextFieldNombre.setText(rs.getString("nombre_producto"));
                  jTextFieldPrecio.setText(rs.getString("precio_producto").toString());
                  jTextFieldCantidad.setText(rs.getString("cantidad").toString());
                  jTextFieldCodBarras.setText(rs.getString("codigo_barras"));
                  jTextFieldCodBarras.requestFocus();}
                  
              }catch(Exception ex){
                   JOptionPane.showMessageDialog(null, ex.getMessage());}
         
         
         
         
         if(tecla == KeyEvent.VK_ENTER ){
           
             if(jTextFieldCodigo.getText().isEmpty()){
                 
                 if(jTextFieldNombre.getText().isEmpty()){
            
                    JOptionPane.showMessageDialog(null,"Por favor ingresar un producto");}/*if vacio nombre*/
             }/*if vacio codigo*/ 
             else{    
                    
                    String cantidad = JOptionPane.showInputDialog("Ingrese la cantidad:").toString();
                    
                    if(cantidad == null){jTextFieldCodBarras.requestFocus();
                    
                    }/*cierre del if (cantidad cancelada)*/
                    else{
                 
                
                    
                    
                         
              
                        String nombre;
                        String precio;
                        String importe;
                        double calculo = 0.0;
                        double x = 0.0;


                        try{

                            codigo = jTextFieldCodigo.getText();
                            nombre = jTextFieldNombre.getText();
                            precio = jTextFieldPrecio.getText();


                            x=(Double.parseDouble(precio)) * Integer.parseInt(cantidad);

                            importe = String.valueOf(x);


                            m = (DefaultTableModel) jTableVenta.getModel();
                            String filaRegistro [] = {codigo,nombre,precio,cantidad,importe};
                            m.addRow(filaRegistro);

                            calculo = Double.parseDouble(precio)* Integer.parseInt(cantidad);


                            total = total + calculo;

                            jTextFieldTotal.setText(""+total);
                            jTextFieldCant1.setText("");


                        }catch(Exception e){/*cierre del catch*/}
                        
                    }/*cierre del else if (cantidad cancelada null)*/
                            
             }/*cierre del else (codigo vacio)*/

                                
         }/*cierre del if (tecla enter) */
    }//GEN-LAST:event_jTextFieldCodBarrasKeyTyped

    private void jTextFieldAbonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAbonoKeyReleased
       String totalAbonarS = jTextFieldAbono.getText();
       
       if(totalAbonarS.equals("")== false && totalAbonarS.matches("[0-9]*")){
       
           Double totalVuelto= Double.parseDouble(jTextFieldAbono.getText())- Double.parseDouble(jTextFieldTotalAbonar.getText()) ;
           
           jTextFieldVuelto.setText(" "+totalVuelto );
       
       }
    }//GEN-LAST:event_jTextFieldAbonoKeyReleased

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
            java.util.logging.Logger.getLogger(RegistrarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonAgregarProducto;
    private javax.swing.JButton jButtonBusqueda;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxFiltro;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialogFinalizar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelIdDetalle;
    private javax.swing.JLabel jLabelIdVenta;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTable jTableVenta;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldAbono;
    private javax.swing.JTextField jTextFieldBusqueda;
    private javax.swing.JTextField jTextFieldCant1;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldCodBarras;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextFieldTotalAbonar;
    private javax.swing.JTextField jTextFieldVuelto;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
