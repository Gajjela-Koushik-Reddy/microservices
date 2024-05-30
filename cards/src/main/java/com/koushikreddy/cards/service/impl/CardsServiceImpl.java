package com.koushikreddy.cards.service.impl;

import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;

import com.koushikreddy.cards.constants.CardsConstants;
import com.koushikreddy.cards.dto.CardsDto;
import com.koushikreddy.cards.entities.Cards;
import com.koushikreddy.cards.exception.CardAlreadyExistsException;
import com.koushikreddy.cards.exception.ResourceNotFoundException;
import com.koushikreddy.cards.mapper.CardsMapper;
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

    @Override
    public CardsDto fetchCard(String mobileNumber) {

        Optional<Cards> optionalCards = cardsRepository.findByMobileNumber(mobileNumber);

        if (optionalCards.isEmpty()) {
            throw new ResourceNotFoundException("Cards", "mobileNumber", mobileNumber);
        }

        Cards cards = optionalCards.get();
        return CardsMapper.mapToCardsDto(cards, new CardsDto());
    }

    @Override
    public boolean updateCard(CardsDto cardsDto) {

        // check if the customer exists in the db
        Optional<Cards> optionalCard = cardsRepository.findByCardNumber(cardsDto.getCardNumber());

        if (optionalCard.isEmpty()) {
            throw new ResourceNotFoundException("Cards", "mobileNumber", cardsDto.getCardNumber());
        }

        Cards card = optionalCard.get();

        CardsMapper.mapToCards(cardsDto, card);

        cardsRepository.save(card);

        return true;
    }

}
