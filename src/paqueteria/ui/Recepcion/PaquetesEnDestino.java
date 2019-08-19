/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.ui.Recepcion;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import paqueteria.DB.ControladorDB;
import paqueteria.DB.TransferenciasDB;
import paqueteria.paquetes.Paquete;

/**
 *
 * @author sergio
 */
public class PaquetesEnDestino extends javax.swing.JInternalFrame {

    private ArrayList<Paquete> paquetes = new ArrayList<>();

    /**
     * Creates new form PaquetesEnDestino
     */
    public PaquetesEnDestino() {
        initComponents();
        paquetes = ControladorDB.obtenerPaquetesPorEstado(3);
        agregarPaquetesATablas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRetirar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaquetes = new javax.swing.JTable();
        txtBuscadorCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Paquetes Listos Para Retirar");

        btnRetirar.setText("Retirar Paquete");
        btnRetirar.setEnabled(false);
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblError.setForeground(java.awt.Color.red);
        lblError.setText("No Existen Paquetes En Destinos");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblPaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Destino", "Nit Cliente "
            }
        ));
        tblPaquetes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPaquetesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPaquetes);
        if (tblPaquetes.getColumnModel().getColumnCount() > 0) {
            tblPaquetes.getColumnModel().getColumn(0).setPreferredWidth(85);
            tblPaquetes.getColumnModel().getColumn(0).setMaxWidth(85);
        }

        jScrollPane2.setViewportView(jScrollPane1);

        txtBuscadorCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscadorCodigoKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorCodigoKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel1.setText("Buscar Codigo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnRetirar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblError)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtBuscadorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscadorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetirar)
                    .addComponent(btnSalir))
                .addContainerGap())
        );

        lblError.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPaquetesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPaquetesMouseClicked
        if (tblPaquetes.getSelectedRow() >= 0) {
            btnRetirar.setEnabled(true);
        } else {
            btnRetirar.setEnabled(false);
        }
    }//GEN-LAST:event_tblPaquetesMouseClicked

    private void txtBuscadorCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorCodigoKeyReleased
        buscar(txtBuscadorCodigo.getText());
        agregarPaquetesATablas();
    }//GEN-LAST:event_txtBuscadorCodigoKeyReleased

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
        if (tblPaquetes.getSelectedRow()>=0) {
            TransferenciasDB.moverEstadoDePaquete(paquetes.get(tblPaquetes.getSelectedRow()).getCodigo());
            paquetes.remove(tblPaquetes.getSelectedRow());
            agregarPaquetesATablas();
        }
    }//GEN-LAST:event_btnRetirarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtBuscadorCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorCodigoKeyTyped
                char c = evt.getKeyChar();
        if (c<'0' || c>'9')evt.consume();
    }//GEN-LAST:event_txtBuscadorCodigoKeyTyped
    private void agregarPaquetesATablas() {
        btnRetirar.setEnabled(false);
        if (paquetes.isEmpty()) {
            lblError.setVisible(true);
        } else {
            DefaultTableModel model = (DefaultTableModel) tblPaquetes.getModel();
            int aux = model.getRowCount();
            for (int i = aux; i > 0; i--) {
                model.removeRow(i - 1);
            }
            for (int i = 0; i < paquetes.size(); i++) {//Creacion de Celdas
                model.addRow(new Object[]{"", "", "", ""});
                tblPaquetes.setValueAt(paquetes.get(i).getCodigo(), i, 0);
                tblPaquetes.setValueAt(paquetes.get(i).getRuta().getDestino().getNombre(), i, 1);
                if (paquetes.get(i).getCliente().getNit() != 0) {
                    tblPaquetes.setValueAt(paquetes.get(i).getCliente().getNit(), i, 2);
                } else {
                    tblPaquetes.setValueAt("Consumidor Final", i, 2);
                }

            }
        }
    }

    private void buscar(String palabra) {
        if (!"".equals(palabra)) {
            ArrayList<Paquete> aux = new ArrayList<>();
            for (int i = 0; i < paquetes.size(); i++) {
                if (String.valueOf(paquetes.get(i).getCodigo()).startsWith(palabra)) {
                    aux.add(paquetes.get(i));
                }
            }
            boolean auxiliar;
            for (int i = 0; i < paquetes.size(); i++) {
                auxiliar = true;
                for (int j = 0; j < aux.size(); j++) {
                    if (paquetes.get(i) == aux.get(j)) {
                        auxiliar = false;
                    }
                }
                if (auxiliar) {
                    aux.add(paquetes.get(i));
                }
            }
            paquetes = aux;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRetirar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblError;
    private javax.swing.JTable tblPaquetes;
    private javax.swing.JTextField txtBuscadorCodigo;
    // End of variables declaration//GEN-END:variables
}
