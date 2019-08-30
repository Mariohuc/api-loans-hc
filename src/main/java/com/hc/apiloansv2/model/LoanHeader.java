/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.apiloansv2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hc.apiloansv2.model.enumerated.LoanStatus;
import com.hc.apiloansv2.model.enumerated.RelationshipBorrowers;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
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
@Table(name = "loan_headers", schema = "public")
@TypeDef( name = "pgsql_enum", typeClass = PostgreSQLEnumType.class )
public class LoanHeader implements java.io.Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    
    @Column(name="amount")
    private Double amount;
    
    @Column(name="monthly_interest")
    private Double monthlyInterest;
    
    @Temporal(TemporalType.DATE)
    @Column(name="creation_date")
    private Date creationDate;
    
    @Column(name="interest_delivery_day")
    private Integer interestDeliveryDay;
    
    @Temporal(TemporalType.DATE)
    @Column(name="expiration_date")
    private Date expirationDate;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false )
    @JoinColumn(name = "lending_user_id", nullable = false )
    @JsonIgnore
    private User lender;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "loan_status", columnDefinition = "e_loan_status")
    @Type( type = "pgsql_enum" )
    private LoanStatus status;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "relationship_borrowers", columnDefinition = "e_relationship_borrowers")
    @Type( type = "pgsql_enum" )
    private RelationshipBorrowers relationshipBorrowers;
    
    @Column(name = "reg_status", length = 1)
    private String reg_status;
    /*
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "loanheaderp" )
    private Set<Payment> payments = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "loanheaderd")
    private Set<LoanDetail> borrowers = new HashSet<>();
    */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getMonthlyInterest() {
        return monthlyInterest;
    }

    public void setMonthlyInterest(Double monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getInterestDeliveryDay() {
        return interestDeliveryDay;
    }

    public void setInterestDeliveryDay(Integer interestDeliveryDate) {
        this.interestDeliveryDay = interestDeliveryDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public User getLender() {
        return lender;
    }

    public void setLender(User lender) {
        this.lender = lender;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    public RelationshipBorrowers getRelationshipBorrowers() {
        return relationshipBorrowers;
    }

    public void setRelationshipBorrowers(RelationshipBorrowers relationshipBorrowers) {
        this.relationshipBorrowers = relationshipBorrowers;
    }

    public String getReg_status() {
        return reg_status;
    }

    public void setReg_status(String reg_status) {
        this.reg_status = reg_status;
    }
    /*
    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public Set<LoanDetail> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(Set<LoanDetail> borrowers) {
        this.borrowers = borrowers;
    }
    */
}
