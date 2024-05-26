package com.koushikreddy.accounts.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class AccountsController {

    @GetMapping("")
    public String hello() {
        return "<h1>Hello World!</h1>";
    }

}
