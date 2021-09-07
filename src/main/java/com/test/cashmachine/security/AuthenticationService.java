package com.test.cashmachine.security;

import com.test.cashmachine.exception.AuthenticationException;
import com.test.cashmachine.model.Card;
import com.test.cashmachine.model.User;

public interface AuthenticationService {
    User register(String firsName, String lastName,
                  Long cardsNumber, String password);

    Card login(Long cardsNumber, String password) throws AuthenticationException;
}
