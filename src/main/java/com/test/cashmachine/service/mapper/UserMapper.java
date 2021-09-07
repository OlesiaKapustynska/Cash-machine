package com.test.cashmachine.service.mapper;

import com.test.cashmachine.model.User;
import com.test.cashmachine.model.dto.UserResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setFirstName(user.getFirstName());
        responseDto.setLastName(user.getLastName());
        responseDto.setCards(user.getCards().stream()
        .collect(Collectors.toSet()));
        return responseDto;
    }
}
