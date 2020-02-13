
package view;

import Controller.ReentradaComDigitalController;
import Controller.ReentradaComDocumentoController;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ReentradaView extends javax.swing.JFrame {

    private final ReentradaComDigitalController controller;    
    private final ReentradaComDocumentoController controllerDocumento;
    byte[] digital;
    
    public ReentradaView() {
        initComponents();
        setIcon();       
        this.controller = new ReentradaComDigitalController(this);
        this.controllerDocumento = new ReentradaComDocumentoController(this);  
        this.setLocationRelativeTo(null);
    }   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDigital = new javax.swing.JLabel();
        jTextFieldDocumento = new javax.swing.JTextField();
        jButtonValidarDocumento = new javax.swing.JButton();
        jButtonLerDigital = new javax.swing.JButton();
        jLabelMessageTela = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelDocumento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new java.awt.Font("Comic Sans MS", 0, 5)); // NOI18N
        setMaximumSize(new java.awt.Dimension(688, 444));
        setMinimumSize(new java.awt.Dimension(688, 444));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabelDigital.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDigital.setText("Digital");
        jLabelDigital.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonValidarDocumento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonValidarDocumento.setText("Validar Documento");
        jButtonValidarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValidarDocumentoActionPerformed(evt);
            }
        });

        jButtonLerDigital.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonLerDigital.setText("Leitura Digital");
        jButtonLerDigital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLerDigitalActionPerformed(evt);
            }
        });

        jLabelMessageTela.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabelMessageTela.setForeground(new java.awt.Color(204, 0, 0));
        jLabelMessageTela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessageTela.setAlignmentX(0.5F);

        jLabelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFoto.setText("Foto");
        jLabelFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        jLabelNome.setText("Nome");
        jLabelNome.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelDocumento.setText("Documento");
        jLabelDocumento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMessageTela, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDigital, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLerDigital, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonValidarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDigital, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLerDigital, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jTextFieldDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonValidarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMessageTela, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLerDigitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLerDigitalActionPerformed
        try {
            controller.validarDigital();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReentradaView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReentradaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonLerDigitalActionPerformed

    private void jButtonValidarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValidarDocumentoActionPerformed
        try {
            controllerDocumento.validarComDocumento();
        } catch (SQLException ex) {
            Logger.getLogger(ReentradaView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReentradaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonValidarDocumentoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        controller.abrirBiometria();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        controller.fecharBiometria();
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReentradaView().setVisible(true);
            }
        });
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/castelli.png")));
    }

    public JLabel getjLabelDigital() {
        return jLabelDigital;
    }

    public void setjLabelDigital(JLabel jLabelDigital) {
        this.jLabelDigital = jLabelDigital;
    }

    public JTextField getjTextFieldDocumento() {
        return jTextFieldDocumento;
    }

    public void setjTextFieldDocumento(JTextField jTextFieldDocumento) {
        this.jTextFieldDocumento = jTextFieldDocumento;
    }  

    public JLabel getjLabelMessageTela() {
        return jLabelMessageTela;
    }

    public void setjLabelMessageTela(JLabel jLabelMessageTela) {
        this.jLabelMessageTela = jLabelMessageTela;
    }    

    public JLabel getjLabelFoto() {
        return jLabelFoto;
    }

    public void setjLabelFoto(JLabel jLabelFoto) {
        this.jLabelFoto = jLabelFoto;
    }   

    public JLabel getjLabelDocumento() {
        return jLabelDocumento;
    }

    public void setjLabelDocumento(JLabel jLabelDocumento) {
        this.jLabelDocumento = jLabelDocumento;
    }

    public JLabel getjLabelNome() {
        return jLabelNome;
    }

    public void setjLabelNome(JLabel jLabelNome) {
        this.jLabelNome = jLabelNome;
    }

    public byte[] getDigital() {
        return digital;
    }

    public void setDigital(byte[] digital) {
        this.digital = digital;
    }
    
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLerDigital;
    private javax.swing.JButton jButtonValidarDocumento;
    private javax.swing.JLabel jLabelDigital;
    private javax.swing.JLabel jLabelDocumento;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelMessageTela;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JTextField jTextFieldDocumento;
    // End of variables declaration//GEN-END:variables
}
