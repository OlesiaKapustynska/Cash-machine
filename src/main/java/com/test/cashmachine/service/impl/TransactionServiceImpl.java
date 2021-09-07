package com.test.cashmachine.service.impl;

import com.test.cashmachine.dao.CardRepository;
import com.test.cashmachine.dao.TransactionRepository;
import com.test.cashmachine.model.Card;
import com.test.cashmachine.model.Transaction;
import com.test.cashmachine.service.CardService;
import com.test.cashmachine.service.TransactionService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    private CardService cardService;
    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(CardService cardService,
                                  TransactionRepository transactionRepository) {
        this.cardService = cardService;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction replenish(Long cardId, BigDecimal amount) {
        Card card = cardService.getById(cardId).orElseThrow();
        return addTransaction(amount, card);
    }

    @Override
    public Transaction withdraw(Long cardId, BigDecimal amount) {
        Card card = cardService.getById(cardId).orElseThrow();
        if (card.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("You can't withdraw");
        }
        return addTransaction(amount, card);
    }

    private Transaction addTransaction(BigDecimal amount, Card card) {
        Transaction transaction = new Transaction();
        transaction.setTimeTransaction(LocalDateTime.now());
        transaction.setAmountTransaction(amount);
        card.getTransactions().add(transaction);
        card.setBalance(card.getBalance().add(amount));
        transactionRepository.save(transaction);
        return transaction;
    }
}
