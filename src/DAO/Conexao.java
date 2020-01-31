

package DAO;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {
    
    public Connection getConnection() throws SQLException, FileNotFoundException, IOException {
        
        File file = new File("C:\\Castelli\\configuracao.txt");
        if (file.exists()) {
            FileReader fileR = new FileReader(file);
            BufferedReader buffR = new BufferedReader(fileR);
            String caminho_banco = buffR.readLine();
            String usuario = buffR.readLine();
            String senha = buffR.readLine(); 
            Connection conexao = DriverManager.getConnection(caminho_banco, usuario, senha);
            return conexao;
        }else{
           return null; 
        } 
    }
}
