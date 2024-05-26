package com.koushikreddy.accounts.service.impl;

import org.springframework.stereotype.Service;

import com.koushikreddy.accounts.dto.CustomerDto;
import com.koushikreddy.accounts.service.IAccountService;

import lombok.AllArgsConstructor;
// import com.koushikreddy.accounts.repository.AccountRepository;
// import com.koushikreddy.accounts.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    // private final AccountRepository accountRepository;
    // private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        
    }
    
}
