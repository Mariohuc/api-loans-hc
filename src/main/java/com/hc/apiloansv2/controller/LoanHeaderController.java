/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.apiloansv2.controller;

import com.hc.apiloansv2.exception.ResourceNotFoundException;
import com.hc.apiloansv2.model.LoanHeader;
import com.hc.apiloansv2.model.User;
import com.hc.apiloansv2.repository.LoanHeaderRepository;
import com.hc.apiloansv2.repository.UserRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author mario
 */
@RestController
@RequestMapping("/api/v1")
public class LoanHeaderController {
    @Autowired
    private LoanHeaderRepository loanHeaderRepository;

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/loans")
    public List<LoanHeader> getAllLoans() {   
        return loanHeaderRepository.findAll();
    }
    
    @GetMapping("/users/{lenderId}/myloans")
    public Page<LoanHeader> getAllLoansByLender(@PathVariable (value = "lenderId") Integer lenderId,
                                                Pageable pageable) {
        User lender = userRepository.findById(lenderId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + lenderId));
        return loanHeaderRepository.findByLender(lender.getDni_id(), pageable);
    }
    
    @PostMapping("/users/{lenderId}/myloans")
    public LoanHeader createComment(@PathVariable (value = "lenderId") Integer lenderId,
                                 @Valid @RequestBody LoanHeader newloan) {
        User lender = userRepository.findById(lenderId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + lenderId));
        newloan.setLender(lender);
        return loanHeaderRepository.save(newloan);
    }
}
