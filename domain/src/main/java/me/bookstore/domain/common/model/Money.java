package me.bookstore.domain.common.model;

import lombok.Value;

import java.math.BigDecimal;
import java.util.Currency;

@Value
public class Money {
    private final BigDecimal amount;
    private final Currency currency;

    public static Money zero() {
        return new Money(BigDecimal.ZERO, Currency.getInstance("KRW"));
    }

    public static Money of(BigDecimal bigDecimal) {
        return new Money(bigDecimal, Currency.getInstance("KRW"));
    }

    public Money add(Money money) {
        return new Money(this.amount.add(money.amount), this.currency);
    }

    public Money multiply(int multiplier) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(multiplier)), this.currency);
    }
}
