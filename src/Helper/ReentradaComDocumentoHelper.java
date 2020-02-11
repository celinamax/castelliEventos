package Helper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import view.ReentradaView;

public class ReentradaComDocumentoHelper {

    private final ReentradaView view;
    byte[] imagem;
    Timer temporizador;

    public ReentradaComDocumentoHelper(ReentradaView view) {
        this.view = view;
    }

    public String comDocumento() {
        return view.getjTextFieldDocumento().getText();
    }

    public void limparTela() {

        ActionListener acao = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.getjTextFieldDocumento().setText("");
                view.getjLabelDocumento().setText("");
                view.getjLabelNome().setText("");
                view.getjLabelFoto().setIcon(null);
                view.getjLabelMessageTela().setText("");
            }
        };
        this.temporizador = new Timer(5000, acao);
        this.temporizador.setRepeats(false);
        this.temporizador.start();

    }

}
