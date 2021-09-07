package com.test.cashmachine.service;

import com.test.cashmachine.model.Card;
import java.util.Optional;


public interface CardService {
    Optional<Card> getById(Long cardId);

    Card add(Card card);

}
