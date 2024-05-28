package com.koushikreddy.accounts.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.koushikreddy.accounts.constants.AccountConstants;
import com.koushikreddy.accounts.dto.AccountDto;
import com.koushikreddy.accounts.dto.CustomerDto;
import com.koushikreddy.accounts.entity.Accounts;
import com.koushikreddy.accounts.entity.Customers;
import com.koushikreddy.accounts.exception.CustomerAlreadyExistsException;
import com.koushikreddy.accounts.exception.ResourceNotFoundException;
import com.koushikreddy.accounts.mapper.AccountMapper;
import com.koushikreddy.accounts.mapper.CustomerMapper;
import com.koushikreddy.accounts.service.IAccountService;

import lombok.AllArgsConstructor;
import com.koushikreddy.accounts.repository.AccountRepository;
import com.koushikreddy.accounts.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customers customer = CustomerMapper.mapToCustomer(customerDto, new Customers());
        Optional<Customers> optionalCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());

        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists with the mobile number: " + customer.getMobileNumber());
        }

        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("System");

        Customers savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));
    }

    /**
     * Create a new account for the customer
     * 
     * @param customer
     * @return Account
     */
    private Accounts createNewAccount(Customers customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long accountNumber = (long) (Math.random() * 100000 + 1000000000L);

        newAccount.setAccountNumber(accountNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("System");

        return newAccount;
    }

    /**
     * Represents a data transfer object for a customer.
     * This class is used to transfer customer data between different layers of the
     * application.
     */
    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customers customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        Accounts account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Accounts", "mobileNumber", customer.getCustomerId().toString()));

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountDto(AccountMapper.mapToAccountDto(account, new AccountDto()));

        return customerDto;
    }
}
