package com.bca.projetoaprendizado.model.vo;
// Generated 28/06/2018 00:19:33 by Hibernate Tools 4.3.1



/**
 * Item generated by hbm2java
 */
public class ItemVO  implements java.io.Serializable {


     private Integer id;
     private CompraVO compra;

    public ItemVO() {
    }

    public ItemVO(CompraVO compra) {
       this.compra = compra;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public CompraVO getCompra() {
        return this.compra;
    }
    
    public void setCompra(CompraVO compra) {
        this.compra = compra;
    }




}


