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
        String documento = helper.comDocumento();
        Connection conn = new Conexao().getConnection();
        ReentradaDigitalDocumentoDAO rsDao = new ReentradaDigitalDocumentoDAO(conn);
        CadastroSaida cs = rsDao.busca(documento);
        view.getjLabelFoto().setIcon(new ImageIcon(cs.getFoto()));
        view.getjLabelDocumento().setText(cs.getDocumento());
        view.getjLabelNome().setText(cs.getNome());

    }

}
