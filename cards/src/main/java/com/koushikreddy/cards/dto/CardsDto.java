package com.koushikreddy.cards.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class CardsDto {

    @NotEmpty(message = "Mobile Number Cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
    private String mobileNumber;

    @NotEmpty(message = "Card Number Cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Card Number Must be 12 digits")
    private String cardNumber;

    @NotEmpty(message = "Card Type cannot be null or empty")
    private String cardType;

    @Positive(message = "Total card limit should be greater than 0")
    private int totalLimit;

    @PositiveOrZero(message = "Total amount should be equal or greater tham zero")
    private int amountUsed;

    @PositiveOrZero(message = "Available amaount should be equal or greater than zero")
    private int availableAmount;
}
