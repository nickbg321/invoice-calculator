package com.dt.invoicecalculator.service.currency;

import com.dt.invoicecalculator.value.Currency;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class CurrencyListParser {

  private static final char listDelimiter = ',';
  private static final char itemDelimiter = ':';

  public Map<String, Currency> parseList(final String list) {
    final Map<String, Currency> currencies = new HashMap<>();

    String[] items = list.split(String.valueOf(listDelimiter));
    for (String item : items) {
      String[] currencyToRate = item.split(String.valueOf(itemDelimiter));
      if (currencyToRate.length != 2) {
        continue;
      }

      Currency currency = new Currency(currencyToRate[0], currencyToRate[1]);
      currencies.put(currencyToRate[0], currency);
    }

    return currencies;
  }
}
