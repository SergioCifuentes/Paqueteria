/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.ui.Recepcion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import paqueteria.DB.ControladorDB;
import paqueteria.paquetes.Paquete;

/**
 *
 * @author sergio
 */
public class ConsultaDePaquete extends javax.swing.JInternalFrame {

    private Paquete paqueteAConsultar;
    private static final String ERROR_PAQUETE = "Paquete No Existente";
    private static final String ERROR_PAQUETE2 = "Paquete Ya Fue Retirado";

    /**
     * Creates new form ConsultaDePaquete
     */
    public ConsultaDePaquete() {
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

        progressBarPaquete = new javax.swing.JProgressBar();
        txtBuscadorPaquete = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblLocalizacion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDestino = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        lblDescripcionProgreso = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Consulta De Paquete");

        progressBarPaquete.setBackground(java.awt.Color.white);
        progressBarPaquete.setForeground(java.awt.Color.orange);
        progressBarPaquete.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.orange, 2));

        txtBuscadorPaquete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtBuscadorPaqueteMouseReleased(evt);
            }
        });
        txtBuscadorPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorPaqueteActionPerformed(evt);
            }
        });
        txtBuscadorPaquete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscadorPaqueteKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorPaqueteKeyReleased(evt);
            }
        });

        jLabel1.setText("Ingrese El Codigo Del Paquete:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblError.setForeground(java.awt.Color.red);
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setText("Error");
        lblError.setVisible(false);

        jLabel2.setFont(new java.awt.Font("URW Gothic L", 0, 17)); // NOI18N
        jLabel2.setForeground(java.awt.Color.black);
        jLabel2.setText("Localizacion:");

        lblLocalizacion.setFont(new java.awt.Font("URW Gothic L", 0, 17)); // NOI18N
        lblLocalizacion.setForeground(java.awt.Color.black);
        lblLocalizacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLocalizacion.setText("---");

        jLabel3.setFont(new java.awt.Font("URW Gothic L", 0, 17)); // NOI18N
        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setText("Destino:");

        lblDestino.setFont(new java.awt.Font("URW Gothic L", 0, 17)); // NOI18N
        lblDestino.setForeground(java.awt.Color.black);
        lblDestino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDestino.setText("-----");

        jLabel4.setFont(new java.awt.Font("URW Gothic L", 0, 17)); // NOI18N
        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setText("Fecha De Ingreso:");

        lblFecha.setFont(new java.awt.Font("URW Gothic L", 0, 17)); // NOI18N
        lblFecha.setForeground(java.awt.Color.black);
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("--/--/----");

        jLabel6.setFont(new java.awt.Font("URW Gothic L", 0, 17)); // NOI18N
        jLabel6.setForeground(java.awt.Color.black);
        jLabel6.setText("Tiempo Transcurrido:");

        lblTiempo.setFont(new java.awt.Font("URW Gothic L", 0, 17)); // NOI18N
        lblTiempo.setForeground(java.awt.Color.black);
        lblTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTiempo.setText("-----");

        lblDescripcionProgreso.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        lblDescripcionProgreso.setForeground(new java.awt.Color(217, 171, 1));
        lblDescripcionProgreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescripcionProgreso.setText("---");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscadorPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(lblTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcionProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(progressBarPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscadorPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblLocalizacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblDestino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblTiempo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(lblDescripcionProgreso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBarPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        lblError.setVisible(false);
        resetearLabels();
        paqueteAConsultar = ControladorDB.verificarPaquete(Integer.parseInt(txtBuscadorPaquete.getText()));
        if (paqueteAConsultar == null) {
            lblError.setText(ERROR_PAQUETE);
            lblError.setVisible(true);
        } else {
            if (paqueteAConsultar.getEstado() == 4) {
                lblError.setText(ERROR_PAQUETE2);
                lblError.setVisible(true);
            } else {
                agregarDatosPaquete();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBuscadorPaqueteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscadorPaqueteMouseReleased

    }//GEN-LAST:event_txtBuscadorPaqueteMouseReleased

    private void txtBuscadorPaqueteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorPaqueteKeyReleased

    }//GEN-LAST:event_txtBuscadorPaqueteKeyReleased

    private void txtBuscadorPaqueteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorPaqueteKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscadorPaqueteKeyTyped

    private void txtBuscadorPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorPaqueteActionPerformed
                lblError.setVisible(false);
        resetearLabels();
        paqueteAConsultar = ControladorDB.verificarPaquete(Integer.parseInt(txtBuscadorPaquete.getText()));
        if (paqueteAConsultar == null) {
            lblError.setText(ERROR_PAQUETE);
            lblError.setVisible(true);
        } else {
            if (paqueteAConsultar.getEstado() == 4) {
                lblError.setText(ERROR_PAQUETE2);
                lblError.setVisible(true);
            } else {
                agregarDatosPaquete();
            }
        }
    }//GEN-LAST:event_txtBuscadorPaqueteActionPerformed
    private String convertirHorasEDias(int horas) {
         int dias = horas/24;
         horas= horas-dias*24;
         return dias+" Dias y "+horas+" Horas";
    }

    private void agregarDatosPaquete() {
        int numeroDePuntosEnRuta = paqueteAConsultar.getRuta().getPuntos().size();
        progressBarPaquete.setMaximum(numeroDePuntosEnRuta);
        switch (paqueteAConsultar.getEstado()) {
            case 1:
                progressBarPaquete.setValue(0);
                lblLocalizacion.setText("Bodega");
                lblDescripcionProgreso.setText("Bodega 0/"+numeroDePuntosEnRuta+" Puntos De Control");
                break;
            case 3:                
                progressBarPaquete.setValue(numeroDePuntosEnRuta);
                lblDescripcionProgreso.setText("Listo! " +numeroDePuntosEnRuta+"/"+numeroDePuntosEnRuta+" Puntos De Control");
                break;
            default:
                progressBarPaquete.setValue(paqueteAConsultar.getPunto().getNumero()-1);
                lblDescripcionProgreso.setText("En Camino " +(paqueteAConsultar.getPunto().getNumero()-1)+"/"+numeroDePuntosEnRuta+" Puntos De Control");
                lblLocalizacion.setText("Punto De Control # " + paqueteAConsultar.getPunto().getCodigo());
                break;
        }
        lblDestino.setText(paqueteAConsultar.getRuta().getDestino().getNombre());

        lblFecha.setText(paqueteAConsultar.getFechaIngresado().format(DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm")));
        int horas = calcularTiempoTrascurrido();
        if (horas > 24) {
            lblTiempo.setText(convertirHorasEDias(horas));
        } else {
            lblTiempo.setText(horas + " horas");
        }

    }
private void resetearLabels(){
    lblDescripcionProgreso.setText("---");
    lblDestino.setText("----");
    lblError.setText("");
    lblFecha.setText("--/--/----");
    lblLocalizacion.setText("---");
    lblTiempo.setText("----");
}
    private int calcularTiempoTrascurrido() {
        LocalDateTime inicio = paqueteAConsultar.getFechaIngresado();
        LocalDateTime finalizo = LocalDateTime.now();
        int horas = 0;
        while (inicio.isBefore(finalizo) || inicio.equals(finalizo)) {
            horas++;
            inicio = inicio.plusHours(1);
        }
        return horas;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblDescripcionProgreso;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblLocalizacion;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JProgressBar progressBarPaquete;
    private javax.swing.JTextField txtBuscadorPaquete;
    // End of variables declaration//GEN-END:variables
}
