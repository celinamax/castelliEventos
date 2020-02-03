/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.MenuAdminView;
import view.MenuView;

/**
 *
 * @author HMS
 */
public class MenuAdminController {
    
    private MenuAdminView view;

    public MenuAdminController(MenuAdminView view) {
        this.view = view;
    }
    
    public void validar_existe_banco() throws FileNotFoundException, IOException, SQLException {        
        File file = new File("C:\\Castelli\\configuracao.txt");
        if (file.exists()) {
            view.setVisible(false);
            FileReader fileR = new FileReader(file);
            BufferedReader buffR = new BufferedReader(fileR);
            String caminho_banco = buffR.readLine();
            String usuario = buffR.readLine();
            String senha = buffR.readLine();
            
            caminho_banco = new String(Base64.getDecoder().decode(caminho_banco.getBytes()));
            usuario = new String(Base64.getDecoder().decode(usuario.getBytes()));
            senha = new String(Base64.getDecoder().decode(senha.getBytes()));
                                
            Connection conexao = DriverManager.getConnection(caminho_banco, usuario, senha);

            boolean conectar = true;
            conectar = !conexao.isClosed();
            
            if (conectar) {
                caminho_banco = caminho_banco.replace("jdbc:mysql:", "");
                caminho_banco = caminho_banco.replace("?useTimezone=true&serverTimezone=UTC", "");
                view.getTxtCaminho_Banco().setText(caminho_banco);
                view.getTxtUsuario().setText(usuario);
                view.getTxtSenha().setText(senha); 
                view.setVisible(true);
            } 
        }
        else {
            JOptionPane.showMessageDialog(null, "O Arquivo de configuração não foi encontrado!");
        }
    }
    
    public boolean validar() {
        if (view.getTxtCaminho_Banco().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o caminho do banco");
            view.getTxtCaminho_Banco().requestFocus(true);
            return true;
        } else if (view.getTxtUsuario().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o Usuário");
            view.getTxtUsuario().requestFocus(true);
            return true;
        } else if (view.getTxtSenha().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor preencha a senha");
            view.getTxtSenha().requestFocus(true);
            return true;
        } else {
            return false;
        }
    }
    
    public void escreverArquivo(String caminho_banco, String usuario, String senha) throws IOException, SQLException {
        //arquivo para escrita
        String Banco_full = "jdbc:mysql:" + caminho_banco + "?useTimezone=true&serverTimezone=UTC";
        Connection conexao = DriverManager.getConnection(Banco_full, usuario, senha);

        boolean conectar = true;
        //conectar = !conexao.isClosed();
        if (conectar) {

            File diretorio = new File("C:\\Castelli");
            if (!diretorio.exists()) {
                diretorio.mkdir();
            }

            File arquivo = new File("C:\\Castelli\\configuracao.txt");
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
         
            /*ESCREVER*/
            Banco_full = new String(Base64.getEncoder().encode(Banco_full.getBytes()));
            usuario = new String(Base64.getEncoder().encode(usuario.getBytes()));
            senha = new String(Base64.getEncoder().encode(senha.getBytes()));
            
            FileWriter fileW = new FileWriter(arquivo);//arquivo para escrita
            BufferedWriter buffW = new BufferedWriter(fileW);
            buffW.write(Banco_full);//Leia um arquivo e Escreva na linha
            buffW.newLine();
            buffW.write(usuario);//Leia um arquivo e Escreva na linha
            buffW.newLine();
            buffW.write(senha);//Leia um arquivo e Escreva na linha
            buffW.newLine();
            buffW.close();
            JOptionPane.showMessageDialog(null, "Banco conectado com sucesso!");
            MenuView MenuForm = new MenuView();
            MenuForm.setVisible(true);
            view.setVisible(false);
        }
    }
    
    public void configuracao() throws SQLException {
        if (!validar()) {
            try {
                escreverArquivo(view.getTxtCaminho_Banco().getText(),
                        view.getTxtUsuario().getText(),
                        view.getTxtSenha().getText());
            } catch (IOException ex) {
                Logger.getLogger(conexaoBancoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
