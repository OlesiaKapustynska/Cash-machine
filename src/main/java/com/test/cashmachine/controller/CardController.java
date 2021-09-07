package com.test.cashmachine.controller;

import com.test.cashmachine.model.Card;
import com.test.cashmachine.model.dto.CardResponseDto;
import com.test.cashmachine.model.dto.TransactionResponseDto;
import com.test.cashmachine.service.CardService;
import com.test.cashmachine.service.mapper.CardMapper;
import com.test.cashmachine.service.mapper.TransactionMapper;
import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {
    private CardService cardService;
    private CardMapper cardMapper;
    private TransactionMapper transactionMapper;

    public CardController(CardService cardService, CardMapper cardMapper, TransactionMapper transactionMapper) {
        this.cardService = cardService;
        this.cardMapper = cardMapper;
        this.transactionMapper = transactionMapper;
    }

    @GetMapping("/transactions/{cardNumber}")
    public Set<TransactionResponseDto> getAllTransaction(@PathVariable Long cardNumber) {
        return cardService.getById(cardNumber).orElseThrow().getTransactions()
                .stream()
                .map(t -> transactionMapper.mapToDto(t))
                .collect(Collectors.toSet());
    }

    @GetMapping("/balance/{cardNumber}")
    public BigDecimal getBalance(@PathVariable Long cardNumber) {
        CardResponseDto cardResponseDto = cardMapper.mapToDto(cardService.getById(cardNumber).orElseThrow());
        return cardResponseDto.getBalance();
    }
}
