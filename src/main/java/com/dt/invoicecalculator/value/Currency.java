package com.dt.invoicecalculator.value;

import java.math.BigDecimal;
import java.util.Objects;

public class Currency {

  private final String code;
  private final BigDecimal exchangeRate;

  public Currency(final String code, final BigDecimal exchangeRate) {
    this.code = code;
    this.exchangeRate = exchangeRate;
  }

  public Currency(final String code, final String exchangeRate) {
    this(code, new BigDecimal(exchangeRate));
  }

  public String getCode() {
    return code;
  }

  public BigDecimal getExchangeRate() {
    return exchangeRate;
  }

  public boolean isDefault() {
    return exchangeRate.compareTo(new BigDecimal(1)) == 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Currency currency = (Currency) o;

    return Objects.equals(getCode(), currency.getCode());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCode());
  }
}
