/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.ui.Administracion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import paqueteria.DB.ControladorDB;
import paqueteria.DB.GeneradorDeCodigos;
import paqueteria.DB.TransferenciasDB;
import paqueteria.Ruta.PuntoDeControl;
import paqueteria.Ruta.Tarifa;
import paqueteria.Usuario.Usuario;

/**
 *
 * @author sergio
 */
public class NuevoPunto extends javax.swing.JInternalFrame {
private int codigo;
private ArrayList<Usuario> operadores= new ArrayList<>();
private float tarifaGlobal;
private float tarifaAEditar;
private NuevaRuta ruta;
private PuntoDeControl puntoDeControl;

private boolean editacion;
    /**
     * Creates new form NuevoPunto
     * @param ruta
     * @param puntosCreados
     */
    public NuevoPunto(NuevaRuta ruta,ArrayList<PuntoDeControl> puntosCreados) {
        this.ruta=ruta;
        editacion=false;
        tarifaGlobal=ControladorDB.obtenerPrecioActuales()[2];
        initComponents();
        esconderErrores();
        codigo=GeneradorDeCodigos.generarCodigoPuntoDeControl(puntosCreados);
        lblCodigoPunto.setText(String.valueOf(codigo));
        mostrarOperadores();
        spinnerTarifa.setValue(tarifaGlobal);
    }
        public NuevoPunto(PuntoDeControl puntoAEditar) {
            this.puntoDeControl=puntoAEditar;
        tarifaAEditar= puntoAEditar.getPrecio().get(puntoAEditar.getPrecio().size() - 1).getPrecio();
        initComponents();
        esconderErrores();
        editacion=true;
        codigo=puntoAEditar.getCodigo();
        lblCodigoPunto.setText(String.valueOf(codigo));
        spinnerCapacidad.setValue(puntoAEditar.getCapacidad());
        lblGlobal.setVisible(false);
        mostrarOperadores();
        cBoxOperador.setSelectedItem(puntoAEditar.getUser().getUserName());
        spinnerTarifa.setValue(tarifaAEditar);
        btnAgregar.setText("Editar");
        btnAgregar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblCodigoPunto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spinnerCapacidad = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        cBoxOperador = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        spinnerTarifa = new javax.swing.JSpinner();
        btnAgregar = new javax.swing.JButton();
        lblErrorTarifa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtErrorOperador = new javax.swing.JTextArea();
        lblGlobal = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Nuevo Punto De Control");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/admi.png"))); // NOI18N

        jLabel1.setText("Codigo Punto:");

        lblCodigoPunto.setText("jLabel2");

        jLabel2.setText("Capacidad De Paquetes :");

        spinnerCapacidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinnerCapacidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerCapacidadStateChanged(evt);
            }
        });

        jLabel3.setText("Operador Encargado:");

        cBoxOperador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxOperadorActionPerformed(evt);
            }
        });

        jLabel4.setText("Tarifa De Operacion:");

        spinnerTarifa.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 0.01f));
        spinnerTarifa.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerTarifaStateChanged(evt);
            }
        });
        spinnerTarifa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spinnerTarifaKeyPressed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblErrorTarifa.setForeground(new java.awt.Color(240, 11, 11));
        lblErrorTarifa.setText("Tarifa Invalida");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        txtErrorOperador.setEditable(false);
        txtErrorOperador.setColumns(20);
        txtErrorOperador.setForeground(new java.awt.Color(240, 11, 11));
        txtErrorOperador.setRows(5);
        txtErrorOperador.setText("No existen Operadores\nDebes Crear: \nun Usuario Operador");
        txtErrorOperador.setMinimumSize(new java.awt.Dimension(141, 41));
        txtErrorOperador.setOpaque(false);
        jScrollPane1.setViewportView(txtErrorOperador);

        lblGlobal.setBackground(java.awt.Color.green);
        lblGlobal.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblGlobal.setForeground(java.awt.Color.green);
        lblGlobal.setText("Tarifa Global");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lblCodigoPunto)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addGap(29, 29, 29))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(36, 36, 36)
                                .addComponent(spinnerTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblErrorTarifa))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(lblGlobal)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerCapacidad))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(68, 68, 68)
                                    .addComponent(cBoxOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3)))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblCodigoPunto))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spinnerCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cBoxOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorTarifa)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGlobal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (editacion) {
            puntoDeControl.setCapacidad((Integer)spinnerCapacidad.getValue());
            puntoDeControl.setUser(ControladorDB.verificarUserName((String)cBoxOperador.getSelectedItem()));
            TransferenciasDB.actualizarPunto(puntoDeControl);
            if (puntoDeControl.getPrecio().get(puntoDeControl.getPrecio().size() - 1).getPrecio()!=(float)spinnerTarifa.getValue()) {
                ControladorDB.guardarPrecioPunto(puntoDeControl,new Tarifa((float)spinnerTarifa.getValue(), LocalDateTime.now()));
            }       
            JOptionPane.showMessageDialog(this,"Punto Codigo: "+puntoDeControl.getCodigo()+" Actualizado","Punto Actualizado", JOptionPane.INFORMATION_MESSAGE);   
            this.setVisible(false);
        }else{
        if (verificarOperador()) {
            ArrayList<Tarifa> nuevaTarifa= new ArrayList<>();
            nuevaTarifa.add(new Tarifa((float)spinnerTarifa.getValue(), LocalDateTime.now()));
            puntoDeControl= new PuntoDeControl(codigo,(Integer)spinnerCapacidad.getValue(),operadores.get(cBoxOperador.getSelectedIndex()), nuevaTarifa);
            ruta.agregarPunto(puntoDeControl);
            JOptionPane.showMessageDialog(this,"codigo: "+ puntoDeControl.getCodigo()  + "   Tarifa : $" + puntoDeControl.getPrecio().get(puntoDeControl.getPrecio().size() - 1).getPrecio(), "Punto De Control Agregado", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void spinnerTarifaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerTarifaStateChanged
        if (editacion) {
            btnAgregar.setEnabled(true);
        }else{
        if ((float)spinnerTarifa.getValue()==tarifaGlobal) {
            lblGlobal.setVisible(true);
        }else{
            lblGlobal.setVisible(false);
        }
        }
    }//GEN-LAST:event_spinnerTarifaStateChanged

    private void spinnerTarifaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spinnerTarifaKeyPressed
        if ((float)spinnerTarifa.getValue()==tarifaGlobal) {
            lblGlobal.setVisible(true);
        }else{
            lblGlobal.setVisible(false);
        }
    }//GEN-LAST:event_spinnerTarifaKeyPressed

    private void spinnerCapacidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerCapacidadStateChanged
        if (editacion) {
            btnAgregar.setEnabled(true);
        }
    }//GEN-LAST:event_spinnerCapacidadStateChanged

    private void cBoxOperadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxOperadorActionPerformed
        if (editacion) {
            if (cBoxOperador.getSelectedItem()!=null) {
                if (cBoxOperador.getSelectedItem()!=puntoDeControl.getUser().getUserName()) {
                btnAgregar.setEnabled(true);
            }
            }
            
            
        }
    }//GEN-LAST:event_cBoxOperadorActionPerformed
private void esconderErrores(){
    lblErrorTarifa.setVisible(false);
    txtErrorOperador.setVisible(false);
}
private void mostrarOperadores(){
    operadores=ControladorDB.obtenerUsuarioPorJerarquia(2);
    if (operadores.isEmpty()) {
        btnAgregar.setEnabled(false);
        txtErrorOperador.setVisible(true);
    }
    for (int i = 0; i < operadores.size(); i++) {
        cBoxOperador.addItem(operadores.get(i).getUserName());
        
    }
}
private boolean verificarOperador(){
    return operadores.size()>0;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> cBoxOperador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigoPunto;
    private javax.swing.JLabel lblErrorTarifa;
    private javax.swing.JLabel lblGlobal;
    private javax.swing.JSpinner spinnerCapacidad;
    private javax.swing.JSpinner spinnerTarifa;
    private javax.swing.JTextArea txtErrorOperador;
    // End of variables declaration//GEN-END:variables
}
