package com.koushikreddy.cards.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koushikreddy.cards.constants.CardsConstants;
import com.koushikreddy.cards.dto.CardContactInfoDto;
import com.koushikreddy.cards.dto.CardsDto;
import com.koushikreddy.cards.dto.ResponseDto;
import com.koushikreddy.cards.service.ICardsService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController()
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@Validated
public class CardsController {

    private final ICardsService iCardsService;

    public CardsController(ICardsService iCardsService) {
        this.iCardsService = iCardsService;
    }

    @Autowired
    private CardContactInfoDto cardContactInfoDto;

    @GetMapping("/contact-info")
    public ResponseEntity<CardContactInfoDto> getContactInfo() {
        return new ResponseEntity<>(cardContactInfoDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(
            @Valid @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
        iCardsService.createCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(CardsConstants.STATUS_201, CardsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CardsDto> fetchCard(
            @Valid @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {

        CardsDto cardsDto = iCardsService.fetchCard(mobileNumber);

        return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCard(@Valid @RequestBody CardsDto cardsDto) {

        boolean isUpdated = iCardsService.updateCard(cardsDto);

        if (isUpdated) {
            return new ResponseEntity<>(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_UPDATE),
                    HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCard(
            @Valid @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {

        boolean isUpdated = iCardsService.deleteCard(mobileNumber);

        if (isUpdated) {
            return new ResponseEntity<>(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_UPDATE),
                    HttpStatus.EXPECTATION_FAILED);
        }
    }

}
