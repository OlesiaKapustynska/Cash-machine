package com.test.cashmachine.model.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class TransactionRequestDto {
    private BigDecimal amountTransaction;
}
