package com.koushikreddy.loans.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koushikreddy.loans.constants.LoanConstants;
import com.koushikreddy.loans.dto.LoanDto;
import com.koushikreddy.loans.dto.LoansContactInfoDto;
import com.koushikreddy.loans.dto.ResponseDto;
import com.koushikreddy.loans.service.ILoansService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@Validated
@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class LoansController {

    private final ILoansService iLoansService;

    public LoansController(ILoansService iLoansService) {
        this.iLoansService = iLoansService;
    }

    @Autowired
    private LoansContactInfoDto loansContactInfoDto;

    @GetMapping("/contact-info")
    public ResponseEntity<LoansContactInfoDto> getContactInfo() {
        return new ResponseEntity<>(loansContactInfoDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(
            @Valid @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits") String mobileNumber) {

        iLoansService.createLoan(mobileNumber);

        ResponseDto responseDto = new ResponseDto(LoanConstants.STATUS_201, LoanConstants.MESSAGE_201);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoanDto> fetchLoan(
            @Valid @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits") String mobileNumber) {

        LoanDto laonsDto = iLoansService.fetchLoan(mobileNumber);

        return new ResponseEntity<>(laonsDto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoan(@Valid @RequestBody LoanDto loansDto) {

        boolean isUpdated = iLoansService.updateLoan(loansDto);

        if (isUpdated) {
            return new ResponseEntity<>(new ResponseDto(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseDto(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_UPDATE),
                    HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> updateLoan(
            @Valid @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits") String mobileNumber) {

        boolean isUpdated = iLoansService.deleteLoan(mobileNumber);

        if (isUpdated) {
            return new ResponseEntity<>(new ResponseDto(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseDto(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_UPDATE),
                    HttpStatus.EXPECTATION_FAILED);
        }
    }

}
