/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bca.projetoaprendizado.model.dao;

import com.bca.projetoaprendizado.model.vo.PessoaVO;
import com.bca.projetoaprendizado.util.MyException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bca.projetoaprendizado.util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;

/**
 *
 * @author bruno
 */
public class PessoaDAO extends GenericDAO<PessoaVO, Long> {

    private final String sMsgError = "Ocorreu algum problema com o banco de dados";
    private Session session;

    public PessoaDAO() {
        super(PessoaVO.class);
    }

//    public void save(PessoaVO p) throws MyException {
//
//        try {
//            Cmd = Con.prepareStatement("INSERT INTO pessoa values(null,?,?);");
//            Cmd.setString(1, p.getsName());
//            Cmd.setInt(2, p.getiLuckyNumber());
//            Cmd.execute();
//            System.out.println("Nome: " + p.getsName()
//                    + "\nNumero da sorte: " + p.getiLuckyNumber());
//        } catch (SQLException ex) {
//            throw new MyException(sMsgError);
//        }
//
//    }
    /*public boolean Salvar(PessoaVO p) throws MyException {
        //obtem uma sessao
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null; //permite transacao com o BD 

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(p);
            tx.commit();//faz a transacao
            return true;
        } catch (Exception e) {
            System.out.println("(salvar) problem:" + e.getMessage());

            //cancela a transcao em caso de falha
            tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public List<PessoaVO> listar() {
        try {
            List<PessoaVO> Pessoas;
            session = HibernateUtil.getSessionFactory().openSession();//obtem uma sessao
            Transaction tx = null; //permite transacao com o BD 

            tx = session.beginTransaction();
            Pessoas = session.createNativeQuery("select * from pessoa;", PessoaVO.class).list();

            return Pessoas;

        } catch (HibernateException e) {
            System.out.println("Problem on list " + e.getMessage());
        }
        return null;
    }
     */
    public List<PessoaVO> listar(String sSearch) {
        try {
            List<PessoaVO> Pessoas;
            session = HibernateUtil.getSessionFactory().openSession();//obtem uma sessao
            Transaction tx = null; //permite transacao com o BD 
            tx = session.beginTransaction();
            Pessoas = session.createNativeQuery("SELECT * FROM pessoa where name like '" + sSearch + "%'", PessoaVO.class).list();
            if (Pessoas.size() > 0) {
                return Pessoas;
            }

        } catch (HibernateException e) {
            System.out.println("Problem on lsit with search " + e.getMessage());
        }
        return null;
    }
}
