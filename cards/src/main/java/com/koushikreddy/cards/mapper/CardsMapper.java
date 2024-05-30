package com.koushikreddy.cards.mapper;

import com.koushikreddy.cards.dto.CardsDto;
import com.koushikreddy.cards.entities.Cards;

public class CardsMapper {

    public static CardsDto mapToCardsDto(Cards cards, CardsDto cardsDto) {

        cardsDto.setAmountUsed(cards.getAmountUsed());
        cardsDto.setAvailableAmount(cards.getAmountUsed());
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setMobileNumber(cards.getMobileNumber());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());

        return cardsDto;
    }

    public static Cards mapToCards(CardsDto cardsDto, Cards cards) {

        cards.setAmountUsed(cardsDto.getAmountUsed());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());
        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setCardType(cardsDto.getCardType());
        cards.setMobileNumber(cardsDto.getMobileNumber());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());

        return cards;

    }
}