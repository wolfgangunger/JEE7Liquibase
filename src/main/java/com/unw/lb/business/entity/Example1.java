/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unw.lb.business.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author UNGERW
 */
@Entity
@Table(name = "T_EXAMPLE1")
public class Example1 implements Serializable{


    private static final long serialVersionUID = 1868447758611081029L;
    
    /**
     * primary technical key
     */
    @Id
    @SequenceGenerator(name = "EntitySeq", sequenceName = "ENTITY_SEQ", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTITY_SEQ")
    @Column(name = "ID")
    private BigInteger id;

    private String name ;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
