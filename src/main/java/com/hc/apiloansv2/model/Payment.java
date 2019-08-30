/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.apiloansv2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hc.apiloansv2.model.enumerated.PaymentStatus;
import com.hc.apiloansv2.model.enumerated.PaymentType;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

/**
 *
 * @author mario
 */
@Entity
@Table(name = "payments", schema = "public")
@TypeDef( name = "pgsql_enum", typeClass = PostgreSQLEnumType.class )
public class Payment implements java.io.Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "loan_header_id", nullable = false)
    @JsonIgnore
    private LoanHeader loanheaderp;
    
    @Column(name="paid_amount")
    private Double amountPaid;
    
    @Temporal(TemporalType.DATE)
    @Column(name="payment_date")
    private Date paymentDate;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", columnDefinition = "e_payment_type" )
    @Type( type = "pgsql_enum" )
    private PaymentType paymentType;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", columnDefinition = "e_payment_status" )
    @Type( type = "pgsql_enum" )
    private PaymentStatus paymentStatus;
    
    @Column(name = "reg_status", length = 1)
    private String reg_status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LoanHeader getLoanHeaderp() {
        return loanheaderp;
    }

    public void setLoanHeaderp(LoanHeader loanHeaderp) {
        this.loanheaderp = loanHeaderp;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getReg_status() {
        return reg_status;
    }

    public void setReg_status(String reg_status) {
        this.reg_status = reg_status;
    }
}
