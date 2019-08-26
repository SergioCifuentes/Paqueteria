/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.ui.Administracion;

import javax.swing.JOptionPane;
import paqueteria.DB.ControladorDB;
import paqueteria.Usuario.Usuario;

/**
 *
 * @author sergio
 */
public class NuevoUsuario extends javax.swing.JInternalFrame {

    private final static String DIGITOS_INSUFICIENTES = "Digitos Minimos: ";
    private final static String ERROR_USER_YA_EXISTENTE = "Usuario Ya Existe";
    private final static String PASSWOR_NO_CONCUERDA = "Password No Concuerda";
    private final static String ERROR_CAMPO_NO_LLENADO = "*Campo No Llenado";
    private final static int DIGITOS_USUARIO = 5;
    private final static int DIGITOS_PASSWORD = 8;

    /**
     * Creates new form NuevoUsuario
     */
    public NuevoUsuario() {
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

        txtUserName = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        confirmacion = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblErrorUser = new javax.swing.JLabel();
        lblErrorPassword = new javax.swing.JLabel();
        lblErrorConfirmacion = new javax.swing.JLabel();
        comBoxJerarquias = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setForeground(new java.awt.Color(1, 1, 1));
        setIconifiable(true);
        setTitle("Sign In");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/admi.png"))); // NOI18N
        setVisible(true);

        jLabel1.setText("Password:");

        jLabel2.setText("Confirmar Password:");

        jLabel3.setText("User Name:");

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dar-de-alta-empresa_1.png"))); // NOI18N
        jButton1.setText("Sign In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblErrorUser.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        lblErrorUser.setForeground(java.awt.Color.red);

        lblErrorPassword.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        lblErrorPassword.setForeground(java.awt.Color.red);

        lblErrorConfirmacion.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        lblErrorConfirmacion.setForeground(java.awt.Color.red);

        comBoxJerarquias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Operador\t", "Recepcionista" }));

        jLabel4.setText("Jerarquia:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(confirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblErrorPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblErrorConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblErrorUser, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(comBoxJerarquias, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comBoxJerarquias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        borrarMensajesError();
        if (verificarCamposLlenos()) {
            if (verificarDigitosSuficientes()) {
                if (!password.getText().equals(confirmacion.getText())) {
                    lblErrorConfirmacion.setText(PASSWOR_NO_CONCUERDA);
                } else {
                    if (ControladorDB.verificarUserName(txtUserName.getText()) != null) {
                        lblErrorUser.setText(ERROR_USER_YA_EXISTENTE);
                    } else {
                        ControladorDB.guardarUsuario(new Usuario(txtUserName.getText(),password.getText(),comBoxJerarquias.getSelectedIndex()+1));
                        JOptionPane.showMessageDialog(this, "UserName: "+txtUserName.getText()+" Guardado Exitosamente", "Nuevo Usuario", JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                    }
                }
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed
    private void borrarMensajesError() {
        lblErrorConfirmacion.setText("");
        lblErrorPassword.setText("");
        lblErrorUser.setText("");
    }
//Verifica si se lleno los campos necesarios para seguir
    private boolean verificarCamposLlenos() {
            if (txtUserName.getText().equals("") || "".equals(password.getText())) {
            lblErrorUser.setText(ERROR_CAMPO_NO_LLENADO);
            return false;
        } else {
            return true;
        }
    }
//Verifica si los digitos son suficientes para seguir
    private boolean verificarDigitosSuficientes() {

        if (txtUserName.getText().length() < DIGITOS_USUARIO) {
            lblErrorUser.setText(DIGITOS_INSUFICIENTES+DIGITOS_USUARIO);
            return false;
        } else if (password.getText().length() < DIGITOS_PASSWORD) {
            lblErrorPassword.setText(DIGITOS_INSUFICIENTES+DIGITOS_PASSWORD);
            return false;
        } else {
            return true;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comBoxJerarquias;
    private javax.swing.JPasswordField confirmacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblErrorConfirmacion;
    private javax.swing.JLabel lblErrorPassword;
    private javax.swing.JLabel lblErrorUser;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
