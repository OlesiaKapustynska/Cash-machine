package com.test.cashmachine.controller;

import com.test.cashmachine.exception.AuthenticationException;
import com.test.cashmachine.model.Card;
import com.test.cashmachine.model.User;
import com.test.cashmachine.model.dto.CardLoginDto;
import com.test.cashmachine.model.dto.UserRegistrationDto;
import com.test.cashmachine.model.dto.UserResponseDto;
import com.test.cashmachine.security.AuthenticationService;
import com.test.cashmachine.security.jwt.JwtTokenProvider;
import com.test.cashmachine.service.mapper.CardMapper;
import com.test.cashmachine.service.mapper.UserMapper;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;
    private final CardMapper cardMapper;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationController(AuthenticationService authenticationService, UserMapper userMapper,
                                    CardMapper cardMapper, JwtTokenProvider jwtTokenProvider) {
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
        this.cardMapper = cardMapper;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRegistrationDto userRequestDto) {
        User user = authenticationService.register(userRequestDto.getFirstName(), userRequestDto.getLastName(),
                userRequestDto.getCardsNumber(), userRequestDto.getPassword());
        return userMapper.mapToDto(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody CardLoginDto cardLoginDto)
            throws AuthenticationException {
        Card card = authenticationService.login(cardLoginDto.getCardsNumber(),
                cardLoginDto.getPassword());
        String token = jwtTokenProvider.createToken(card.getCardsNumber());
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}
