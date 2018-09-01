/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bca.projetoaprendizado.Controller;

import com.bca.projetoaprendizado.model.bo.CompraBO;
import com.bca.projetoaprendizado.model.bo.ItemBO;
import com.bca.projetoaprendizado.model.vo.CompraVO;
import com.bca.projetoaprendizado.model.vo.ItemVO;
import com.bca.projetoaprendizado.util.MyException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author bruno
 */
public class TestController {

    public void save(CompraVO c, ItemVO i) throws MyException {


        c.setDataCompra(new Date("1998/11/11"));
        new CompraBO().Salvar(c);
        new ItemBO().Salvar(i);
    }

}
