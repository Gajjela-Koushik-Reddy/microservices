package com.koushikreddy.accounts.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koushikreddy.accounts.constants.AccountConstants;
import com.koushikreddy.accounts.dto.AccountContactInfoDto;
import com.koushikreddy.accounts.dto.CustomerDto;
import com.koushikreddy.accounts.dto.ResponseDto;
import com.koushikreddy.accounts.service.IAccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PutMapping;

@Tag(name = "CRUD REST APIs for Accounts Microservice in EazyBank", description = "CRUD REST APIs in EazyBank to CREATE, UPDATE, FETCH and DELETE account details")
@RestController // @RestController is used to create RESTful web services using Spring MVC
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE }) // @RequestMapping is used to map web
                                                                                // requests to Spring Controller methods
@Validated // @Validated is used to validate the method parameters
public class AccountsController {

    private final IAccountService iAccountService;

    public AccountsController(IAccountService iAccountService) {
        this.iAccountService = iAccountService;
    }

    @Autowired
    private Environment environment;

    @Autowired
    private AccountContactInfoDto accountContactInfoDto;

    @GetMapping("/java-version") // @GetMapping is used to map HTTP GET requests onto specific handler methods
    public ResponseEntity<String> getJavaVersion() {
        return new ResponseEntity<>(environment.getProperty("JAVA_HOME"), HttpStatus.OK);
    }
    
    @GetMapping("/contact-info") // @GetMapping is used to map HTTP GET requests onto specific handler methods
    public ResponseEntity<AccountContactInfoDto> getContactInfo() {
        return new ResponseEntity<>(accountContactInfoDto, HttpStatus.OK);
    }

    @Operation(summary = "Create Account REST API", description = "REST API to create new Customer and Account inside EazyBank")
    @ApiResponse(responseCode = "201", description = "HTTP Status Created")
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        iAccountService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @Operation(summary = "Fetch Account Details REST API", description = "REST API to fetch Customer data inside EazyBank")
    @ApiResponse(responseCode = "200", description = "HTTP Status OK")
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(
            @RequestParam @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number") String mobileNumber) {
        CustomerDto customerDto = iAccountService.fetchAccount(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }

    @Operation(summary = "Update Account REST API", description = "REST API to Update Exsting Customer and Account details inside EazyBank")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error") })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto) {

        boolean isUpdated = iAccountService.updateAccount(customerDto);

        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountConstants.STATUS_500, AccountConstants.MESSAGE_500));
        }
    }

    @Operation(summary = "Delete Account REST API", description = "REST API to Delete Exsting Customer and Account details inside EazyBank")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error") })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(
            @RequestParam @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number") String mobileNumber) {
        boolean isDeleted = iAccountService.deleteAccount(mobileNumber);

        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountConstants.STATUS_500, AccountConstants.MESSAGE_500));
        }
    }

}
