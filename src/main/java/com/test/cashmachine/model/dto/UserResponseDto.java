package com.test.cashmachine.model.dto;

import com.test.cashmachine.model.Card;
import java.util.Set;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<Card> cards;
}
