package com.koushikreddy.loans.mapper;

import com.koushikreddy.loans.dto.LoanDto;
import com.koushikreddy.loans.entity.Loans;

public class LoansMapper {

    public static LoanDto mapToDto(Loans loans, LoanDto loanDto) {

        loanDto.setMobileNumber(loans.getMobileNumber());
        loanDto.setLoanNumber(loans.getLoanNumber());
        loanDto.setLoanType(loans.getLoanType());
        loanDto.setTotalLoan(loans.getTotalLoan());
        loanDto.setAmountPaid(loans.getAmountPaid());
        loanDto.setOutstandingAmount(loans.getOutstandingAmount());

        return loanDto;
    }

    public static Loans mapToLoans(LoanDto loansDto, Loans loans) {

        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setLoanType(loansDto.getLoanType());
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());

        return loans;
    }
}
