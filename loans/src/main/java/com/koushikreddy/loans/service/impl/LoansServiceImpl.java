package com.koushikreddy.loans.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.koushikreddy.loans.constants.LoanConstants;
import com.koushikreddy.loans.entity.Loans;
import com.koushikreddy.loans.repository.LoansRepository;
import com.koushikreddy.loans.service.ILoansService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {

    private final LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
        // if the loan does not exist create new

        Optional<Loans> optionalLoan = loansRepository.findByMobileNumber(mobileNumber);

        if (!optionalLoan.isEmpty()) {
            throw new RuntimeException("Loan already registered with given mobileNumber " + mobileNumber);
        }

        loansRepository.save(createNewLoan(mobileNumber));
    }

    /**
     * @param mobileNumber
     * @return
     */
    private Loans createNewLoan(String mobileNumber) {

        Loans newLoan = new Loans();

        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoanConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoanConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoanConstants.NEW_LOAN_LIMIT);

        newLoan.setCreatedAt(LocalDateTime.now());
        newLoan.setCreatedBy("System");

        return newLoan;
    }

}
