 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.ui.Recepcion;

/**
 *
 * @author sergio
 */
public class AyudaRecepcion extends javax.swing.JInternalFrame {

    /**
     * Creates new form AyudaRecepcion
     */
    public AyudaRecepcion() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Ayuda");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/recepcion.jpeg"))); // NOI18N

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(252, 208, 51));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("URW Gothic L", 0, 15)); // NOI18N
        jTextArea1.setForeground(java.awt.Color.black);
        jTextArea1.setRows(5);
        jTextArea1.setText("\tRECEPCION:\n\n[Paquete] : Aqui podemos registrar envios\nque nuestro cliente desee ingresar ademas\nde poder hacer consultas de paquetes\nya ingresados del sistema\n\n[Destinos] En este menu tenemos la opcion \nde retirar paquetes que ya se encuentran \nen su destino ademos de consultar los \nprecios de cada destino.\n\n(Tarifas) Tenemos la posibidad de ver el\nprecio por libra y el de priorizacion.");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
