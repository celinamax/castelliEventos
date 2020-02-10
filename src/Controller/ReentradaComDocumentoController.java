package Controller;

import DAO.Conexao;
import DAO.ReentradaDigitalDocumentoDAO;
import Helper.ReentradaComDocumentoHelper;
import Model.CadastroSaida;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import view.ReentradaView;

public class ReentradaComDocumentoController {

    private final ReentradaView view;
    private final ReentradaComDocumentoHelper helper;    
    boolean liberado = false;

    public ReentradaComDocumentoController(ReentradaView view) {
        this.view = view;
        this.helper = new ReentradaComDocumentoHelper(view);       
    }

    public void validarComDocumento() throws SQLException, IOException {

        String reentrada = helper.comDocumento();
        Connection conexao = new Conexao().getConnection();
        ReentradaDigitalDocumentoDAO reentradaDAO = new ReentradaDigitalDocumentoDAO(conexao);
        CadastroSaida cs = new CadastroSaida();
        
        cs.setDocumento(reentrada);
        view.getjLabelFoto().setIcon(new ImageIcon(reentradaDAO.acharFoto(cs))); 
        
        liberado = reentradaDAO.documentoExiste(reentrada);
        if (liberado) {
            helper.entradaLiberada();            
        } else {
            helper.entradaBarrada();
        }
        helper.limparTela();

    }
        
    public void setaTabela(){
        
    }

}