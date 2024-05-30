package com.koushikreddy.cards.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koushikreddy.cards.entities.Cards;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {

    public Optional<Cards> findByMobileNumber(String mobileNumber);
}
