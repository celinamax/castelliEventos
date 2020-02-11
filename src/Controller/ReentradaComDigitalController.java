
package Controller;

import DAO.Conexao;
import DAO.ReentradaDigitalDocumentoDAO;
import Helper.ReentradaComDigitalHelper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import view.ReentradaView;

public class ReentradaComDigitalController {
    
    private final ReentradaView view;
    private final ReentradaComDigitalHelper helper;
    boolean liberado = false;
    

    public ReentradaComDigitalController(ReentradaView view) {
        this.view = view;
        this.helper = new ReentradaComDigitalHelper(view);
        
    }      
    

    public void validarDigital() throws SQLException, IOException {         
        
        String reentrada = helper.comDigital();

        Connection conexao = new Conexao().getConnection();
        ReentradaDigitalDocumentoDAO reentradaDAO = new ReentradaDigitalDocumentoDAO(conexao);
        liberado = reentradaDAO.digitalExiste(reentrada);

        if (liberado) {        
            
            view.getjLabelMessageTela().setText("ENTRADA LIBERADA!");
        } else {
            view.getjLabelMessageTela().setText("ENTRADA BARRADA!");
        }

        System.out.println("teste de validação de entrada com digital!");
    }  
   
    
}
