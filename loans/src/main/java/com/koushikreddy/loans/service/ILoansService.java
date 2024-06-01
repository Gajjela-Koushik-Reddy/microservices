package com.koushikreddy.loans.service;

import com.koushikreddy.loans.dto.LoanDto;

public interface ILoansService {
    void createLoan(String mobileNumber);

    LoanDto fetchLoan(String mobileNumber);

    boolean updateLoan(LoanDto loansDto);

    boolean deleteLoan(String mobileNumber);
}
