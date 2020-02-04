
package Controller;

import DAO.CadastroSaidaDAO;
import DAO.Conexao;
import Helper.CadastroSaidaHelper;
import Model.CadastroSaida;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.CadastroSaidaView;

public class CadastroSaidaController {
    
    private final CadastroSaidaView view;
    private final CadastroSaidaHelper helper;
    
    public CadastroSaidaController(CadastroSaidaView view){
        this.view = view;    
        this.helper = new CadastroSaidaHelper(view);
    }
    

    public void salvarCadastro() throws IOException{          
        CadastroSaida cadastroSaida = helper.cadastroSaida();        
        try{
        Connection conn = new Conexao().getConnection();
        CadastroSaidaDAO csDao = new CadastroSaidaDAO(conn);
        csDao.insert(cadastroSaida);
        helper.limparTela();
        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(CadastroSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizarCadastro() throws IOException{
        CadastroSaida cadastroSaida = helper.cadastroSaida();        
        try{
        Connection con = new Conexao().getConnection();
        CadastroSaidaDAO csDao = new CadastroSaidaDAO(con);
        csDao.update(cadastroSaida);
        JOptionPane.showMessageDialog(null, "Alterado Realizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(CadastroSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
