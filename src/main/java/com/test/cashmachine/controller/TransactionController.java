package com.test.cashmachine.controller;

import com.test.cashmachine.model.Transaction;
import com.test.cashmachine.model.dto.TransactionRequestDto;
import com.test.cashmachine.model.dto.TransactionResponseDto;
import com.test.cashmachine.service.CardService;
import com.test.cashmachine.service.TransactionService;
import com.test.cashmachine.service.mapper.TransactionMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private CardService cardService;
    private TransactionService transactionService;
    private TransactionMapper transactionMapper;

    public TransactionController(CardService cardService, TransactionService transactionService, TransactionMapper transactionMapper) {
        this.cardService = cardService;
        this.transactionService = transactionService;
        this.transactionMapper = transactionMapper;
    }

    @PostMapping("/replenish/{cardNumber}")
    public TransactionResponseDto replenish(@PathVariable Long cardNumber, @RequestBody TransactionRequestDto transactionRequestDto) {
        Transaction transaction = transactionMapper.mapToModel(transactionRequestDto);
        return transactionMapper.mapToDto(transactionService.replenish(cardNumber, transaction.getAmountTransaction()));
    }

    @PostMapping("/withdraw/{cardNumber}")
    public TransactionResponseDto withdraw(@PathVariable Long cardNumber, @RequestBody TransactionRequestDto transactionRequestDto) {
        Transaction transaction = transactionMapper.mapToModel(transactionRequestDto);
        return transactionMapper.mapToDto(transactionService.withdraw(cardNumber, transaction.getAmountTransaction()));
    }

}
