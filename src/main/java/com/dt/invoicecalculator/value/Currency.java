package com.dt.invoicecalculator.value;

import java.math.BigDecimal;

public class Currency {

  private final String code;
  private final BigDecimal exchangeRate;

  public Currency(final String code, final BigDecimal exchangeRate) {
    this.code = code;
    this.exchangeRate = exchangeRate;
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
}