package com.dt.invoicecalculator.service.currency;

import com.dt.invoicecalculator.entity.Currency;
import java.math.BigDecimal;
import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component
public final class CurrencyListParser {

  private static final char listDelimiter = ',';
  private static final char itemDelimiter = ':';

  public HashMap<String, Currency> parseList(String list) {
    HashMap<String, Currency> currencies = new HashMap<>();

    String[] items = list.split(String.valueOf(listDelimiter));
    for (String item : items) {
      String[] currencyToRate = item.split(String.valueOf(itemDelimiter));
      if (currencyToRate.length != 2) {
        continue;
      }

      Currency currency = new Currency(currencyToRate[0], new BigDecimal(currencyToRate[1]));
      currencies.put(currencyToRate[0], currency);
    }

    return currencies;
  }
}
