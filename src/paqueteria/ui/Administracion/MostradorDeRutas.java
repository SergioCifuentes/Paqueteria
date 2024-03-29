/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.ui.Administracion;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import paqueteria.DB.ControladorDB;
import paqueteria.DB.TransferenciasDB;
import paqueteria.Ruta.Ruta;
import paqueteria.paquetes.Paquete;

/**
 *
 * @author sergio
 */
public class MostradorDeRutas extends javax.swing.JInternalFrame {

    private ArrayList<Ruta> rutas;
    protected static final String IDENTIFICADO_EDITADOR = "Editar";
    protected static final String IDENTIFICADO_DESACTIVADOR = "Desactivar";
    protected static final String IDENTIFICADO_IMAGEN = "Imagen";
    private String tipo;
        private JDesktopPane panel ;
    private ArrayList<Paquete> paquetesEnRuta;

    /**
     * Creates new form MostradorDeRutas
     *
     * @param tipo
     * @param panel
     */
    public MostradorDeRutas(String tipo , JDesktopPane panel) {
        this.panel=panel;
        initComponents();
        paquetesEnRuta = new ArrayList<>(); 
            agregarRutas();
        this.tipo = tipo;
        btnAccion.setText(tipo);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAccion = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRuta = new javax.swing.JTable();
        lblErrorRutas = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Rutas Existentes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/admi.png"))); // NOI18N

        btnAccion.setText("Boton");
        btnAccion.setEnabled(false);
        btnAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccionActionPerformed(evt);
            }
        });

        tblRuta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo ", "Estado", "Destino", "Puntos De Control", "Paquetes En Ruta"
            }
        ));
        tblRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRutaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRuta);

        jScrollPane2.setViewportView(jScrollPane1);

        lblErrorRutas.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorRutas.setText("Rutas No Existentes");
        lblErrorRutas.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblErrorRutas)
                        .addGap(36, 36, 36)
                        .addComponent(btnAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccion)
                    .addComponent(lblErrorRutas))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblRutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRutaMouseClicked
        paquetesEnRuta = TransferenciasDB.obtenerPaquetesActivosPorRuta(rutas.get(tblRuta.getSelectedRow()).getCodigo());
        if (tblRuta.getSelectedRow() >= 0) {
            btnAccion.setEnabled(true);
            if (tipo.equals(IDENTIFICADO_DESACTIVADOR)) {
                if (rutas.get(tblRuta.getSelectedRow()).isEstado()) {
                    btnAccion.setText(tipo);
                } else {
                    btnAccion.setText("Activar");
                }
            }
        } else {
            btnAccion.setEnabled(false);
        }
    }//GEN-LAST:event_tblRutaMouseClicked

    private void btnAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionActionPerformed
        Ruta rutaACAmbiar = rutas.get(tblRuta.getSelectedRow());
        //En caso de que se desee desactivar
        if (tipo.equals(IDENTIFICADO_DESACTIVADOR)) {
            if (paquetesEnRuta.isEmpty()) {
                if (rutaACAmbiar.isEstado()) {
                    TransferenciasDB.cambiarEstadoRuta(rutaACAmbiar.getCodigo(), 0);
                    JOptionPane.showMessageDialog(this, "Ruta codigo: " + rutaACAmbiar.getCodigo() + " Desactivada", "Ruta Desactivada ", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    TransferenciasDB.cambiarEstadoRuta(rutaACAmbiar.getCodigo(), 1);
                    JOptionPane.showMessageDialog(this, "Ruta codigo: " + rutaACAmbiar.getCodigo() + " Activada", "Ruta Activada ", JOptionPane.INFORMATION_MESSAGE);
                }
                agregarRutas();

            } else {
                JOptionPane.showMessageDialog(this, "Esta Ruta Cuenta Con Paquetes", "Error Al Desactivar", JOptionPane.ERROR_MESSAGE);
            }
            //En caso de querer editar
        } else if(tipo.equals(IDENTIFICADO_EDITADOR)){
            if (paquetesEnRuta.isEmpty()) {
                NuevaRuta editarRuta = new NuevaRuta(panel, rutaACAmbiar);
                panel.add(editarRuta);
                this.setVisible(false);
                editarRuta.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Esta Ruta Cuenta Con Paquetes", "Error Al Editar", JOptionPane.ERROR_MESSAGE);
            }
            //En caso de querer su imagen
        }else{
            try {
                GeneradorGraphviz.generar(rutaACAmbiar);
            } catch (IOException ex) {
                System.out.println("Error Al Hacer Imagen");
            }
            JOptionPane.showMessageDialog(this, "Puedes encontrar el imagen en la carpeta 'Reportes'", "Imagen Creado", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnAccionActionPerformed
//Muetra los datos de todas las rutas posibles que existan    
    private void agregarRutas() {
        rutas = ControladorDB.obtenerRutas();
        if (rutas.size()>0) {
            DefaultTableModel model = (DefaultTableModel) tblRuta.getModel();
        int aux = model.getRowCount();
        for (int i = aux; i > 0; i--) {
            model.removeRow(i - 1);
        }
        for (int i = 0; i < rutas.size(); i++) {//Creacion de Celdas
            model.addRow(new Object[]{"", "", "", ""});
            tblRuta.setValueAt(rutas.get(i).getCodigo(), i, 0);
            if (rutas.get(i).isEstado()) {
                tblRuta.setValueAt("Activado", i, 1);
            } else {
                tblRuta.setValueAt("Desactivado", i, 1);
            }

            tblRuta.setValueAt(rutas.get(i).getDestino().getNombre(), i, 2);
            tblRuta.setValueAt(rutas.get(i).getPuntos().size(), i, 3);

            paquetesEnRuta = TransferenciasDB.obtenerPaquetesActivosPorRuta(rutas.get(i).getCodigo());
            tblRuta.setValueAt(paquetesEnRuta.size(), i, 4);
        }
        }else{
            lblErrorRutas.setVisible(true);
        }
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblErrorRutas;
    private javax.swing.JTable tblRuta;
    // End of variables declaration//GEN-END:variables
}
