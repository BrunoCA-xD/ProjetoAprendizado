/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bca.projetoaprendizado.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bca.projetoaprendizado.util.MyException;
import com.bca.projetoaprendizado.model.vo.PessoaVO;

/**
 *
 * @author bruno
 */
public class PessoaDAO extends ConectionDatabaseDAO {

    private final String sMsgError = "Ocorreu algum problema com o banco de dados";

    public PessoaDAO() throws MyException {

    }

    public void save(PessoaVO p) throws MyException {

        try {
            Cmd = Con.prepareStatement("INSERT INTO pessoa values(null,?,?);");
            Cmd.setString(1, p.getsName());
            Cmd.setInt(2, p.getiLuckyNumber());
            Cmd.execute();
            System.out.println("Nome: " + p.getsName()
                    + "\nNumero da sorte: " + p.getiLuckyNumber());
        } catch (SQLException ex) {
            throw new MyException(sMsgError);
        }

    }

    public List<PessoaVO> listar() throws MyException {
        List<PessoaVO> lst = new ArrayList<>();
        try {
            Res = Stm.executeQuery("SELECT * FROM pessoa;");
            while (Res.next()) {
                lst.add(new PessoaVO(Integer.parseInt(Res.getString("id")),
                        Res.getObject("name").toString(),
                        Integer.parseInt(Res.getObject("luckyNumber").toString())));
            }
        } catch (SQLException ex) {
            throw new MyException(sMsgError);
        }
        return lst;
    }

    public List<PessoaVO> listar(String sSearch) throws MyException {
        List<PessoaVO> lst = new ArrayList<>();
        
        try {
            Res = Stm.executeQuery("SELECT * FROM pessoa where name like '"+sSearch +"%';");
            while (Res.next()) {
                lst.add(new PessoaVO(Integer.parseInt(Res.getString("id")),
                        Res.getObject("name").toString(),
                        Integer.parseInt(Res.getObject("luckyNumber").toString())));
            }
        } catch (SQLException ex) {
            throw new MyException(sMsgError);
        }
        return lst;
    }
}
