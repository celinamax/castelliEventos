/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import view.EntradaView;

/**
 *
 * @author HMS
 */
public class EntradaHelper {

    private final EntradaView entradaView;
    Timer temporizador;

    public EntradaHelper(EntradaView entradaView) {
        this.entradaView = entradaView;
    }

    public String entrada() {
        return entradaView.getCampoCodconvite().getText();
    }

    public void limpaTela() {
        entradaView.getCampoCodconvite().setText("");
        ActionListener acao = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                entradaView.getLabelLiberaEntrada().setText("");
            }
        };
        this.temporizador = new Timer(5000, acao);
        this.temporizador.setRepeats(false);
        this.temporizador.start();
    }    

    public void liberaEntrada() {
        entradaView.getLabelLiberaEntrada().setText("Entrada Liberada");
        entradaView.getLabelLiberaEntrada().setForeground(Color.GREEN);
    }

    public void barraEntrada() {
        entradaView.getLabelLiberaEntrada().setText("Convite Inválido");
        entradaView.getLabelLiberaEntrada().setForeground(Color.RED);
    }

}
