package com.test.cashmachine.service;

import com.test.cashmachine.model.Card;
import com.test.cashmachine.model.User;
import java.util.List;

public interface UserService {
    User add(User user);

    List<Card> getAllCardsByUserId(Long userId);

    User addCardByUser(User user, Long cardsNumber, String password);
}
