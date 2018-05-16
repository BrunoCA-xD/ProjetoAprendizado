/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bca.projetoaprendizado.model.vo;

/**
 *
 * @author bruno
 */
public class PessoaVO {

    public PessoaVO() {
    }

    public PessoaVO(int iCod, String sName, int iLuckyNumber) {
        this.iCod = iCod;
        this.sName = sName;
        this.iLuckyNumber = iLuckyNumber;
    }

    public PessoaVO(String sName, int iLuckyNumber) {
        this.sName = sName;
        this.iLuckyNumber = iLuckyNumber;
    }

    private int iCod;
    private String sName;
    private int iLuckyNumber;

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
