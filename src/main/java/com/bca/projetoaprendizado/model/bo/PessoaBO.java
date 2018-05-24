/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bca.projetoaprendizado.model.bo;

import com.bca.projetoaprendizado.util.MyException;
import java.util.List;
import com.bca.projetoaprendizado.model.dao.PessoaDAO;
import com.bca.projetoaprendizado.model.vo.PessoaVO;

/**
 *
 * @author bruno
 */
public class PessoaBO {

    public void save(PessoaVO p) throws MyException {
        new PessoaDAO().Salvar(p);
    }

    public void list() {
        //new PessoaDAO().list();
    }

    public List<PessoaVO> lista() throws MyException {
        List<PessoaVO> lst =new PessoaDAO().listar();
        return lst;
    }

    public List<PessoaVO> lista(String sSearch) throws MyException {
        List<PessoaVO> lst = new PessoaDAO().listar(sSearch);;
        return lst;
    }
}
