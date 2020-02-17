
package Helper;

import Model.CadastroSaida;
import javax.swing.ImageIcon;
import view.CadastroSaidaView;

public class CadastroSaidaHelper {    
    
    private final CadastroSaidaView view;
    
    public CadastroSaidaHelper(CadastroSaidaView view){
        this.view = view;        
    }
    
    public CadastroSaida cadastroSaida(){
        String nome = view.getjTextFieldNome().getText();
        String documento = view.getjTextFieldDocumento().getText();
        byte[] imagem = view.getFoto();
        byte[] digital = view.getDigital();
        
        CadastroSaida convidado = new CadastroSaida(nome, documento,digital, imagem);
        
        return convidado;        
    }
    
//    public void setarCadastroSaida(CadastroSaida convidado){
//        String nome = convidado.getNome();
//        String documento = convidado.getDocumento();
//        
////        byte[] imagem = convidado.getFoto();
//
//    }
    
//    public void imageIcon(){
//        ImageIcon imagem = new ImageIcon(getClass().getResouce();
//    }
    
    public void limparTela(){
        view.getjTextFieldNome().setText("");
        view.getjTextFieldDocumento().setText("");        
        view.getLabelFoto().setIcon(null);
        view.getBtnImagem().setIcon(null);
    }
    
    
}
