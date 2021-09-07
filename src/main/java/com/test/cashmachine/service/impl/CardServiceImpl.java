package com.test.cashmachine.service.impl;

import com.test.cashmachine.dao.CardRepository;
import com.test.cashmachine.model.Card;
import com.test.cashmachine.service.CardService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
    private CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Optional<Card> getById(Long cardId) {
        return cardRepository.findById(cardId);
    }

    @Override
    public Card add(Card card) {
        return cardRepository.save(card);
    }




}
