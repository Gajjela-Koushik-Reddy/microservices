package com.koushikreddy.cards.service.impl;

import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;

import com.koushikreddy.cards.constants.CardsConstants;
import com.koushikreddy.cards.entities.Cards;
import com.koushikreddy.cards.exception.CardAlreadyExistsException;
import com.koushikreddy.cards.repository.CardsRepository;
import com.koushikreddy.cards.service.ICardsService;

import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

    private final CardsRepository cardsRepository;

    @Override
    public void createCard(String mobileNumber) {
        // create card if does not exit
        Optional<Cards> cards = cardsRepository.findByMobileNumber(mobileNumber);

        if (!cards.isEmpty()) {
            throw new CardAlreadyExistsException("Customer Already Exists");
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }

    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);

        newCard.setCreatedAt(LocalDateTime.now());
        newCard.setCreatedBy("System");

        return newCard;
    }

}
