/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.ui.Recepcion;

import java.util.ArrayList;
import paqueteria.DB.ControladorDB;
import paqueteria.Ruta.Destino;

/**
 *
 * @author sergio
 */
public class PrecioDestino extends javax.swing.JInternalFrame {
    ArrayList<Destino> destinosPosibles;
    /**
     * Creates new form PrecioDestino
     */
    public PrecioDestino() {
        initComponents();
        mostrarDestinos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        cBoxDestinos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Precios Por Destino");

        btnSalir.setForeground(new java.awt.Color(8, 1, 1));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        cBoxDestinos.setForeground(new java.awt.Color(1, 1, 1));
        cBoxDestinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxDestinosActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(254, 254, 254));
        jLabel1.setForeground(new java.awt.Color(8, 1, 1));
        jLabel1.setText("Precio");
        jLabel1.setOpaque(true);

        lblPrecio.setBackground(new java.awt.Color(254, 254, 254));
        lblPrecio.setForeground(new java.awt.Color(8, 1, 1));
        lblPrecio.setOpaque(true);

        lblError.setForeground(java.awt.Color.red);
        lblError.setText("No Existen Destinos");
        lblError.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cBoxDestinos, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblError)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBoxDestinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblError)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cBoxDestinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxDestinosActionPerformed
        if (destinosPosibles!=null) {
            Destino destinoAux=destinosPosibles.get(cBoxDestinos.getSelectedIndex());
            lblPrecio.setText("$"+String.format("%6.2f",destinoAux.getPrecio().get(destinoAux.getPrecio().size()-1).getPrecio()));
        }
    }//GEN-LAST:event_cBoxDestinosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed
private void mostrarDestinos(){
    destinosPosibles=ControladorDB.obtenerDestino();
    if (destinosPosibles!=null) {
        for (int i = 0; i < destinosPosibles.size(); i++) {
            cBoxDestinos.addItem(String.valueOf(destinosPosibles.get(i).getCodigo())+" - "+destinosPosibles.get(i).getNombre());            
        }
    }else{
        cBoxDestinos.setEnabled(false);
        lblError.setVisible(true);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cBoxDestinos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblPrecio;
    // End of variables declaration//GEN-END:variables
}
