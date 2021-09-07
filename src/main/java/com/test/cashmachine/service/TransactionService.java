package com.test.cashmachine.service;

import com.test.cashmachine.model.Transaction;
import java.math.BigDecimal;

public interface TransactionService {
    Transaction replenish(Long cardId, BigDecimal amount);

    Transaction withdraw(Long cardId, BigDecimal amount);
}
