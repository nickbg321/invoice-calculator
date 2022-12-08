package com.dt.invoicecalculator.value;

import com.dt.invoicecalculator.exception.DifferentCurrencyException;
import java.math.BigDecimal;

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

  public BigDecimal getAmount() {
    return amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  public Money add(Money money) throws DifferentCurrencyException {
    if (isDifferentCurrency(money)) {
      throw new DifferentCurrencyException();
    }

    return new Money(getAmount().add(money.getAmount()), getCurrency());
  }

  public Money subtract(Money money) throws DifferentCurrencyException {
    if (isDifferentCurrency(money)) {
      throw new DifferentCurrencyException();
    }

    return new Money(getAmount().subtract(money.getAmount()), getCurrency());
  }

  private boolean isDifferentCurrency(Money money) {
    return !money.getCurrency().equals(this.currency);
  }
}
