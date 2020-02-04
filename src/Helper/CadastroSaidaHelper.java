
package Helper;

import Model.CadastroSaida;
import view.CadastroSaidaView;

public class CadastroSaidaHelper {    
    
    private final CadastroSaidaView view;
    
    public CadastroSaidaHelper(CadastroSaidaView view){
        this.view = view;        
    }
    
    public CadastroSaida cadastroSaida(){
        String nome = view.getjTextFieldDocumento().getText();
        String documento = view.getjTextFieldNome().getText();
        byte[] imagem = view.getFoto();
        
        CadastroSaida convidado = new CadastroSaida(nome, documento, imagem);
        
        return convidado;        
    }
    
    public void setarCadastroSaida(CadastroSaida convidado){
        String nome = convidado.getNome();
        String documento = convidado.getDocumento();
        byte[] imagem = convidado.getFoto();
    }
    
    public void limparTela(){
        view.getjTextFieldNome().setText("");
        view.getjTextFieldDocumento().setText("");        
        view.getLabelFoto().setIcon(null);
    }
    
    
}
