package com.dt.invoicecalculator.value;

import com.dt.invoicecalculator.exception.DifferentCurrencyException;
import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class Money {

  private final BigDecimal amount;
  private final Currency currency;

  public Money(final BigDecimal amount, final Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public Money(final String amount, final Currency currency) {
    this(new BigDecimal(amount), currency);
  }

  public Money(final Currency currency) {
    this(new BigDecimal(0), currency);
  }

  public Money add(final Money money) throws DifferentCurrencyException {
    if (isDifferentCurrency(money)) {
      throw new DifferentCurrencyException();
    }

    return new Money(getAmount().add(money.getAmount()), getCurrency());
  }

  public Money subtract(final Money money) throws DifferentCurrencyException {
    if (isDifferentCurrency(money)) {
      throw new DifferentCurrencyException();
    }

    return new Money(getAmount().subtract(money.getAmount()), getCurrency());
  }

  private boolean isDifferentCurrency(final Money money) {
    return !money.getCurrency().equals(this.currency);
  }
}
