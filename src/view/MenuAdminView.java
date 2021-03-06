
package view;

import Controller.MenuAdminController;
import DAO.MenuAdminDAO;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author HMS
 */
public class MenuAdminView extends javax.swing.JDialog {

    private final MenuAdminController controller;
    private MenuAdminDAO dao;
    /**
     * Creates new form MenuAdminView
     */
    public MenuAdminView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controller = new MenuAdminController(this);
        setIcon();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Principal = new javax.swing.JTabbedPane();
        abaConexaoBanco = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCaminho_Banco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        bConexao = new javax.swing.JButton();
        abaResetBanco = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(550, 350));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Principal.setName("Principal"); // NOI18N
        Principal.setPreferredSize(new java.awt.Dimension(600, 250));

        abaConexaoBanco.setMaximumSize(new java.awt.Dimension(600, 200));
        abaConexaoBanco.setMinimumSize(new java.awt.Dimension(600, 200));
        abaConexaoBanco.setName("abaConexaoBanco"); // NOI18N
        abaConexaoBanco.setPreferredSize(new java.awt.Dimension(600, 250));
        abaConexaoBanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Caminho do Banco:");
        jLabel2.setPreferredSize(null);
        abaConexaoBanco.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, -1, -1));

        txtCaminho_Banco.setName("txtCaminho_Banco"); // NOI18N
        txtCaminho_Banco.setPreferredSize(new java.awt.Dimension(60, 35));
        abaConexaoBanco.add(txtCaminho_Banco, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 450, 30));

        jLabel3.setText("Usuário:");
        jLabel3.setPreferredSize(null);
        abaConexaoBanco.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUsuario.setName("txtUsuario"); // NOI18N
        txtUsuario.setPreferredSize(new java.awt.Dimension(60, 35));
        abaConexaoBanco.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 450, 30));

        jLabel4.setText("Senha:");
        jLabel4.setPreferredSize(null);
        abaConexaoBanco.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txtSenha.setMaximumSize(new java.awt.Dimension(60, 60));
        txtSenha.setMinimumSize(new java.awt.Dimension(60, 60));
        txtSenha.setName("txtSenha"); // NOI18N
        txtSenha.setPreferredSize(new java.awt.Dimension(60, 60));
        abaConexaoBanco.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 450, 30));

        bConexao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgpsh_fullsize_anim (2).png"))); // NOI18N
        bConexao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bConexaoMouseClicked(evt);
            }
        });
        abaConexaoBanco.add(bConexao, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 450, -1));

        Principal.addTab("Conexão Banco", abaConexaoBanco);

        abaResetBanco.setName("abaResetBanco"); // NOI18N
        abaResetBanco.setPreferredSize(new java.awt.Dimension(600, 250));
        abaResetBanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setLabel("Resetar Tabelas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        abaResetBanco.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        Principal.addTab("Reset Banco", abaResetBanco);

        getContentPane().add(Principal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            controller.validar_existe_banco();
        } catch (IOException ex) {
            Logger.getLogger(MenuAdminView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MenuAdminView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void bConexaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bConexaoMouseClicked
        // TODO add your handling code here:
        try {
            controller.configuracao();
        } catch (SQLException ex) {
            Logger.getLogger(MenuAdminView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bConexaoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            controller.resetarBanco();
        } catch (SQLException ex) {
            Logger.getLogger(MenuAdminView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MenuAdminView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuAdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuAdminView dialog = new MenuAdminView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/castelli.png")));
    } 

    public JButton getbConexao() {
        return bConexao;
    }

    public void setbConexao(JButton bConexao) {
        this.bConexao = bConexao;
    }

    public JTextField getTxtCaminho_Banco() {
        return txtCaminho_Banco;
    }

    public void setTxtCaminho_Banco(JTextField txtCaminho_Banco) {
        this.txtCaminho_Banco = txtCaminho_Banco;
    }

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }

    public void setTxtSenha(JPasswordField txtSenha) {
        this.txtSenha = txtSenha;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Principal;
    private javax.swing.JPanel abaConexaoBanco;
    private javax.swing.JPanel abaResetBanco;
    private javax.swing.JButton bConexao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCaminho_Banco;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
