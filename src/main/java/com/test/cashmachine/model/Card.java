package com.test.cashmachine.model;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Valid
public class Card {
    @Id
    private Long cardsNumber;
    @ToString.Exclude
    private String password;
    @DecimalMin(value = "0.0")
    private BigDecimal balance;
    @OneToMany
    private List<Transaction> transactions;
}
