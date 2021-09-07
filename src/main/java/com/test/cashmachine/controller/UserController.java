package com.test.cashmachine.controller;

import com.test.cashmachine.model.dto.CardResponseDto;
import com.test.cashmachine.service.CardService;
import com.test.cashmachine.service.UserService;
import com.test.cashmachine.service.mapper.CardMapper;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private CardService cardService;
    private CardMapper cardMapper;
    private UserService userService;

    public UserController(CardService cardService, CardMapper cardMapper, UserService userService) {
        this.cardService = cardService;
        this.cardMapper = cardMapper;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Set<CardResponseDto> getAllCards(@PathVariable Long id) {
        return userService.getAllCardsByUserId(id).stream()
                .map(e -> cardMapper.mapToDto(e)).collect(Collectors.toSet());
    }


}
