/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.apiloansv2.model;

/**
 *
 * @author mario
 */
import com.hc.apiloansv2.model.enumerated.UserType;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name = "users", schema = "public")
@TypeDef( name = "pgsql_enum", typeClass = PostgreSQLEnumType.class )
public class User implements java.io.Serializable {

    @Id
    @Column(name = "dni_id", updatable = false, nullable = false)
    private Integer dni_id;

    @Column(name = "username", length = 15)
    private String username;

    @Column(name = "password", length = 10)
    private String password;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "surname", length = 50)
    private String surname;

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "address", length = 80)
    private String address;

    @Column(name = "district", length = 30)
    private String district;

    @Column(name = "province", length = 30)
    private String province;

    @Column(name = "department", length = 30)
    private String department;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", columnDefinition = "e_user_type")
    @Type( type = "pgsql_enum" )
    private UserType userType;

    @Column(name = "reg_status", length = 1)
    private String reg_status;
    /*
    // user is not a database field, it's a member of the class Loan Header, as a User class  
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lender")
    private Set<LoanHeader> myLoans = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "borrower")
    private Set<LoanDetail> myDebts = new HashSet<>();
    */
    public Integer getDni_id() {
        return dni_id;
    }

    public void setDni_id(Integer dni_id) {
        this.dni_id = dni_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType usertype) {
        this.userType = usertype;
    }

    public String getReg_status() {
        return reg_status;
    }

    public void setReg_status(String reg_status) {
        this.reg_status = reg_status;
    }
    /*
    public Set<LoanHeader> getMyLoans() {
        return myLoans;
    }

    public void setMyLoans(Set<LoanHeader> myLoans) {
        this.myLoans = myLoans;
    }

    public Set<LoanDetail> getMyDebts() {
        return myDebts;
    }

    public void setMyDebts(Set<LoanDetail> myDebts) {
        this.myDebts = myDebts;
    }
    */
    
}
