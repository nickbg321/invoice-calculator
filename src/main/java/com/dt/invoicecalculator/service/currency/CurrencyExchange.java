package com.dt.invoicecalculator.service.currency;

import com.dt.invoicecalculator.exception.MissingDefaultCurrencyException;
import com.dt.invoicecalculator.value.Currency;
import com.dt.invoicecalculator.value.Money;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class CurrencyExchange {

  private Map<String, Currency> currencyList;

  public void setCurrencyList(final Map<String, Currency> currencyList) {
    this.currencyList = currencyList;
  }

  public Money exchange(final Money money, final Currency outputCurrency)
      throws MissingDefaultCurrencyException {
    if (money.getCurrency().equals(outputCurrency)) {
      return money;
    }

    if (money.getCurrency().equals(getDefaultCurrency())) {
      return new Money(money.getAmount().multiply(outputCurrency.getExchangeRate()),
          outputCurrency);
    }

    BigDecimal defaultAmount = money.getAmount()
        .divide(money.getCurrency().getExchangeRate(), 6, RoundingMode.HALF_UP);

    return new Money(defaultAmount.multiply(outputCurrency.getExchangeRate()), outputCurrency);
  }

  private Currency getDefaultCurrency() throws MissingDefaultCurrencyException {
    for (Currency currency : currencyList.values()) {
      if (currency.isDefault()) {
        return currency;
      }
    }

    throw new MissingDefaultCurrencyException();
  }
}
