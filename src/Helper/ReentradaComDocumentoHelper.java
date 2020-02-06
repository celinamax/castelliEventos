
package Helper;

import Model.ReentradaComDocumento;
import view.ReentradaView;

public class ReentradaComDocumentoHelper {
    
    private final ReentradaView view;

    public ReentradaComDocumentoHelper(ReentradaView view) {
        this.view = view;
    }
    
    public String comDocumento(){      
        return view.getjTextFieldDocumento().getText();
    }
    
    public void limparTela(){
        view.getjTextFieldDocumento().setText("");
    }
    
    
}
