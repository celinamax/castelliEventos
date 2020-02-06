package Helper;

import java.awt.Color;
import view.ReentradaView;

public class ReentradaComDocumentoHelper {

    private final ReentradaView view;

    public ReentradaComDocumentoHelper(ReentradaView view) {
        this.view = view;
    }

    public String comDocumento() {
        return view.getjTextFieldDocumento().getText();
    }

    public void limparTela() {
        view.getjTextFieldDocumento().setText("");
    }

    public void entradaLiberada() {
        view.getjLabelMessageTela().setText("ENTRADA LIBERADA!");
        view.getjLabelMessageTela().setForeground(Color.green);

    }

    public void entradaBarrada() {
        view.getjLabelMessageTela().setText("ENTRADA BARRADA!");
        view.getjLabelMessageTela().setForeground(Color.red);

    }

}
