
package Controller;

import DAO.CadastroSaidaDAO;
import DAO.Conexao;
import Helper.CadastroSaidaHelper;
import Model.CadastroSaida;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.CadastroSaidaView;

public class CadastroSaidaController {
    
    private final CadastroSaidaView view;
    private final CadastroSaidaHelper helper;
    
    public CadastroSaidaController(CadastroSaidaView view){
        this.view = view;    
        this.helper = new CadastroSaidaHelper(view);
    }
    
    public void salvarCadastro(){          
        CadastroSaida cadastroSaida = helper.cadastroSaida();
        
        try{
        Connection conn = new Conexao().getConnection();
        CadastroSaidaDAO csDao = new CadastroSaidaDAO(conn);
        csDao.insert(cadastroSaida);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
