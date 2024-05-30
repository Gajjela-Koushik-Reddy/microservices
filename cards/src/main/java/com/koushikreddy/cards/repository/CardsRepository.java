package com.koushikreddy.cards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koushikreddy.cards.entities.Cards;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {

}
