package Controller;

import DAO.Conexao;
import Helper.ReentradaComDocumentoHelper;
import Model.CadastroSaida;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import view.ReentradaView;
import DAO.ReentradaDigitalDocumentoDAO;

public class ReentradaComDocumentoController {

    private final ReentradaView view;
    private ReentradaDigitalDocumentoDAO DAO;
    private final ReentradaComDocumentoHelper helper;
    boolean liberado = false;

    public ReentradaComDocumentoController(ReentradaView view) {
        this.view = view;
        this.helper = new ReentradaComDocumentoHelper(view);
    }

    public void validarComDocumento() throws SQLException, IOException {
        String documento = helper.comDocumento();
        
        if (validar(documento))
        {
            Connection conn = new Conexao().getConnection();
            ReentradaDigitalDocumentoDAO rsDao = new ReentradaDigitalDocumentoDAO(conn);
            CadastroSaida cs = rsDao.validaDocumento(documento);
            if(cs != null){
                view.getjLabelFoto().setIcon(new ImageIcon(cs.getFoto()));
                view.getjLabelDocumento().setText(cs.getDocumento());
                view.getjLabelNome().setText(cs.getNome());

            }else{
                view.getjLabelMessageTela().setText("Convidado não Encontrado!");
            }
            helper.limparTela();  
        }
        
        

    }
    
    public boolean validar(String doc) throws SQLException{
        if (DAO.validarEntrada(doc))
        {
           view.getjLabelMessageTela().setText("Convidado já está na festa!");
           return false; 
        }
        else
        {
            DAO.updateEntrada(doc);
            return true; 
        }
    }

}
