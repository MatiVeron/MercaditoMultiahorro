
package PKInterface;

import BD.ConexionBD;
import PKClases.AutoCompletar;
import PKClases.Caja;
import PKClases.DetalleVenta;
import PKClases.Fecha;

import PKClases.Producto;
import PKClases.Sql;
import PKClases.TablaBalanceVentas;
import PKClases.TablaProductos;
import PKClases.TablaVenta;
import PKClases.Venta;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matias
 */
public class RegistrarVentas extends javax.swing.JFrame {
    TablaProductos tablaProductos = new TablaProductos();
    TablaVenta tablaVenta  = new TablaVenta();
    TablaBalanceVentas  tablaBalanceHoy = new TablaBalanceVentas();
    DefaultTableModel m;
    
    Double total;
    Date fechaHoy = new Date();
    Fecha fecha = new Fecha();
    Connection con = ConexionBD.getConexion();
    ResultSet rs;
    AutoCompletar autoc = new AutoCompletar();
    public static int idUsuario;
    int num;
    String comprobante;
    
    
    
    
   
    public RegistrarVentas() {
        initComponents();
        jTextFieldCodBarras.requestFocus();
        
        tablaProductos.LlenarTabla(jTableProductos);
        jDialog1.setUndecorated(false);
        this.setDefaultCloseOperation(0);
  
        total = 0.0;
        DefaultTableModel modelo;
        this.setResizable(false);
        this.setTitle("Registro de Ventas");
        jLabelIdVenta.setVisible(false);
        jLabelIdDetalle.setVisible(false);
        jTextFieldTotal.setEditable(false);

        
        
         jTextFieldNombre.setEditable(false);
         jTextFieldCodBarras.setEditable(true);

         
         jTextFieldCantidad.setEditable(false);
        jTextFieldCodigo.setEditable(false);
        jTextFieldPrecio.setEditable(false);
       
       
       
        
        

        jLabelFecha.setText(""+fecha.fechaActual());
        
        Sql s =new Sql();
        //jLabelNumero.setText(""+s.id_autoincrementalFactura());
        num = s.id_autoincrementalFactura();
        comprobante = s.generarNumeroComprobante(num);
        jLabelNumero.setText(comprobante);
        jLabelIdVenta.setText(""+s.id_autoincrementalVenta());
        jLabelIdDetalle.setText(""+s.id_autoincrementalDetalle());
        
        this.setLocationRelativeTo(null);
        this.ceros();
        this.AutoCompletar();
        
}
    
    
    
    public void AutoCompletar() {
        TextAutoCompleter textAutoCNombre = new TextAutoCompleter(jTextFieldNombre);
        TextAutoCompleter textAutoCCodigo= new TextAutoCompleter(jTextFieldCodigo);
        TextAutoCompleter textAutoCCodigoBarras = new TextAutoCompleter(jTextFieldCodBarras);
        
        
        try {
            
            Statement sent = con.createStatement();
            ResultSet rs = sent.executeQuery("SELECT * FROM productos WHERE productos.id_estado = 1");
            
           
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
        jTabbedPane2 = new javax.swing.JTabbedPane();
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
            jPanel15 = new javax.swing.JPanel();
            jButton4 = new javax.swing.JButton();
            jButtonAgregarProducto = new javax.swing.JButton();
            jLabel24 = new javax.swing.JLabel();
            jTextFieldCant1 = new javax.swing.JTextField();
            jDialogFinalizar = new javax.swing.JDialog();
            jPanel4 = new javax.swing.JPanel();
            jPanel16 = new javax.swing.JPanel();
            jLabel14 = new javax.swing.JLabel();
            jLabel11 = new javax.swing.JLabel();
            jLabel13 = new javax.swing.JLabel();
            jTextFieldTotalAbonar = new javax.swing.JTextField();
            jTextFieldAbono = new javax.swing.JTextField();
            jTextFieldVuelto = new javax.swing.JTextField();
            jPanel17 = new javax.swing.JPanel();
            jButton5 = new javax.swing.JButton();
            jButton1 = new javax.swing.JButton();
            jDialogVenta = new javax.swing.JDialog();
            jTextFieldEstado = new javax.swing.JTextField();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel16 = new javax.swing.JLabel();
            jPanel7 = new javax.swing.JPanel();
            jTextFieldTotalVentaEspera = new javax.swing.JTextField();
            jLabel17 = new javax.swing.JLabel();
            jButton9 = new javax.swing.JButton();
            jButton10 = new javax.swing.JButton();
            jButton11 = new javax.swing.JButton();
            jTextFieldFecha = new javax.swing.JTextField();
            jTextFieldComprobante = new javax.swing.JTextField();
            jScrollPane6 = new javax.swing.JScrollPane();
            jTableDetalleVentas2 = new javax.swing.JTable();
            jTextField1 = new javax.swing.JTextField();
            jTabbedPane1 = new javax.swing.JTabbedPane();
            jPanelNuevaVenta = new javax.swing.JPanel();
            jPanel8 = new javax.swing.JPanel();
            jLabel3 = new javax.swing.JLabel();
            jTextFieldCodigo = new javax.swing.JTextField();
            jTextFieldNombre = new javax.swing.JTextField();
            jLabel9 = new javax.swing.JLabel();
            jTextFieldPrecio = new javax.swing.JTextField();
            jLabel10 = new javax.swing.JLabel();
            jTextFieldCodBarras = new javax.swing.JTextField();
            jLabel12 = new javax.swing.JLabel();
            jTextFieldCantidad = new javax.swing.JTextField();
            jLabel4 = new javax.swing.JLabel();
            jLabel18 = new javax.swing.JLabel();
            jCheckBoxBuscarPorDescripcion = new javax.swing.JCheckBox();
            jPanel13 = new javax.swing.JPanel();
            jLabel23 = new javax.swing.JLabel();
            jLabel26 = new javax.swing.JLabel();
            jLabel27 = new javax.swing.JLabel();
            jLabel28 = new javax.swing.JLabel();
            jLabelIdDetalle = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTableVenta = new javax.swing.JTable();
            jPanel2 = new javax.swing.JPanel();
            jButton2 = new javax.swing.JButton();
            jButton6 = new javax.swing.JButton();
            jButton7 = new javax.swing.JButton();
            jPanel1 = new javax.swing.JPanel();
            jLabel7 = new javax.swing.JLabel();
            jLabel8 = new javax.swing.JLabel();
            jLabelFecha = new javax.swing.JLabel();
            jLabelNumero = new javax.swing.JLabel();
            jPanel6 = new javax.swing.JPanel();
            jButton3 = new javax.swing.JButton();
            jToggleButton1 = new javax.swing.JToggleButton();
            jLabelIdVenta = new javax.swing.JLabel();
            jLabel29 = new javax.swing.JLabel();
            jPanel14 = new javax.swing.JPanel();
            jTextFieldTotal = new javax.swing.JTextField();
            jLabel5 = new javax.swing.JLabel();
            jLabel30 = new javax.swing.JLabel();
            jButton8 = new javax.swing.JButton();

            jTextField2.setText("jTextField2");

            jPanel3.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
            jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Productos en stock"));

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

            jLabel25.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
            jLabel25.setText("Buscar por:");

            jPanel15.setBackground(java.awt.SystemColor.inactiveCaption);
            jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            jButton4.setText("salir");
            jButton4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton4ActionPerformed(evt);
                }
            });

            jButtonAgregarProducto.setText("agregar");
            jButtonAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonAgregarProductoActionPerformed(evt);
                }
            });

            jLabel24.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
            jLabel24.setText("Cantidad:");

            jTextFieldCant1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextFieldCant1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
            jPanel15.setLayout(jPanel15Layout);
            jPanel15Layout.setHorizontalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                    .addContainerGap(19, Short.MAX_VALUE)
                    .addComponent(jLabel24)
                    .addGap(18, 18, 18)
                    .addComponent(jTextFieldCant1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jButtonAgregarProducto)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton4)
                    .addContainerGap())
            );
            jPanel15Layout.setVerticalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                    .addContainerGap(10, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButtonAgregarProducto)
                        .addComponent(jLabel24)
                        .addComponent(jTextFieldCant1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(10, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jScrollPane2)
                            .addContainerGap())))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButtonBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(11, Short.MAX_VALUE))
            );

            jTabbedPane2.addTab("Stock", jPanel3);

            javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
            jDialog1.getContentPane().setLayout(jDialog1Layout);
            jDialog1Layout.setHorizontalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            jDialog1Layout.setVerticalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            jPanel4.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
            jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Finalizar la venta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

            jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Indicar con cuanto abona:"));

            jLabel14.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
            jLabel14.setText("VUELTO DE:");

            jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
            jLabel11.setText("ABONA CON:");

            jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
            jLabel13.setText("TOTAL:");

            jTextFieldTotalAbonar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextFieldTotalAbonarActionPerformed(evt);
                }
            });

            jTextFieldAbono.setForeground(new java.awt.Color(0, 204, 0));
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

            jTextFieldVuelto.setForeground(new java.awt.Color(255, 51, 51));
            jTextFieldVuelto.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextFieldVueltoActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
            jPanel16.setLayout(jPanel16Layout);
            jPanel16Layout.setHorizontalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14))
                    .addGap(50, 50, 50)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldAbono)
                            .addComponent(jTextFieldTotalAbonar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextFieldVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(17, Short.MAX_VALUE))
            );
            jPanel16Layout.setVerticalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                    .addContainerGap(16, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel13)
                        .addComponent(jTextFieldTotalAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addContainerGap())
            );

            jPanel17.setBackground(java.awt.SystemColor.inactiveCaption);
            jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            jButton5.setText("Cancelar");
            jButton5.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton5ActionPerformed(evt);
                }
            });

            jButton1.setText("Finalizar");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
            jPanel17.setLayout(jPanel17Layout);
            jPanel17Layout.setHorizontalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton5)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel17Layout.setVerticalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton1))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout jDialogFinalizarLayout = new javax.swing.GroupLayout(jDialogFinalizar.getContentPane());
            jDialogFinalizar.getContentPane().setLayout(jDialogFinalizarLayout);
            jDialogFinalizarLayout.setHorizontalGroup(
                jDialogFinalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialogFinalizarLayout.createSequentialGroup()
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
            );
            jDialogFinalizarLayout.setVerticalGroup(
                jDialogFinalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialogFinalizarLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            jTextFieldEstado.setBackground(new java.awt.Color(255, 255, 0));
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

            jButton9.setText("Finalizar venta");
            jButton9.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton9ActionPerformed(evt);
                }
            });

            jButton10.setText("Anular venta");
            jButton10.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton10ActionPerformed(evt);
                }
            });

            jButton11.setText("Reabrir venta");
            jButton11.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton11ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
            jPanel7.setLayout(jPanel7Layout);
            jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jButton9)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11)
                    .addGap(12, 12, 12)
                    .addComponent(jButton10)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel17)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextFieldTotalVentaEspera, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(18, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTotalVentaEspera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(jButton9)
                        .addComponent(jButton10)
                        .addComponent(jButton11))
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
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(51, Short.MAX_VALUE))
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
                    .addGap(26, 26, 26)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(76, Short.MAX_VALUE))
            );

            jTextField1.setText("jTextField1");

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jPanelNuevaVenta.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
            jPanelNuevaVenta.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), null));
            jPanelNuevaVenta.setForeground(new java.awt.Color(255, 255, 255));

            jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos de la venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

            jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
            jLabel3.setText("Codigo de barras:");

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
            jLabel9.setText("Descripcion");

            jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
            jLabel10.setText("Precio:");

            jTextFieldCodBarras.setBackground(new java.awt.Color(255, 255, 153));
            jTextFieldCodBarras.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
            jTextFieldCodBarras.setForeground(new java.awt.Color(255, 51, 51));
            jTextFieldCodBarras.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
            jLabel12.setText("Stock disponible:");

            jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
            jLabel4.setText("Codigo interno:");

            jLabel18.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
            jLabel18.setText("ARS$");

            jCheckBoxBuscarPorDescripcion.setText("Buscar");
            jCheckBoxBuscarPorDescripcion.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jCheckBoxBuscarPorDescripcionActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
            jPanel8.setLayout(jPanel8Layout);
            jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(3, 3, 3)
                            .addComponent(jLabel18)
                            .addGap(33, 33, 33)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jCheckBoxBuscarPorDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(287, 287, 287))
            );
            jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextFieldCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jCheckBoxBuscarPorDescripcion))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel18))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jPanel13.setBackground(java.awt.SystemColor.inactiveCaption);
            jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            jLabel23.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
            jLabel23.setText("MERCADITO MULTI-AHORRO");

            jLabel26.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
            jLabel26.setText("LARREA 2600 - ZARATE PROV. BS AS");

            jLabel27.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
            jLabel27.setText("REGISTRAR VENTAS EN EL SISTEMA");

            jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/shop_106574 (1).png"))); // NOI18N

            javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
            jPanel13.setLayout(jPanel13Layout);
            jPanel13Layout.setHorizontalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jLabel28)
                    .addGap(51, 51, 51)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel26)
                        .addComponent(jLabel23)
                        .addComponent(jLabel27))
                    .addContainerGap(35, Short.MAX_VALUE))
            );
            jPanel13Layout.setVerticalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel28)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel23)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel27)))
                    .addContainerGap(21, Short.MAX_VALUE))
            );

            jLabelIdDetalle.setText("idDetalle");

            jTableVenta.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Codigo", "Nombre", "Precio", "Cantidad", "Importe"
                }
            ));
            jScrollPane1.setViewportView(jTableVenta);

            jPanel2.setBackground(java.awt.SystemColor.inactiveCaption);
            jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Opciones de venta"));

            jButton2.setText("Finalizar venta");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            jButton6.setText("Finalizar despues");
            jButton6.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton6ActionPerformed(evt);
                }
            });

            jButton7.setText("Cancelar venta");
            jButton7.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton7ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton7))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton6)
                        .addComponent(jButton7))
                    .addContainerGap())
            );

            jPanel1.setBackground(java.awt.SystemColor.inactiveCaption);
            jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del comprobante"));

            jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
            jLabel7.setText("Comprobante:");

            jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
            jLabel8.setText("Fecha:");

            jLabelFecha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
            jLabelFecha.setText("jLabel10");

            jLabelNumero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
            jLabelNumero.setText("jLabel10");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelFecha, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelNumero, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(43, 43, 43))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabelFecha))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNumero)
                        .addComponent(jLabel7))
                    .addGap(107, 107, 107))
            );

            jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Opciones de productos"));

            jButton3.setText("Ver disponibles");
            jButton3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
                }
            });

            jToggleButton1.setBackground(new java.awt.Color(0, 0, 0));
            jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
            jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Borrar (2).png"))); // NOI18N
            jToggleButton1.setText("Quitar ");
            jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jToggleButton1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
            jPanel6.setLayout(jPanel6Layout);
            jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(122, 122, 122))
            );
            jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jToggleButton1)))
            );

            jLabelIdVenta.setText("idVenta");

            jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_realizar_venta (2).png"))); // NOI18N

            jPanel14.setBackground(java.awt.SystemColor.inactiveCaption);
            jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Total registrado"));

            jTextFieldTotal.setBackground(new java.awt.Color(0, 0, 0));
            jTextFieldTotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
            jTextFieldTotal.setForeground(new java.awt.Color(255, 255, 0));
            jTextFieldTotal.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextFieldTotalActionPerformed(evt);
                }
            });

            jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
            jLabel5.setText("TOTAL:");

            javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
            jPanel14.setLayout(jPanel14Layout);
            jPanel14Layout.setHorizontalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            jPanel14Layout.setVerticalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10))
            );

            jLabel30.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
            jLabel30.setText("Autor: Veron Matias - Proyecto Profesional 2019 - Analisis de sistemas ");

            jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_volver.png"))); // NOI18N
            jButton8.setText("salir");
            jButton8.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton8ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanelNuevaVentaLayout = new javax.swing.GroupLayout(jPanelNuevaVenta);
            jPanelNuevaVenta.setLayout(jPanelNuevaVentaLayout);
            jPanelNuevaVentaLayout.setHorizontalGroup(
                jPanelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelNuevaVentaLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jLabel30)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNuevaVentaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelNuevaVentaLayout.createSequentialGroup()
                            .addComponent(jButton8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelNuevaVentaLayout.createSequentialGroup()
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelNuevaVentaLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelIdVenta)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabelIdDetalle))
                                .addGroup(jPanelNuevaVentaLayout.createSequentialGroup()
                                    .addGap(110, 110, 110)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(9, Short.MAX_VALUE))
                .addGroup(jPanelNuevaVentaLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jLabel29)
                    .addGap(60, 60, 60)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelNuevaVentaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap())
            );
            jPanelNuevaVentaLayout.setVerticalGroup(
                jPanelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelNuevaVentaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29))
                    .addGap(10, 10, 10)
                    .addGroup(jPanelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelNuevaVentaLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addGroup(jPanelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelIdVenta)
                                .addComponent(jLabelIdDetalle)))
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelNuevaVentaLayout.createSequentialGroup()
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, Short.MAX_VALUE)
                            .addGap(1192, 1192, 1192))
                        .addGroup(jPanelNuevaVentaLayout.createSequentialGroup()
                            .addGroup(jPanelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addComponent(jLabel30)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            );

            jTabbedPane1.addTab("Nueva venta", jPanelNuevaVenta);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1730, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            setBounds(0, 0, 859, 688);
        }// </editor-fold>//GEN-END:initComponents

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked
        jTextFieldCant1.requestFocus();
       
    }//GEN-LAST:event_jTableProductosMouseClicked

    private void jButtonAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarProductoActionPerformed
       
        try{
            String codigo;
            String nombre;
            String precio;
            String cantidad;
            String importe;
            double calculo = 0.0;
            double x = 0.0;
           int filSelec = jTableProductos.getSelectedRow();
                
            if(filSelec == -1){
                    JOptionPane.showMessageDialog(null,"Seleccione un producto");
                }else{
                    
                    m = (DefaultTableModel) jTableVenta.getModel();
                    codigo = jTableProductos.getValueAt(filSelec, 0).toString();
                    nombre = jTableProductos.getValueAt(filSelec, 1).toString();
                    precio = jTableProductos.getValueAt(filSelec, 5).toString();
                    cantidad = jTextFieldCant1.getText();
                    
                    x=(Double.parseDouble(precio)) * Integer.parseInt(cantidad);
                    importe = String.valueOf(x);
                   
                    
                    
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

    private void jTextFieldAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAbonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAbonoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       jDialogFinalizar.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*Boton finalizar la venta*/
        
        Venta venta = new Venta();
        DetalleVenta detalleVenta = new DetalleVenta();
        Caja caja = new Caja();
        String idEstado = "1";
        String IdDetalleVenta = jLabelIdDetalle.getText();
        String numVent=jLabelNumero.getText();
        String IdVenta = jLabelIdVenta.getText();
        
        String total = jTextFieldTotal.getText();
   
        
        Date fechaHoy = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String fecha = formatoFecha.format(fechaHoy);
       
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
            
        int idCaja= caja.obtener_idCaja();
          
         venta.InsertarVenta(IdVenta,numVent, total, fecha, IdDetalleVenta,idEstado,idUsuario,idCaja);
         
         Sql s = new Sql();
         //jLabelNumero.setText(""+s.id_autoincrementalFactura());
         jLabelIdVenta.setText(""+s.id_autoincrementalVenta());
         jLabelIdDetalle.setText(""+s.id_autoincrementalDetalle());
         
         jDialogFinalizar.dispose();
         
         jTextFieldCodigo.setText("");
         jTextFieldNombre.setText("");
         jTextFieldCantidad.setText("");
         jTextFieldPrecio.setText("");
         jTextFieldCodBarras.setText("");
         
         
         jTextFieldTotal.setText("0.0");
         
        DefaultTableModel modelo = (DefaultTableModel) jTableVenta.getModel();
        int a = jTableVenta.getRowCount()-1;
        int i;
        for(i=a;i>=0;i--)
        {
            modelo.removeRow(i);
        }
        
        jTextFieldVuelto.setText("");
        jTextFieldAbono.setText("");
        jTextFieldCodBarras.requestFocus();
        num = s.id_autoincrementalFactura();
        comprobante = s.generarNumeroComprobante(num);
        jLabelNumero.setText(comprobante);
        
        //tablaEspera.LlenarTabla(jTableBalanceVentas2);
      

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldAbonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAbonoKeyReleased
       String totalAbonarS = jTextFieldAbono.getText();
       
       if(totalAbonarS.equals("")== false && totalAbonarS.matches("[0-9]*")){
       
           Double totalVuelto= Double.parseDouble(jTextFieldAbono.getText())- Double.parseDouble(jTextFieldTotalAbonar.getText()) ;
           
           jTextFieldVuelto.setText(" "+totalVuelto );
       
       }
    }//GEN-LAST:event_jTextFieldAbonoKeyReleased

    private void jTextFieldEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEstadoActionPerformed

    private void jTextFieldTotalVentaEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalVentaEsperaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalVentaEsperaActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jDialogFinalizar.setVisible(true);
        jDialogFinalizar.setSize(400,300);
        jDialogFinalizar.setLocationRelativeTo(null);
        jTextFieldTotalAbonar.setText(jTextFieldTotal.getText());
        jTextFieldAbono.requestFocus();
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextFieldFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFechaActionPerformed

    private void jTextFieldTotalAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalAbonarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalAbonarActionPerformed

    private void jTextFieldVueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVueltoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVueltoActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextFieldTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        int filaSelec = jTableVenta.getSelectedRow();
        int confirmar = JOptionPane.showConfirmDialog(null,"¿Quitar producto?");

        if(confirmar == JOptionPane.YES_OPTION){
            m = (DefaultTableModel) jTableVenta.getModel();
            m.removeRow(filaSelec);
            this.ceros();
        }else{}
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jDialog1.setVisible(true);
        jDialog1.setSize(580,370);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int confirmar = JOptionPane.showConfirmDialog(null,"¿Cancelar venta? se removeran los productos de la lista");

        if(confirmar == JOptionPane.YES_OPTION){
            jTextFieldCodigo.setText("");
            jTextFieldNombre.setText("");
            jTextFieldCantidad.setText("");
            jTextFieldPrecio.setText("");
            jTextFieldCodBarras.setText("");

            jTextFieldTotal.setText("0.0");
            total = 0.0;

            DefaultTableModel modelo = (DefaultTableModel) jTableVenta.getModel();
            int a = jTableVenta.getRowCount()-1;
            int i;
            for(i=a;i>=0;i--)
            {
                modelo.removeRow(i);
            }}
        jTextFieldCodBarras.requestFocus();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Venta venta = new Venta();
        DetalleVenta detalleVenta = new DetalleVenta();
        Caja caja = new Caja();

        String idEstado = "2";
        String IdDetalleVenta = jLabelIdDetalle.getText();
        String numVent=jLabelNumero.getText();
        String IdVenta = jLabelIdVenta.getText();

        Date fechaHoy = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");
        String fecha = formatoFecha.format(fechaHoy);
       
       /*String fecha = jLabelFecha.getText();*/
        

        String total = jTextFieldTotal.getText();

        for(int i=0;i<jTableVenta.getRowCount();i++){
            String codProd=jTableVenta.getValueAt(i, 0).toString();
            String nombre =jTableVenta.getValueAt(i, 1).toString();
            String precprod =jTableVenta.getValueAt(i, 2).toString();
            String cantprod =jTableVenta.getValueAt(i, 3).toString();
            String importe = jTableVenta.getValueAt(i, 4).toString();

            detalleVenta.insertarDetalleVenta(IdDetalleVenta,codProd, importe, cantprod);
        }
        int idCaja = caja.obtener_idCaja();
        venta.InsertarVenta(IdVenta,numVent, total, fecha, IdDetalleVenta,idEstado,idUsuario,idCaja);

        Sql s = new Sql();
        //jLabelNumero.setText(""+s.id_autoincrementalFactura());
        num = s.id_autoincrementalFactura();
        comprobante = s.generarNumeroComprobante(num);
        jLabelNumero.setText(comprobante);
        jLabelIdVenta.setText(""+s.id_autoincrementalVenta());
        jLabelIdDetalle.setText(""+s.id_autoincrementalDetalle());

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
        jTextFieldCodBarras.requestFocus();
        jTextFieldTotal.setText("0.0");
            
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jDialogFinalizar.setVisible(true);
        jDialogFinalizar.setSize(400,300);
        jDialogFinalizar.setLocationRelativeTo(null);
        jTextFieldTotalAbonar.setText(jTextFieldTotal.getText());
        jTextFieldAbono.requestFocus();
        total = 0.0;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBoxBuscarPorDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxBuscarPorDescripcionActionPerformed
        if(jCheckBoxBuscarPorDescripcion.isSelected()){
            jTextFieldNombre.setEditable(true);
            jTextFieldCodBarras.setEditable(false);
            jTextFieldNombre.requestFocus();
        }else{
            jTextFieldNombre.setEditable(false);
            jTextFieldCodBarras.setEditable(true);
            jTextFieldCodBarras.requestFocus();
        
        }
    }//GEN-LAST:event_jCheckBoxBuscarPorDescripcionActionPerformed

    private void jTextFieldCodBarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodBarrasKeyTyped
        char tecla = evt.getKeyChar();
        String codigo = jTextFieldCodigo.getText();

        //autocompletado con la BD

        if(tecla == KeyEvent.VK_ENTER ){

            if(jTextFieldCodigo.getText().isEmpty()){
                try{
                    rs = autoc.findCodigoBarras(jTextFieldCodBarras.getText());

                    if(rs.next()){

                        jTextFieldCodigo.setText(rs.getString("id_producto"));
                        jTextFieldNombre.setText(rs.getString("nombre_producto"));
                        jTextFieldPrecio.setText(rs.getString("precio_producto").toString());
                        jTextFieldCantidad.setText(rs.getString("cantidad").toString());
                    }
                    jTextFieldCodBarras.requestFocus();

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());}
            }else{

                if(jTextFieldNombre.getText().isEmpty()){
                    try{
                        rs = autoc.findCodigoBarras(jTextFieldCodBarras.getText());

                        if(rs.next()){

                            jTextFieldCodigo.setText(rs.getString("id_producto"));
                            jTextFieldNombre.setText(rs.getString("nombre_producto"));
                            jTextFieldPrecio.setText(rs.getString("precio_producto").toString());
                            jTextFieldCantidad.setText(rs.getString("cantidad").toString());
                        }
                        jTextFieldCodBarras.requestFocus();

                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage());}

                }/*if Nombre codigo*/

                if(!jTextFieldCodigo.getText().isEmpty() & !jTextFieldNombre.getText().isEmpty()& !jTextFieldCodBarras.equals("")){

                    String cantidad = JOptionPane.showInputDialog("Ingrese la cantidad:").toString();

                    if(cantidad == null ){jTextFieldCodBarras.requestFocus();

                    }/*cierre del if (cantidad cancelada)*/
                    else{

                        String nombre;
                        String precio;
                        String importe;
                        double calculo = 0.0;
                        double x = 0.0;
                        double imp = 0.0;
                        
                            

                        try{

                            codigo = jTextFieldCodigo.getText();
                            nombre = jTextFieldNombre.getText();
                            precio = jTextFieldPrecio.getText();
                           
                           

                            x=(Double.parseDouble(precio)) * Integer.parseInt(cantidad);

                            importe = String.valueOf(x);

                            m = (DefaultTableModel) jTableVenta.getModel();
                            String filaRegistro [] = {codigo,nombre,precio,cantidad,importe};
                            m.addRow(filaRegistro);
                           
                            for(int i=0;i<jTableVenta.getRowCount();i++){
                               imp =  Double.parseDouble(jTableVenta.getValueAt(i,4).toString())+ imp;
                               
                            }
                            

                            calculo = Double.parseDouble(precio)* Integer.parseInt(cantidad);

                            total = imp;

                            jTextFieldTotal.setText(""+total);
                            jTextFieldCant1.setText("");

                            jTextFieldCant1.setText("");
                            jTextFieldNombre.setText("");
                            jTextFieldPrecio.setText("");
                            jTextFieldCodigo.setText("");
                            jTextFieldCodBarras.setText("");
                            jTextFieldCantidad.setText("");

                        }catch(Exception e){/*cierre del catch*/}

                    }/*cierre del else if (cantidad cancelada null)*/

                }/*cierre del else (!codigo vacio)*/

            }}/*cierre del if (tecla enter) */
    }//GEN-LAST:event_jTextFieldCodBarrasKeyTyped

    private void jTextFieldCodBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodBarrasActionPerformed

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

                //subtotal  = subtotal + calculo;
                    total = total + calculo;

                    jTextFieldTotal.setText(""+total);
                    jTextFieldCant1.setText("");

                }catch(Exception e){}}}
    }//GEN-LAST:event_jTextFieldNombreKeyTyped

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

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

                    total = total + calculo;

                    jTextFieldTotal.setText(""+total);
                    jTextFieldCant1.setText("");

                }catch(Exception e){}}}
    }//GEN-LAST:event_jTextFieldCodigoKeyTyped

    private void jTextFieldCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoKeyPressed

    }//GEN-LAST:event_jTextFieldCodigoKeyPressed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

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
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonAgregarProducto;
    private javax.swing.JButton jButtonBusqueda;
    private javax.swing.JCheckBox jCheckBoxBuscarPorDescripcion;
    private javax.swing.JComboBox<String> jComboBoxFiltro;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialogFinalizar;
    private javax.swing.JDialog jDialogVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelIdDetalle;
    private javax.swing.JLabel jLabelIdVenta;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelNuevaVenta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTableDetalleVentas2;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTable jTableVenta;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldAbono;
    private javax.swing.JTextField jTextFieldBusqueda;
    private javax.swing.JTextField jTextFieldCant1;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldCodBarras;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldComprobante;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextFieldTotalAbonar;
    private javax.swing.JTextField jTextFieldTotalVentaEspera;
    private javax.swing.JTextField jTextFieldVuelto;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
