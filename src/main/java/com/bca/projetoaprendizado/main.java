/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bca.projetoaprendizado;

import com.bca.projetoaprendizado.model.vo.PessoaVO;
import com.bca.projetoaprendizado.model.dao.PessoaDAO;
import com.bca.projetoaprendizado.util.MyException;

/**
 *
 * @author bruno
 */
public class main {

    public static void main(String[] args) throws MyException {
        // metodo usado para iniciar o sistema

//        PessoaView2 tela = new PessoaView2();
//        tela.setVisible(true);
//        tela.setLocationRelativeTo(null);
        
        PessoaDAO pdao = new PessoaDAO();
        pdao.Salvar(new PessoaVO(11,"hueberto1", 32122));
        
        
    }

}
