/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.ui.Administracion;

import java.awt.Color;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import paqueteria.DB.ControladorDB;
import paqueteria.DB.TransferenciasDB;
import paqueteria.Ruta.Ruta;

/**
 *
 * @author sergio
 */
public class GraficaGanancias extends javax.swing.JInternalFrame {
private float ingresos=0;
private float costos=0;
    /**
     * Creates new form GraficaGanancias
     */
    public GraficaGanancias() {
        initComponents();
        obtenerEstadisticas();
        mostrarEstadisticas();
        DefaultCategoryDataset categoria = new DefaultCategoryDataset();
        String ganancias ="Ganancias";
        String perdidas = "Perdidas";
        categoria.setValue(costos, perdidas,"Costos");
        categoria.setValue(ingresos, ganancias,"Ingresos");
        
        JFreeChart f = ChartFactory.createBarChart("Ganancias"," ","Dolares($)", categoria,PlotOrientation.VERTICAL,true,false,false);
        ChartPanel fa = new ChartPanel(f);
        panel.add(fa);
        fa.setVisible(true);
        fa.setSize(300,300);
        fa.setLocation(10,10);
        
        
    }
private void obtenerEstadisticas(){
    ArrayList<Ruta> rutasAux = ControladorDB.obtenerRutas();
    for (int i = 0; i < rutasAux.size(); i++) {
        ingresos= ingresos+TransferenciasDB.obtenerGananciasPorRuta(rutasAux.get(i).getCodigo());
        costos= costos+TransferenciasDB.obtenerPerdidaPorRuta(rutasAux.get(i).getCodigo());
        
    }
}
private void mostrarEstadisticas(){
    lblIngresos.setText("$"+String.format("%6.2f",ingresos));
    lblCostos.setText("$"+String.format("%6.2f",costos));
    float ganancia = ingresos-costos;
    float porcentaje=(ganancia*100)/costos;
    lblPorcentaje.setText(String.format("%6.2f",porcentaje)+"%");
    if (porcentaje>0) {
        lblPorcentaje.setForeground(Color.blue);
    }else{
        lblPorcentaje.setForeground(Color.red);
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPorcentaje = new javax.swing.JLabel();
        lblCostos = new javax.swing.JLabel();
        lblIngresos = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Ganancias");

        panel.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setForeground(java.awt.Color.blue);
        jLabel1.setText("Ingresos:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setForeground(java.awt.Color.red);
        jLabel2.setText("Costos");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setText("Ganacia:");

        lblPorcentaje.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        lblPorcentaje.setForeground(java.awt.Color.black);
        lblPorcentaje.setText("jLabel4");

        lblCostos.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblCostos.setForeground(java.awt.Color.red);
        lblCostos.setText("----");

        lblIngresos.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblIngresos.setForeground(java.awt.Color.blue);
        lblIngresos.setText("----");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblIngresos))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCostos)
                            .addComponent(lblPorcentaje)))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblIngresos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblCostos))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblPorcentaje))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCostos;
    private javax.swing.JLabel lblIngresos;
    private javax.swing.JLabel lblPorcentaje;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}