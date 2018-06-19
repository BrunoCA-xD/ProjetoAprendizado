/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bca.projetoaprendizado.view;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import com.bca.projetoaprendizado.Controller.PessoaController;
import com.bca.projetoaprendizado.util.MyException;
import com.bca.projetoaprendizado.model.vo.PessoaVO;
import com.bca.projetoaprendizado.util.Praticidade;

/**
 *
 * @author bruno
 */
public class PessoaView2 extends javax.swing.JFrame {

    PessoaController control = new PessoaController();
    List<PessoaVO> lst = new ArrayList<>();

    /**
     * Creates new form PessoaView
     */
    public PessoaView2() {
        initComponents();
        setPreferredSize(new java.awt.Dimension(314, 364));
        init();

    }

    private void init() {

        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                int iSearchLength = txtSearch.getText().trim().length();
                if (iSearchLength == 1) {
                    try {
                        lst = control.lista(txtSearch.getText());
                    } catch (MyException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                } else {
                    lst.forEach((l) -> {
                        if (l.getName().subSequence(0, iSearchLength).equals(txtSearch.getText())) {
                            System.out.println("DEU CERTO \n" + l.getName() + "\n");

                        }

                    });
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

        });
        DefaultComboBoxModel cboModel = (DefaultComboBoxModel) cboSearch.getModel();
        JTextComponent tc = (JTextComponent) cboSearch.getEditor().getEditorComponent();
        tc.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                int iSearchLength = tc.getText().trim().length();
                if (iSearchLength == 1) {
                    try {
                        lst = control.lista(tc.getText());
                        tc.getDocument().removeDocumentListener(this);
                        lst.forEach((l) -> {
                            cboModel.addElement(l.getName());

                        });
                    } catch (MyException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                } else {
                    lst.forEach((l) -> {
                        if (l.getName().subSequence(0, iSearchLength).equals(tc.getText())) {
                            System.out.println("DEU CERTO \n" + l.getName() + "\n");

                        }

                    });
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("disparou");
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabpnl = new javax.swing.JTabbedPane();
        pnlRoot = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLuckyNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        btnSee = new javax.swing.JButton();
        btnLeave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPessoa = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        cboSearch = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(310, 356));
        getContentPane().setLayout(new java.awt.CardLayout());

        tabpnl.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabpnlStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Cadastro de numeros da sorte (loteria)");

        jLabel2.setText("Nome:");

        jLabel3.setText("Nº da sorte:");

        btnSend.setText("Enviar");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnSee.setText("Ver Existentes");
        btnSee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeActionPerformed(evt);
            }
        });

        btnLeave.setText("Sair");
        btnLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRootLayout = new javax.swing.GroupLayout(pnlRoot);
        pnlRoot.setLayout(pnlRootLayout);
        pnlRootLayout.setHorizontalGroup(
            pnlRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRootLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(pnlRootLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuckyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlRootLayout.createSequentialGroup()
                                .addComponent(btnSend)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSee)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLeave)))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pnlRootLayout.setVerticalGroup(
            pnlRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLuckyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addGroup(pnlRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSend)
                    .addComponent(btnSee)
                    .addComponent(btnLeave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabpnl.addTab("tab1", pnlRoot);

        jPanel1.setLayout(new java.awt.BorderLayout());

        tblPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Nome", "Numero da sorte"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPessoa.setColumnSelectionAllowed(true);
        tblPessoa.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPessoa);
        tblPessoa.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        tabpnl.addTab("tab2", jPanel1);

        jLabel4.setText("Pesquisar por nome");

        btnSearch.setText("Pesquisar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cboSearch.setEditable(true);
        cboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));
        cboSearch.setSelectedIndex(-1);
        cboSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cboSearchInputMethodTextChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(26, 26, 26)
                .addComponent(cboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        tabpnl.addTab("tab3", jPanel2);

        getContentPane().add(tabpnl, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        /*JOptionPane.showMessageDialog(null, this.getSize()); 310,356 */

        if (new Praticidade().fieldsFilled(pnlRoot)) {
            PessoaVO objPeople = new PessoaVO(txtName.getText(), Integer.parseInt(txtLuckyNumber.getText()));
            try {
                
                if (control.send(objPeople)) {
                    JOptionPane.showMessageDialog(null, "Deu certo ");
                    new Praticidade().clearFields(pnlRoot);
                }else{
                    JOptionPane.showMessageDialog(null, "eeee");
                }

            } catch (MyException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

    }//GEN-LAST:event_btnSendActionPerformed

    private void tabpnlStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabpnlStateChanged
        if (tabpnl.getSelectedIndex() == 1) {
            DefaultTableModel model = (DefaultTableModel) tblPessoa.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            try {
                List<PessoaVO> lst = control.lista();
                if (!lst.isEmpty()) {

                    lst.forEach((lst1) -> {
                        model.addRow(new Object[]{
                            lst1.getId(),
                            lst1.getName(),
                            lst1.getLuckynumber()});
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Não ha dados para exibir!");
                }
            } catch (MyException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_tabpnlStateChanged

    private void btnSeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeActionPerformed
        try {
            PessoaVO objSelected = new BuscaPessoaView().listagem(control.lista());
            if (objSelected != null) {
                System.out.println(objSelected.getName());
            }

// TODO add your handling code here:
        } catch (MyException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnSeeActionPerformed

    private void btnLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveActionPerformed
        System.exit(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLeaveActionPerformed
    private void summonChooseScreen() {
        try {
            PessoaVO objSelected = new BuscaPessoaView().listagem(control.lista(txtSearch.getText()));
            if (objSelected != null) {
                System.out.println(objSelected.getName());
            }

// TODO add your handling code here:
        } catch (MyException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        summonChooseScreen();// TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cboSearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cboSearchInputMethodTextChanged
        System.out.println("aa");
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSearchInputMethodTextChanged
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
            java.util.logging.Logger.getLogger(PessoaView2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PessoaView2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PessoaView2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PessoaView2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PessoaView2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLeave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSee;
    private javax.swing.JButton btnSend;
    private javax.swing.JComboBox<String> cboSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlRoot;
    private javax.swing.JTabbedPane tabpnl;
    private javax.swing.JTable tblPessoa;
    private javax.swing.JTextField txtLuckyNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

   
}
