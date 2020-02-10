package Helper;

import Model.CadastroSaida;
import java.awt.Color;
import java.sql.Blob;
import static java.util.Arrays.stream;
import javax.sql.rowset.serial.SerialBlob;
import view.ReentradaView;

public class ReentradaComDocumentoHelper {

    private final ReentradaView view;
    byte[] imagem;

    public ReentradaComDocumentoHelper(ReentradaView view) {
        this.view = view;
    }

    public String comDocumento() {
        return view.getjTextFieldDocumento().getText();
    }

    public void limparTela() {
        view.getjTextFieldDocumento().setText("");
        view.getjLabelFoto().setIcon(null);
    }

    public void entradaLiberada() {
        view.getjLabelMessageTela().setText("ENTRADA LIBERADA!");
        view.getjLabelMessageTela().setForeground(Color.green);
        
        //view.getjLabelFoto().setIcon(view.getjLabelFoto());
    }

    public void entradaBarrada() {
        view.getjLabelMessageTela().setText("ENTRADA BARRADA!");
        view.getjLabelMessageTela().setForeground(Color.red);
    }
    
    public void setarConvidado(CadastroSaida convidado){
        String nome = convidado.getNome();
        view.getjLabelFoto();
        String documento = convidado.getDocumento();
        imagem = convidado.getFoto();    
        
    }   

    public byte[] getImagem() {
        return imagem;
    }

//    public void setImagem(byte[] imagem) {
//        view.setjLabelFoto(controller.);
//    }
    
    

}
