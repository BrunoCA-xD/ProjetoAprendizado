/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bca.projetoaprendizado.model.bo;

import com.bca.projetoaprendizado.model.dao.*;
import com.bca.projetoaprendizado.model.vo.CompraVO;
import com.bca.projetoaprendizado.model.vo.ItemVO;
import com.bca.projetoaprendizado.util.HibernateUtil;
import com.bca.projetoaprendizado.util.MyException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author bruno
 */
public class ItemBO {

    private Session session;

    public void Salvar(ItemVO i) throws MyException {
        //obtem uma sessao   
        new ItemDAO().Salvar(i);
    }
}