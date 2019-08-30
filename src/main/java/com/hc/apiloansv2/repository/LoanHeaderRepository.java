/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.apiloansv2.repository;

import com.hc.apiloansv2.model.LoanHeader;
import com.hc.apiloansv2.model.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mario
 */
@Repository
public interface LoanHeaderRepository extends JpaRepository<LoanHeader, Integer> {
    // Parameter lender here = is parameter lender at the LoanHeader class
    //Page<LoanHeader> findByLender(User lender, Pageable pageable);
    // Parameters id and lender here = are the same parameters at the LoanHeader class
    //Optional<LoanHeader> findByIdAndLender(Integer id, User lender);
    //Anotacion JPQL query para hacer consultas personalizadas
    @Query( "SELECT h FROM LoanHeader h INNER JOIN h.lender e WHERE e.dni_id = :lender")
    Page<LoanHeader> findByLender( @Param("lender")Integer lenderId, Pageable pageable);
    
    @Query( "SELECT h FROM LoanHeader h INNER JOIN h.lender e WHERE h.id = :id AND e.dni_id = :lender" )
    Optional<LoanHeader> findByIdAndLender( @Param("id")Integer id, @Param("lender")Integer  lenderId);
}
