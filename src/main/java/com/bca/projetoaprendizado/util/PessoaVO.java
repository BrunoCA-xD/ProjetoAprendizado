/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bca.projetoaprendizado.util;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author bruno
 */


@Table(name="pessoa")
public class PessoaVO implements Serializable {

    public PessoaVO() {
    }

    @Id
    @Column(name="id")
    private int iCod;
    @Column(name="name")
    private String sName;
    @Column(name="LuckyNumber")
    private int iLuckyNumber;
    
    
    public PessoaVO(int iCod, String sName, int iLuckyNumber) {
        this.iCod = iCod;
        this.sName = sName;
        this.iLuckyNumber = iLuckyNumber;
    }

    public PessoaVO(String sName, int iLuckyNumber) {
        this.sName = sName;
        this.iLuckyNumber = iLuckyNumber;
    }

    

    public int getiCod() {
        return iCod;
    }

    public void setiCod(int iCod) {
        this.iCod = iCod;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getiLuckyNumber() {
        return iLuckyNumber;
    }

    public void setiLuckyNumber(int iLuckyNumber) {
        this.iLuckyNumber = iLuckyNumber;
    }

}
