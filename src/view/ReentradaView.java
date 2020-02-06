
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
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonValidarDocumento = new javax.swing.JButton();
        jButtonLerDigital = new javax.swing.JButton();
        jLabelMessageTela = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelDigital.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Foto", "Documento", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Byte.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAlignmentX(15.0F);
        jScrollPaneTabela.setViewportView(jTable1);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDocumento, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelDigital, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonLerDigital, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButtonValidarDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMessageTela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelDigital, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonLerDigital, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonValidarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jLabelMessageTela, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
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
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLerDigital;
    private javax.swing.JButton jButtonValidarDocumento;
    private javax.swing.JLabel jLabelDigital;
    private javax.swing.JLabel jLabelMessageTela;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldDocumento;
    // End of variables declaration//GEN-END:variables
}
