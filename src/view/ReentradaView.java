
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
        setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        setMaximumSize(new java.awt.Dimension(1000, 1000));
        setMinimumSize(new java.awt.Dimension(800, 800));
        setPreferredSize(new java.awt.Dimension(700, 500));

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

        jLabelMessageTela.setFont(new java.awt.Font("Comic Sans MS", 0, 72)); // NOI18N
        jLabelMessageTela.setForeground(new java.awt.Color(204, 0, 0));
        jLabelMessageTela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessageTela.setAlignmentX(0.5F);

        jLabelFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        jLabelNome.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelDocumento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMessageTela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDigital, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLerDigital, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonValidarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 418, Short.MAX_VALUE)))
                .addContainerGap())
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonValidarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jLabelMessageTela, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLerDigitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLerDigitalActionPerformed
//        try {
//            controller.validarDigital();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ReentradaView.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ReentradaView.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
