package com.test.cashmachine.service.mapper;

import com.test.cashmachine.model.Card;
import com.test.cashmachine.model.dto.CardResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {
    private TransactionMapper transactionMapper;

    public CardMapper(TransactionMapper transactionMapper) {
        this.transactionMapper = transactionMapper;
    }

    public CardResponseDto mapToDto(Card card) {
        CardResponseDto responseDto = new CardResponseDto();
        responseDto.setCardsNumber(card.getCardsNumber());
        responseDto.setBalance((card.getBalance()));
        responseDto.setTransactions(card.getTransactions().stream()
                .map(transactionMapper::mapToDto)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
