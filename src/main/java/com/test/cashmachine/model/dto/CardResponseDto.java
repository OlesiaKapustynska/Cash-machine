package com.test.cashmachine.model.dto;

import com.test.cashmachine.model.User;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class CardResponseDto {
    private Long cardsNumber;
    private BigDecimal balance;
    private List<TransactionResponseDto> transactions;
    private User user;
}
