/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.ui.Administracion;

import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import paqueteria.DB.ControladorDB;
import paqueteria.Ruta.Destino;
import paqueteria.DB.GeneradorDeCodigos;
import paqueteria.DB.TransferenciasDB;
import paqueteria.Ruta.PuntoDeControl;
import paqueteria.Ruta.Ruta;

/**
 *
 * @author sergio
 */
public class NuevaRuta extends javax.swing.JInternalFrame {

    private JDesktopPane panel;
    private Destino destino;
    private ArrayList<Destino> destinosPosibles;
    private ArrayList<PuntoDeControl> puntos;
    private int codigoRuta;
    private Ruta rutaAEditar;
    private boolean editacion;

    /**
     * Creates new form NuevaRuta
     *
     * @param panel
     */
    //Cuando se desee Crear una ruta nueva
    public NuevaRuta(JDesktopPane panel) {
        editacion = false;
        puntos = new ArrayList<>();
        this.panel = panel;
        initComponents();
        desabilitarOpciones(false);
        codigoRuta = GeneradorDeCodigos.generarCodigoRuta();
        lblCodigoRuta.setText(String.valueOf(codigoRuta));
        mostrarDestinos();
    }
//Cuando se desee editar una ruta
    public NuevaRuta(JDesktopPane panel, Ruta ruta) {
        editacion = true;
        this.panel = panel;
        this.rutaAEditar = ruta;
        puntos = rutaAEditar.getPuntos();
        initComponents();
        desabilitarOpciones(false);
        codigoRuta = rutaAEditar.getCodigo();
        mostrarElementosDeEditacion();
        agregarPuntosATabla();
    }
//Muestra los botones que utilizamos para editar
    private void mostrarElementosDeEditacion() {
        lblCodigoRuta.setText(String.valueOf(codigoRuta));
        cBoxDestinos.addItem(rutaAEditar.getDestino().getCodigo() + "-" + String.valueOf(rutaAEditar.getDestino().getNombre()));
        lblCoutaDestino.setText(String.valueOf(rutaAEditar.getDestino().getPrecio().get(rutaAEditar.getDestino().getPrecio().size() - 1).getPrecio()));
        cBoxDestinos.setEnabled(false);
        btnNuevoDestino.setVisible(false);
        btnRuta.setEnabled(false);
        btnRuta.setText("Actualizar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cBoxDestinos = new javax.swing.JComboBox<>();
        btnNuevoDestino = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnAgregarPunto = new javax.swing.JButton();
        labelCodigo = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        lblPosicion = new javax.swing.JLabel();
        spinnerPosicion = new javax.swing.JSpinner();
        btnRuta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblCodigoRuta = new javax.swing.JLabel();
        lblCoutaDestino = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPuntos = new javax.swing.JTable();
        lblErrorDestino = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Creacion De Rutas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/admi.png"))); // NOI18N

        jLabel1.setText("Destino:");

        cBoxDestinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxDestinosActionPerformed(evt);
            }
        });

        btnNuevoDestino.setText("Nuevo Destino");
        btnNuevoDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoDestinoActionPerformed(evt);
            }
        });

        jLabel2.setText("Puntos De Control:");

        btnAgregarPunto.setText("+ Punto De Control");
        btnAgregarPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPuntoActionPerformed(evt);
            }
        });

        labelCodigo.setBackground(new java.awt.Color(254, 254, 254));
        labelCodigo.setText("Codigo:");
        labelCodigo.setOpaque(true);

        lblCodigo.setBackground(new java.awt.Color(254, 254, 254));
        lblCodigo.setOpaque(true);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblPosicion.setBackground(new java.awt.Color(254, 254, 254));
        lblPosicion.setText("Posicion:");
        lblPosicion.setOpaque(true);

        spinnerPosicion.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        spinnerPosicion.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinnerPosicion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerPosicionStateChanged(evt);
            }
        });
        spinnerPosicion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spinnerPosicionMouseClicked(evt);
            }
        });

        btnRuta.setText("Crear Ruta");
        btnRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutaActionPerformed(evt);
            }
        });

        jLabel3.setText("Codigo Ruta:");

        lblCoutaDestino.setBackground(java.awt.Color.white);
        lblCoutaDestino.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCoutaDestino.setText("0");
        lblCoutaDestino.setOpaque(true);

        jLabel5.setText("Couta");

        jLabel4.setText("Codigo - Nombre");

        tblPuntos.setBackground(new java.awt.Color(214, 224, 253));
        tblPuntos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 4, 78), 1, true));
        tblPuntos.setForeground(new java.awt.Color(1, 1, 1));
        tblPuntos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orden", "Codigo", "Capacidad (Packs)", "Operador", "Tarifa"
            }
        ));
        tblPuntos.setGridColor(new java.awt.Color(1, 1, 1));
        tblPuntos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPuntosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPuntos);

        jScrollPane1.setViewportView(jScrollPane3);

        lblErrorDestino.setText("Debes Elejir Un Destino");
        lblErrorDestino.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCodigoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cBoxDestinos, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCoutaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnNuevoDestino)
                                        .addGap(36, 36, 36)
                                        .addComponent(lblErrorDestino))))
                            .addComponent(btnAgregarPunto, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPosicion)
                                            .addComponent(labelCodigo))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(spinnerPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(btnEliminar))
                                    .addComponent(btnRuta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(lblCodigoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnNuevoDestino)
                                        .addComponent(lblErrorDestino))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cBoxDestinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblCoutaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(btnAgregarPunto))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCodigo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spinnerPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPosicion))
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(btnRuta))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPuntoActionPerformed
        NuevoPunto nuevo = new NuevoPunto(this, puntos);
        panel.add(nuevo);
        nuevo.setVisible(true);
        desabilitarOpciones(false);
    }//GEN-LAST:event_btnAgregarPuntoActionPerformed

    private void cBoxDestinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxDestinosActionPerformed
        if (destinosPosibles != null) {
            Destino destinoAux = destinosPosibles.get(cBoxDestinos.getSelectedIndex());
            destino = destinoAux;
            lblCoutaDestino.setText("$" + String.format("%6.2f", destinoAux.getPrecio().get(destinoAux.getPrecio().size() - 1).getPrecio()));
        }

    }//GEN-LAST:event_cBoxDestinosActionPerformed

    private void btnNuevoDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoDestinoActionPerformed
        NuevoDestino nuevoDestino = new NuevoDestino(this);
        panel.add(nuevoDestino);
        nuevoDestino.setVisible(true);
        desabilitarOpciones(false);
    }//GEN-LAST:event_btnNuevoDestinoActionPerformed

    private void tblPuntosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPuntosMouseClicked
        int row = tblPuntos.getSelectedRow();
        if (row >= 0) {
            desabilitarOpciones(true);
            lblCodigo.setText(String.valueOf(puntos.get(row).getCodigo()));
            spinnerPosicion.setModel(new javax.swing.SpinnerNumberModel(row + 1, 1, puntos.size(), 1));
        } else {
            desabilitarOpciones(false);
        }
    }//GEN-LAST:event_tblPuntosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        puntos.remove(tblPuntos.getSelectedRow());
        agregarPuntosATabla();
        desabilitarOpciones(false);
        if (editacion) {
            btnRuta.setEnabled(true);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void spinnerPosicionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spinnerPosicionMouseClicked
        PuntoDeControl Aux = puntos.get((Integer) spinnerPosicion.getValue() - 1);
        puntos.set((Integer) spinnerPosicion.getValue() - 1, puntos.get(tblPuntos.getSelectedRow()));
        puntos.set(tblPuntos.getSelectedRow(), Aux);
        agregarPuntosATabla();
    }//GEN-LAST:event_spinnerPosicionMouseClicked

    private void spinnerPosicionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerPosicionStateChanged
        if (editacion) {
            btnRuta.setEnabled(true);
        }
        PuntoDeControl Aux = puntos.get((Integer) spinnerPosicion.getValue() - 1);
        puntos.set((Integer) spinnerPosicion.getValue() - 1, puntos.get(tblPuntos.getSelectedRow()));
        puntos.set(tblPuntos.getSelectedRow(), Aux);
        agregarPuntosATabla();
        tblPuntos.setRowSelectionInterval((Integer) spinnerPosicion.getValue() - 1, (Integer) spinnerPosicion.getValue() - 1);

    }//GEN-LAST:event_spinnerPosicionStateChanged

    private void btnRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutaActionPerformed
        if (editacion) {
            for (int i = 0; i < puntos.size(); i++) {
                puntos.get(i).setNumero(1 + i);
                puntos.get(i).setCodigoRuta(codigoRuta);
            }
            TransferenciasDB.actualizarPuntos(codigoRuta, puntos);
        } else {
            lblErrorDestino.setVisible(false);
            if (destino != null) {
                for (int i = 0; i < puntos.size(); i++) {
                    puntos.get(i).setNumero(1 + i);
                    puntos.get(i).setCodigoRuta(codigoRuta);
                }
                Ruta nuevaRuta = new Ruta(codigoRuta, true, destino, puntos);
                ControladorDB.guardarRuta(nuevaRuta);
                JOptionPane.showMessageDialog(this, "Codigo: " + nuevaRuta.getCodigo() + "   Destino: " + nuevaRuta.getDestino().getNombre(), "Ruta Creada", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
            } else {
                lblErrorDestino.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnRutaActionPerformed

    private void desabilitarOpciones(boolean b) {
        lblCodigo.setVisible(b);
        lblPosicion.setVisible(b);
        btnEliminar.setVisible(b);
        labelCodigo.setVisible(b);
        spinnerPosicion.setVisible(b);

    }
//Muestra todos los destinos posibles a escojer
    private void mostrarDestinos() {
        destinosPosibles = ControladorDB.obtenerDestino();
        if (destinosPosibles != null) {
            for (int i = 0; i < destinosPosibles.size(); i++) {
                cBoxDestinos.addItem(String.valueOf(destinosPosibles.get(i).getCodigo()) + " - " + destinosPosibles.get(i).getNombre());
            }
        } else {
            cBoxDestinos.setEnabled(false);
        }
    }
//Agrega un siguiente punto de la ruta
    protected void agregarPunto(PuntoDeControl puntoNuevo) {
        puntos.add(puntoNuevo);
        agregarPuntosATabla();
        if (editacion) {
            btnRuta.setEnabled(true);
        }
    }
//Agrega el destino de la ruta
    protected void agregarDestino(Destino destino) {
        this.destino = destino;
        destinosPosibles.add(destino);
        cBoxDestinos.addItem(destino.getCodigo() + " - " + destino.getNombre());
        cBoxDestinos.setSelectedIndex(destinosPosibles.size() - 1);
    }
//Muestra todos los puntos creados para la tabla
    private void agregarPuntosATabla() {
        DefaultTableModel model = (DefaultTableModel) tblPuntos.getModel();
        int aux = model.getRowCount();
        for (int i = aux; i > 0; i--) {
            model.removeRow(i - 1);

        }
        for (int i = 0; i < puntos.size(); i++) {//Creacion de Celdas
            model.addRow(new Object[]{"", "", "", "", ""});
            tblPuntos.setValueAt(1 + i, i, 0);
            tblPuntos.setValueAt(puntos.get(i).getCodigo(), i, 1);
            tblPuntos.setValueAt(puntos.get(i).getCapacidad(), i, 2);
            tblPuntos.setValueAt(puntos.get(i).getUser().getUserName(), i, 3);
            tblPuntos.setValueAt("$" + String.format("%6.2f", puntos.get(i).getPrecio().get(puntos.get(i).getPrecio().size() - 1).getPrecio()), i, 4);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPunto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevoDestino;
    private javax.swing.JButton btnRuta;
    private javax.swing.JComboBox<String> cBoxDestinos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigoRuta;
    private javax.swing.JLabel lblCoutaDestino;
    private javax.swing.JLabel lblErrorDestino;
    private javax.swing.JLabel lblPosicion;
    private javax.swing.JSpinner spinnerPosicion;
    private javax.swing.JTable tblPuntos;
    // End of variables declaration//GEN-END:variables
}
