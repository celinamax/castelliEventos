/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;
import javax.swing.JOptionPane;
import view.LoginAdminView;

/**
 *
 * @author HMS
 */
public class LoginAdminController {

    private LoginAdminView view;
    private String caminho_banco;
    private String usuario;
    private String senha;

    public LoginAdminController(LoginAdminView view) {
        this.view = view;
    }

    public boolean validar() {
        if (view.getTxtLogin().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o login!");
            view.getTxtLogin().requestFocus(true);
            return true;
        } else if (view.getTxtSenha().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor preencha a senha!");
            view.getTxtSenha().requestFocus(true);
            return true;
        } else if (!view.getTxtLogin().getText().equals(usuario)) {
            JOptionPane.showMessageDialog(null, "Usuário Incorreta!");
            view.getTxtLogin().requestFocus(true);
            return true;
        } else if (!view.getTxtSenha().getText().equals(senha)) {
            JOptionPane.showMessageDialog(null, "Senha Incorreta!");
            view.getTxtSenha().requestFocus(true);
            return true;
        } else {
            return false;
        }
    }

    public boolean acessar() {
        if (!validar()) {
           view.setVisible(false);
           return true;
        }else {
           return false; 
        }
    }

    public void informacao_banco() throws FileNotFoundException, IOException {
        File file = new File("C:\\Castelli\\configuracao.txt");
        if (file.exists()) {
            FileReader fileR = new FileReader(file);
            BufferedReader buffR = new BufferedReader(fileR);
            caminho_banco = new String(Base64.getDecoder().decode(buffR.readLine().getBytes()));
            usuario = new String(Base64.getDecoder().decode(buffR.readLine().getBytes()));
            senha = new String(Base64.getDecoder().decode(buffR.readLine().getBytes()));
        }
    }

}
