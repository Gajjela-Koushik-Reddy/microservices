package com.koushikreddy.accounts.service;

import com.koushikreddy.accounts.dto.CustomerDto;

public interface IAccountService {
    
    /**
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);
    boolean updateAccount(CustomerDto customerDto);
}