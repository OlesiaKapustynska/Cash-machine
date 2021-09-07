package com.test.cashmachine.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TransactionResponseDto {
    private Long id;
    private LocalDateTime timeTransaction;
    private BigDecimal amountTransaction;

}
