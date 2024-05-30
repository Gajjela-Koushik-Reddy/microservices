package com.koushikreddy.cards.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koushikreddy.cards.constants.CardsConstants;
import com.koushikreddy.cards.dto.CardsDto;
import com.koushikreddy.cards.dto.ResponseDto;
import com.koushikreddy.cards.service.ICardsService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController()
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
public class CardsController {

    private final ICardsService iCardsService;

    @GetMapping("/hello")
    public String hello() {
        return "{Welcome: Welcome to Cards Microservie}";
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@RequestParam String mobileNumber) {
        iCardsService.createCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(CardsConstants.STATUS_201, CardsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CardsDto> fetchCard(@RequestParam String mobileNumber) {

        CardsDto cardsDto = iCardsService.fetchCard(mobileNumber);

        return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCard(@RequestBody CardsDto cardsDto) {

        boolean isUpdated = iCardsService.updateCard(cardsDto);

        if (isUpdated) {
            return new ResponseEntity<>(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_UPDATE),
                    HttpStatus.EXPECTATION_FAILED);
        }
    }

}
