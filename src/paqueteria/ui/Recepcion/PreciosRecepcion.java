/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.ui.Recepcion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import paqueteria.DB.ControladorDB;

/**
 *
 * @author sergio
 */
public class PreciosRecepcion extends javax.swing.JInternalFrame {
    private LocalDateTime fechaActualizada;
    private float porLibra;
    private float porPriorizacion;
    /**
     * Creates new form PreciosRecepcion
     */
    public PreciosRecepcion() {
        initComponents();
        obtenerPreciosYFecha();
        mostrarPrecios();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblPrecioLibra = new javax.swing.JLabel();
        lblPriorizacion = new javax.swing.JLabel();

        setBackground(new java.awt.Color(186, 186, 186));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Precios De Recepcion");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(254, 254, 254));
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Precio Por Libra:");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(254, 254, 254));
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Precio Por Priorizacion:");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(254, 254, 254));
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Fecha:");
        jLabel3.setOpaque(true);

        lblFecha.setBackground(new java.awt.Color(254, 254, 254));
        lblFecha.setForeground(new java.awt.Color(1, 1, 1));
        lblFecha.setOpaque(true);

        lblPrecioLibra.setBackground(new java.awt.Color(254, 254, 254));
        lblPrecioLibra.setForeground(new java.awt.Color(1, 1, 1));
        lblPrecioLibra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrecioLibra.setOpaque(true);

        lblPriorizacion.setBackground(new java.awt.Color(254, 254, 254));
        lblPriorizacion.setForeground(new java.awt.Color(1, 1, 1));
        lblPriorizacion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPriorizacion.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPrecioLibra, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(lblPriorizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 68, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrecioLibra, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPriorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void obtenerPreciosYFecha() {
        float[] precios = ControladorDB.obtenerPrecioActuales();
        porLibra = precios[0];
        porPriorizacion = precios[1];
        fechaActualizada = ControladorDB.obtenerFechaDePrecioActuales();
    }
    private void mostrarPrecios(){
        lblFecha.setText(String.valueOf(fechaActualizada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"))));
        lblPrecioLibra.setText("$"+String.format("%6.2f",porLibra));
        lblPriorizacion.setText("$"+String.format("%6.2f",porPriorizacion));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblPrecioLibra;
    private javax.swing.JLabel lblPriorizacion;
    // End of variables declaration//GEN-END:variables
}
