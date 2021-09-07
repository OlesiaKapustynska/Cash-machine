package com.test.cashmachine.service.mapper;

import com.test.cashmachine.model.Transaction;
import com.test.cashmachine.model.dto.TransactionRequestDto;
import com.test.cashmachine.model.dto.TransactionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public Transaction mapToModel(TransactionRequestDto transactionRequestDto) {
        Transaction transaction = new Transaction();
        transaction.setAmountTransaction(transactionRequestDto.getAmountTransaction());
        return transaction;
    }

    public TransactionResponseDto mapToDto(Transaction transaction) {
        TransactionResponseDto responseDto = new TransactionResponseDto();
        responseDto.setId(transaction.getId());
        responseDto.setTimeTransaction(transaction.getTimeTransaction());
        responseDto.setAmountTransaction(transaction.getAmountTransaction());
        return responseDto;
    }
}
