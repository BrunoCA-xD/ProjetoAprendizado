/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bca.projetoaprendizado.model.dao;

import com.bca.projetoaprendizado.model.vo.ItemVO;
import com.bca.projetoaprendizado.util.HibernateUtil;
import com.bca.projetoaprendizado.util.MyException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author bruno
 */
public class ItemDAO {

    private Session session;

    public boolean Salvar(ItemVO i) throws MyException {
        //obtem uma sessao
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null; //permite transacao com o BD 

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(i);
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
}
