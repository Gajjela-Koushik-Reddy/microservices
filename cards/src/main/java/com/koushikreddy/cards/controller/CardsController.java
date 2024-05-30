package com.koushikreddy.cards.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.http.MediaType;

@RestController()
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
public class CardsController {

    @GetMapping("/hello")
    public String hello() {

        return "{Welcome: Welcome to Cards Microservie}";
    }
}
