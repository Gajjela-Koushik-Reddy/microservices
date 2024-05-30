package com.koushikreddy.cards.service;

import com.koushikreddy.cards.dto.CardsDto;


public interface ICardsService {

    void createCard(String mobileNumber);

    CardsDto fetchCard(String mobileNumber);
}
