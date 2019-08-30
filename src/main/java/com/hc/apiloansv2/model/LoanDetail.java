/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.apiloansv2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mario
 */
@Entity
@Table(name = "loan_details", schema = "public")
public class LoanDetail implements java.io.Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "loan_header_id", nullable = false)
    @JsonIgnore
    private LoanHeader loanheaderd;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false )
    @JoinColumn(name = "borrower_user_id", nullable = false )
    @JsonIgnore
    private User borrower;
    
    @Column(name = "reg_status", length = 1)
    private String reg_status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LoanHeader getLoanHeaderd() {
        return loanheaderd;
    }

    public void setLoanHeaderd(LoanHeader loanHeaderd) {
        this.loanheaderd = loanHeaderd;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public String getReg_status() {
        return reg_status;
    }

    public void setReg_status(String reg_status) {
        this.reg_status = reg_status;
    }
  
}
