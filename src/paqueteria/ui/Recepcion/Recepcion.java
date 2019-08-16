/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.ui.Recepcion;

import paqueteria.Usuario.Recepcionista;

/**
 *
 * @author sergio
 */
public class Recepcion extends javax.swing.JFrame {
private Recepcionista user=null;
    /**
     * Creates new form Recepcion
     * @param user
     */
    public Recepcion(Recepcionista user) {
        this.user=user;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        dskVentana = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuNuevo = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuPreciosDestino = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuPrecios = new javax.swing.JMenuItem();

        jMenu5.setText("jMenu5");

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dskVentana.setBackground(new java.awt.Color(253, 182, 109));

        jMenu1.setText("Paquete");

        menuNuevo.setText("Nuevo");
        menuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(menuNuevo);

        jMenuItem3.setText("Consultar Existente");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Destino");

        jMenuItem1.setText("Paquete Listo");
        jMenu2.add(jMenuItem1);

        menuPreciosDestino.setText("Precios");
        menuPreciosDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPreciosDestinoActionPerformed(evt);
            }
        });
        jMenu2.add(menuPreciosDestino);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Tarifas");

        menuPrecios.setText("Consultar Precios");
        menuPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPreciosActionPerformed(evt);
            }
        });
        jMenu3.add(menuPrecios);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dskVentana, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dskVentana, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoActionPerformed
        IngresoPaquete nuevoPaquete = new IngresoPaquete(this.dskVentana);
        dskVentana.add(nuevoPaquete);
        nuevoPaquete.setVisible(true);
    }//GEN-LAST:event_menuNuevoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPreciosActionPerformed
        PreciosRecepcion verPrecios= new PreciosRecepcion();
        dskVentana.add(verPrecios);
        verPrecios.setVisible(true);
    }//GEN-LAST:event_menuPreciosActionPerformed

    private void menuPreciosDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPreciosDestinoActionPerformed
        PrecioDestino verDestinos = new PrecioDestino();
        dskVentana.add(verDestinos);
        verDestinos.setVisible(true);
    }//GEN-LAST:event_menuPreciosDestinoActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dskVentana;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem menuNuevo;
    private javax.swing.JMenuItem menuPrecios;
    private javax.swing.JMenuItem menuPreciosDestino;
    // End of variables declaration//GEN-END:variables
}
