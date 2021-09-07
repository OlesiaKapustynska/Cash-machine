package com.test.cashmachine.security;

import com.test.cashmachine.dao.UserRepository;
import com.test.cashmachine.exception.AuthenticationException;
import com.test.cashmachine.model.Card;
import com.test.cashmachine.model.User;
import com.test.cashmachine.service.CardService;
import com.test.cashmachine.service.UserService;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    private final UserService userService;
    private final CardService cardService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(UserService userService, CardService cardService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.cardService = cardService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String firsName, String lastName, Long cardsNumber, String password) {
        User user = new User();
        user.setFirstName(firsName);
        user.setLastName(lastName);
        user.setRole("USER");
        Set<Card> cards = new HashSet<>();
        user.setCards(cards);
        User saveUser = userService.add(user);
        userService.addCardByUser(user, cardsNumber, password);
        return saveUser;
    }

    @Override
    public Card login(Long cardsNumber, String password) throws AuthenticationException {
        Optional<Card> card = cardService.getById(cardsNumber);
        String encodedPassword = passwordEncoder.encode(password);
        if (card.isEmpty() || card.get().getPassword().equals(encodedPassword)) {
            throw new AuthenticationException("Incorrect cards number or password!");
        }
        return card.get();
    }
}
