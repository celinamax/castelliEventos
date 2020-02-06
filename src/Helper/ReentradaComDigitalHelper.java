
package Helper;

import view.ReentradaView;

public class ReentradaComDigitalHelper {
    
    private final ReentradaView view;

    public ReentradaComDigitalHelper(ReentradaView view) {
        this.view = view;
    }

    public String comDigital() {
        return view.getjLabelDigital().getText();
        
    }

   
    
}
