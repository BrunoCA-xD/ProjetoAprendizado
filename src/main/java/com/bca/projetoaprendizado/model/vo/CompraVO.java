package com.bca.projetoaprendizado.model.vo;
// Generated 28/06/2018 00:19:33 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Compra generated by hbm2java
 */
public class CompraVO  implements java.io.Serializable {


     private Integer id;
     private Date dataCompra;
     private Byte situacao;
     private Set items = new HashSet(0);

    public CompraVO() {
    }

	
    public CompraVO(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
    public CompraVO(Date dataCompra, Byte situacao, Set items) {
       this.dataCompra = dataCompra;
       this.situacao = situacao;
       this.items = items;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getDataCompra() {
        return this.dataCompra;
    }
    
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
    public Byte getSituacao() {
        return this.situacao;
    }
    
    public void setSituacao(Byte situacao) {
        this.situacao = situacao;
    }
    public Set getItems() {
        return this.items;
    }
    
    public void setItems(Set items) {
        this.items = items;
    }




}

