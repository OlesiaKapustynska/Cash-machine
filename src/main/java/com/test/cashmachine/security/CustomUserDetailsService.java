package com.test.cashmachine.security;

import com.test.cashmachine.model.Card;
import com.test.cashmachine.service.CardService;
import org.springframework.security.core.userdetails.User;
import static org.springframework.security.core.userdetails.User.withUsername;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final CardService cardService;

    public CustomUserDetailsService(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public UserDetails loadUserByUsername(String cardNumber) throws UsernameNotFoundException {
        Card card = cardService.getById(Long.parseLong(cardNumber)).orElseThrow(()
                -> new UsernameNotFoundException("User not found"));
        User.UserBuilder userBuilder = withUsername(cardNumber)
                .password(card.getPassword())
                .roles("USER");
        return userBuilder.build();
    }
}
