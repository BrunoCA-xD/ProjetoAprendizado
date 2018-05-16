/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bca.projetoaprendizado.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import com.bca.projetoaprendizado.model.vo.PessoaVO;

/**
 *
 * @author bruno
 */
public class BuscaPessoaView extends JDialog {

    private JTable tblPessoa;
    private JScrollPane jScrollPane1;
    private JPanel pnlRoot;
    private JPanel pnlButtons;
    private JButton btnConfirm;
    private JButton btnCancel;

    public BuscaPessoaView() {
    }

    public BuscaPessoaView(List<PessoaVO> lst) {
        setSize(322, 223);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setModal(true);
        init();
        loadData(lst);

    }
    PessoaVO objPessoa = null;

    public PessoaVO listagem(List<PessoaVO> lst) {

        setSize(322, 223);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setModal(true);
        init();

        loadData(lst);
        setVisible(true);
        return objPessoa;
    }

    private void init() {
        //Instanciação
        tblPessoa = new JTable();
        jScrollPane1 = new JScrollPane();
        pnlRoot = new JPanel();
        pnlButtons = new JPanel();
        btnConfirm = new JButton("Confirmar");
        btnCancel = new JButton("Cancelar");
        btnConfirm.setEnabled(false);
        //

        getContentPane().setLayout(new java.awt.CardLayout());
        tblPessoa.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Cod", "Nome", "Numero da sorte"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblPessoa.getTableHeader().setReorderingAllowed(false);
        tblPessoa.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            btnConfirm.setEnabled(true);
        });

        btnConfirm.addActionListener((ActionEvent ae) -> {
            btnConfirmClicked(ae);
        });
        btnCancel.addActionListener((ActionEvent ae) -> {
            btnCancelClicked(ae);
        });

        jScrollPane1.setViewportView(tblPessoa);
        pnlButtons.setLayout(new java.awt.GridLayout());
        pnlButtons.add(btnConfirm);
        pnlButtons.add(btnCancel);

        pnlRoot.setLayout(new java.awt.BorderLayout());
        pnlRoot.add(new MyJLabel("Escolha uma pessoa", new Font("Tahoma", 0, 22)), java.awt.BorderLayout.NORTH);
        pnlRoot.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        pnlRoot.add(pnlButtons, java.awt.BorderLayout.SOUTH);
        getContentPane().add(pnlRoot);

    }

    private void loadData(List<PessoaVO> lstPessoa) {
        List<PessoaVO> lst = lstPessoa;
        DefaultTableModel model = (DefaultTableModel) tblPessoa.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        lst.forEach((lst1) -> {
            model.addRow(new Object[]{
                lst1.getiCod(),
                lst1.getsName(),
                lst1.getiLuckyNumber()});
        });
    }

    private void btnConfirmClicked(ActionEvent ae) {
        int iRow = tblPessoa.getSelectedRow();
        if (iRow > -1) {
            objPessoa = new PessoaVO(Integer.parseInt(tblPessoa.getValueAt(iRow, 0).toString()),
                    tblPessoa.getValueAt(iRow, 1).toString(),
                    Integer.parseInt(tblPessoa.getValueAt(iRow, 2).toString()));
        }
        this.dispose();

    }

    private void btnCancelClicked(ActionEvent ae) {
        this.dispose();
    }
}

class MyJLabel extends JLabel {

    public MyJLabel(String string, Font font) {
        super(string);
        setFont(font);
    }

}
