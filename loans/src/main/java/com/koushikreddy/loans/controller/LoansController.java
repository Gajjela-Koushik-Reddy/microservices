package com.koushikreddy.loans.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koushikreddy.loans.constants.LoanConstants;
import com.koushikreddy.loans.dto.ResponseDto;
import com.koushikreddy.loans.service.ILoansService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
public class LoansController {

    private final ILoansService iLoansService;

    @GetMapping("/hello")
    public String hello() {
        return "Welcome to Loans Microservice";
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestParam String mobileNumber) {

        iLoansService.createLoan(mobileNumber);

        ResponseDto responseDto = new ResponseDto(LoanConstants.STATUS_201, LoanConstants.MESSAGE_201);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

}
