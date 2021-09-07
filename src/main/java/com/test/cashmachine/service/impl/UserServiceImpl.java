package com.test.cashmachine.service.impl;

import com.test.cashmachine.dao.UserRepository;
import com.test.cashmachine.model.Card;
import com.test.cashmachine.model.User;
import com.test.cashmachine.service.UserService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<Card> getAllCardsByUserId(Long userId) {
        User user = userRepository.getById(userId);
        return user.getCards().stream()
                .collect(Collectors.toList());
    }

    @Override
    public User addCardByUser(User user, Long cardsNumber, String password) {
        Card card = new Card();
        card.setCardsNumber(cardsNumber);
        card.setPassword(password);
        card.setBalance(BigDecimal.ZERO);
        user.getCards().add(card);
        return userRepository.save(user);
    }
}
