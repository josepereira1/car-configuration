/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import business.recursoshumanos.Utilizador;
import javax.swing.JOptionPane;

/**
 *
 * @author josepereira
 */
public class JCriarUtilizador extends javax.swing.JFrame {

    private JLogin jLogin;
    private JMenuAdministrador jma;
    
    /**
     * Creates new form JCriarUtilizador
     */
    public JCriarUtilizador(JLogin jLogin, JMenuAdministrador jma) {
        initComponents();
        
        this.setResizable(false);
        this.jLogin = jLogin;
        this.jma = jma;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeTF = new javax.swing.JTextField();
        pwTF = new javax.swing.JTextField();
        tipoCB = new javax.swing.JComboBox<>();
        voltarButton = new javax.swing.JButton();
        criarUtilizadorButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Password:");

        jLabel3.setText("Tipo de utilizador:");

        nomeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTFActionPerformed(evt);
            }
        });

        tipoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Funcionário Stand", "Funcionário Fábrica" }));
        tipoCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoCBActionPerformed(evt);
            }
        });

        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        criarUtilizadorButton.setText("Criar Utilizador");
        criarUtilizadorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarUtilizadorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomeTF, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pwTF)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tipoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(voltarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(criarUtilizadorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tipoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pwTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(voltarButton)
                    .addComponent(criarUtilizadorButton))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTFActionPerformed

    private void tipoCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoCBActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        this.jma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void criarUtilizadorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarUtilizadorButtonActionPerformed
        String nome = nomeTF.getText();
        String password = pwTF.getText();
        int tipo = tipoCB.getSelectedIndex();
        
        String id = String.valueOf(this.jLogin.getSingleton().getDAOFacade().getUtilizadores().geraIdProximoUtilizador());
        
        if(this.jLogin.getSingleton().getDAOFacade().getUtilizadores().containsKey(id)){    //  isto não vai acontecer, mas assim o código está preparado para todo o tipo de erros
            JOptionPane.showMessageDialog(this, "Erro interno, já existe um utilizador com o ID gerado automaticamente!","ERRO", JOptionPane.ERROR_MESSAGE);
        }else{
            this.jLogin.getSingleton().getDAOFacade().getUtilizadores().put(id, new Utilizador(id,nome,password,tipo));
            JOptionPane.showMessageDialog(this, "Utilizador adicionado com sucesso!","Informação", JOptionPane.INFORMATION_MESSAGE);
   
        }
    }//GEN-LAST:event_criarUtilizadorButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton criarUtilizadorButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nomeTF;
    private javax.swing.JTextField pwTF;
    private javax.swing.JComboBox<String> tipoCB;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
