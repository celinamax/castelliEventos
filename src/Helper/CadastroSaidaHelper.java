
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
        
        CadastroSaida convidado = new CadastroSaida(nome, documento);
        
        return convidado;        
    }
    
    public void setarCadastroSaida(CadastroSaida convidado){
        String nome = convidado.getNome();
        String documento = convidado.getDocumento();
    }
    
    public void limparTela(){
        view.getjTextFieldNome().setText("");
        view.getjTextFieldDocumento().setText("");        
    }
    
    
}
