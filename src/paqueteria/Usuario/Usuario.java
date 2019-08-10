/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.Usuario;

/**
 *
 * @author sergio
 */
public class Usuario {
    private String userName;
    private String password;
    private int jerarquia;
    public Usuario(String userName, String password, int jerarquia) {
        this.userName = userName;
        this.password = password;
        this.jerarquia = jerarquia;
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getJerarquia() {
        return jerarquia;
    }
}
