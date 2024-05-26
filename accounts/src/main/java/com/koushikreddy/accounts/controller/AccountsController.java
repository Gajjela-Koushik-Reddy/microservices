package com.koushikreddy.accounts.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koushikreddy.accounts.constants.AccountConstants;
import com.koushikreddy.accounts.dto.CustomerDto;
import com.koushikreddy.accounts.dto.ResponseDto;

@RestController // @RestController is used to create RESTful web services using Spring MVC
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE }) // @RequestMapping is used to map web
                                                                                // requests to Spring Controller methods
public class AccountsController {

    @GetMapping("/hello") // @GetMapping is used to map HTTP GET requests onto specific handler methods
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));

    }

}
