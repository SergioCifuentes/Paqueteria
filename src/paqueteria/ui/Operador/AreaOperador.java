/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.ui.Operador;

import java.awt.Color;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import paqueteria.DB.ControladorDB;
import paqueteria.DB.ControladorDeBodega;
import paqueteria.DB.TransferenciasDB;
import paqueteria.Ruta.PuntoDeControl;
import paqueteria.Usuario.Operador;
import paqueteria.paquetes.Paquete;
import paqueteria.ui.IngresoDeUsuario;

/**
 *
 * @author sergio
 */
public class AreaOperador extends javax.swing.JFrame {

    private Operador user = null;
    private ArrayList<PuntoDeControl> puntosDeControl;
    private float tarifaDePaquete;
    private float tarifaActual;
    ArrayList<Paquete> paquetesDisponibles;
    private Paquete paqueteAProcesar;
    private final static String ERROR_PAQUETES = "No se encuentran Paquetes para Este Punto";
    private final static String ERROR_PUNTOS = "No Cuentas Con Puntos De Contol";

    /**
     * Creates new form AreaOperador
     *
     * @param user
     */
    public AreaOperador(Operador user) {
        this.user = user;
        initComponents();
        lblErrorPuntos.setText("");
        menuUser.setText(" " + this.user.getUserName() + " ");
        puntosDeControl = ControladorDB.obtenerPuntosDeControlPorOperador(this.user);
        agregarPuntosDeControl();
        ocultarOpciones(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        comBoxPunto = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblErrorPuntos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaquetes = new javax.swing.JTable();
        spinnerHora = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        btnProcesar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblTarifa = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTarifaPaquete = new javax.swing.JLabel();
        lblPaquetes = new javax.swing.JLabel();
        lblRefresh = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuUser = new javax.swing.JMenu();
        menuItemLogOut = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Area De Operacion");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comBoxPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBoxPuntoActionPerformed(evt);
            }
        });
        getContentPane().add(comBoxPunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 12, 165, -1));

        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setText("Puntos De Control:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 17, -1, -1));

        lblErrorPuntos.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblErrorPuntos.setForeground(java.awt.Color.red);
        lblErrorPuntos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorPuntos.setText("No Cuentas Con Puntos De Contol");
        getContentPane().add(lblErrorPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 45, 285, -1));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblPaquetes.setBackground(java.awt.Color.gray);
        tblPaquetes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblPaquetes.setForeground(java.awt.Color.white);
        tblPaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Codigo", "Peso", "Ingreso"
            }
        ));
        tblPaquetes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPaquetesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPaquetes);
        if (tblPaquetes.getColumnModel().getColumnCount() > 0) {
            tblPaquetes.getColumnModel().getColumn(0).setPreferredWidth(35);
            tblPaquetes.getColumnModel().getColumn(0).setMaxWidth(35);
            tblPaquetes.getColumnModel().getColumn(1).setPreferredWidth(105);
            tblPaquetes.getColumnModel().getColumn(1).setMaxWidth(105);
            tblPaquetes.getColumnModel().getColumn(2).setPreferredWidth(105);
            tblPaquetes.getColumnModel().getColumn(2).setMaxWidth(105);
            tblPaquetes.getColumnModel().getColumn(3).setPreferredWidth(145);
            tblPaquetes.getColumnModel().getColumn(3).setMaxWidth(145);
        }

        jScrollPane2.setViewportView(jScrollPane1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 80, 414, 150));

        spinnerHora.setFont(new java.awt.Font("URW Gothic L", 0, 15)); // NOI18N
        spinnerHora.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        getContentPane().add(spinnerHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 348, 71, -1));

        jLabel2.setFont(new java.awt.Font("URW Gothic L", 0, 15)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Horas Para Procesar:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 353, -1, -1));

        btnProcesar.setFont(new java.awt.Font("URW Gothic L", 0, 15)); // NOI18N
        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });
        getContentPane().add(btnProcesar, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 347, -1, -1));

        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Tarifa/Hora(Actual):");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 260, -1, -1));

        lblTarifa.setForeground(java.awt.Color.white);
        lblTarifa.setText("---");
        getContentPane().add(lblTarifa, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 260, 78, -1));

        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Tarifa/Hora(Paquete): ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 324, -1, -1));

        lblTarifaPaquete.setForeground(java.awt.Color.white);
        lblTarifaPaquete.setText("---");
        getContentPane().add(lblTarifaPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 324, 71, -1));

        lblPaquetes.setForeground(java.awt.Color.white);
        lblPaquetes.setText("Paquetes");
        getContentPane().add(lblPaquetes, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 45, 111, -1));

        lblRefresh.setBackground(java.awt.Color.white);
        lblRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Refresh.png"))); // NOI18N
        lblRefresh.setText("-");
        lblRefresh.setOpaque(true);
        lblRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRefreshMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRefreshMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRefreshMouseEntered(evt);
            }
        });
        getContentPane().add(lblRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 248, 40, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/983280.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -23, 440, 430));

        jMenuBar1.setBackground(java.awt.Color.white);
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMenu1.setText("                                                                                             ");
        jMenu1.setEnabled(false);
        jMenuBar1.add(jMenu1);

        menuUser.setBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 3, true));
        menuUser.setForeground(new java.awt.Color(77, 77, 236));
        menuUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogOut_1_1.png"))); // NOI18N
        menuUser.setText(" User ");
        menuUser.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N

        menuItemLogOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        menuItemLogOut.setBackground(java.awt.Color.gray);
        menuItemLogOut.setForeground(java.awt.Color.white);
        menuItemLogOut.setText("Log Out");
        menuItemLogOut.setOpaque(true);
        menuItemLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLogOutActionPerformed(evt);
            }
        });
        menuUser.add(menuItemLogOut);

        jMenuBar1.add(menuUser);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comBoxPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBoxPuntoActionPerformed
        lblErrorPuntos.setText(" ");
        ocultarOpciones(false);
        tarifaActual = ControladorDB.obtenerPreciosPorCodigo(puntosDeControl.get(comBoxPunto.getSelectedIndex()).getCodigo(),
                ControladorDB.TIPO_PRECIO_PUNTO).get(ControladorDB.obtenerPreciosPorCodigo(puntosDeControl.get(comBoxPunto.getSelectedIndex()).getCodigo(),
                        ControladorDB.TIPO_PRECIO_PUNTO).size() - 1).getPrecio();
        lblTarifa.setText(String.format("%6.2f", tarifaActual));
        agregarPaquetes();
        lblPaquetes.setText(paquetesDisponibles.size() + "/" + puntosDeControl.get(comBoxPunto.getSelectedIndex()).getCapacidad() + " Paquetes");
    }//GEN-LAST:event_comBoxPuntoActionPerformed

    private void tblPaquetesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPaquetesMouseClicked
        ocultarOpciones(false);
        lblTarifaPaquete.setText("---");
        if (tblPaquetes.getSelectedRow() >= 0) {
            ocultarOpciones(true);
            paqueteAProcesar = paquetesDisponibles.get(tblPaquetes.getSelectedRow());
            tarifaDePaquete = TransferenciasDB.obtenerTarifaDePaquete(paqueteAProcesar);
            if (tarifaDePaquete == tarifaActual) {
                lblTarifaPaquete.setText("Actual");
            } else {
                lblTarifaPaquete.setText(String.format("%6.2f", tarifaDePaquete));
            }

        }
    }//GEN-LAST:event_tblPaquetesMouseClicked

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        if (paqueteAProcesar.getPunto().getNumero() < ControladorDB.obtenerPuntosPorRuta(paqueteAProcesar.getRuta().getCodigo()).size()) {
            PuntoDeControl puntoSiguiente = TransferenciasDB.obtenerSiguientePunto(paqueteAProcesar.getPunto());
            if (TransferenciasDB.obtenerPaquetesPorPunto(puntoSiguiente.getCodigo()).size() == puntoSiguiente.getCapacidad()) {
                JOptionPane.showMessageDialog(this, "El siguiente punto de control (codigo: " + puntoSiguiente.getCodigo() + ") se encuentra lleno", "Error Al Procesar", JOptionPane.ERROR_MESSAGE);
            } else {
                procesarPaquete();
                JOptionPane.showMessageDialog(this, "El paquete (codigo: " + paqueteAProcesar.getCodigo() + ") llego al siguente punto", "Paquete Procesado Correctamente", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            procesarPaquete();
            JOptionPane.showMessageDialog(this, "El paquete (codigo: " + paqueteAProcesar.getCodigo() + ") llego a su destino", "Paquete Procesado Correctamente", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_btnProcesarActionPerformed

    private void lblRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseClicked
        lblErrorPuntos.setText(" ");
        agregarPaquetes();
                
    }//GEN-LAST:event_lblRefreshMouseClicked

    private void lblRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseEntered
        lblRefresh.setBackground(Color.gray);
    }//GEN-LAST:event_lblRefreshMouseEntered

    private void lblRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseExited
        lblRefresh.setBackground(Color.WHITE);
    }//GEN-LAST:event_lblRefreshMouseExited

    private void menuItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogOutActionPerformed
       IngresoDeUsuario logOut = new IngresoDeUsuario();
       logOut.setVisible(true);
       this.setVisible(false); 
    }//GEN-LAST:event_menuItemLogOutActionPerformed
    private void agregarPuntosDeControl() {
        if (puntosDeControl.size() > 0) {
            for (int i = 0; i < puntosDeControl.size(); i++) {
                comBoxPunto.addItem(String.valueOf(puntosDeControl.get(i).getCodigo()));
            }
        } else {
            lblRefresh.setVisible(false);
            lblErrorPuntos.setText(ERROR_PUNTOS);
            lblErrorPuntos.setVisible(true);
            comBoxPunto.setEnabled(false);
        }

    }

    private void ocultarOpciones(boolean b) {
        spinnerHora.setEnabled(b);
        btnProcesar.setEnabled(b);
        lblTarifaPaquete.setText("---");
    }

    private void procesarPaquete() {
        System.out.println(tarifaDePaquete * (Integer) spinnerHora.getValue());
        user.preocesarPaquete(paqueteAProcesar, tarifaDePaquete * (Integer) spinnerHora.getValue());
        agregarPaquetes();
        ControladorDeBodega nuevo = new ControladorDeBodega();
        new Thread(nuevo).start();

    }

    private void agregarPaquetes() {
        DefaultTableModel model = (DefaultTableModel) tblPaquetes.getModel();
        int aux = model.getRowCount();
        for (int i = aux; i > 0; i--) {
            model.removeRow(i - 1);
        }
        paquetesDisponibles = TransferenciasDB.obtenerPaquetesPorPunto(puntosDeControl.get(comBoxPunto.getSelectedIndex()).getCodigo());
        if (paquetesDisponibles.size() > 0) {

            for (int i = 0; i < paquetesDisponibles.size(); i++) {//Creacion de Celdas
                model.addRow(new Object[]{"", "", "", ""});
                tblPaquetes.setValueAt(paquetesDisponibles.get(i).getNumeroEnCola(), i, 0);
                tblPaquetes.setValueAt(paquetesDisponibles.get(i).getCodigo(), i, 1);

                tblPaquetes.setValueAt(paquetesDisponibles.get(i).getPeso(), i, 2);
                tblPaquetes.setValueAt(paquetesDisponibles.get(i).getFechaIngresado().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")), i, 3);
            }
        } else {
            lblErrorPuntos.setText(ERROR_PAQUETES);
            lblErrorPuntos.setVisible(true);
        }
        lblPaquetes.setText(paquetesDisponibles.size() + "/" + puntosDeControl.get(comBoxPunto.getSelectedIndex()).getCapacidad() + " Paquetes");
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcesar;
    private javax.swing.JComboBox<String> comBoxPunto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblErrorPuntos;
    private javax.swing.JLabel lblPaquetes;
    private javax.swing.JLabel lblRefresh;
    private javax.swing.JLabel lblTarifa;
    private javax.swing.JLabel lblTarifaPaquete;
    private javax.swing.JMenuItem menuItemLogOut;
    private javax.swing.JMenu menuUser;
    private javax.swing.JSpinner spinnerHora;
    private javax.swing.JTable tblPaquetes;
    // End of variables declaration//GEN-END:variables
}
