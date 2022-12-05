package com.dt.invoicecalculator.currency;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public final class CurrencyListParser {

  private static final char listDelimiter = ',';
  private static final char itemDelimiter = ':';

  public List<Currency> parseList(String list) {
    List<Currency> currencies = new ArrayList<>();

    String[] items = list.split(String.valueOf(listDelimiter));
    for (String item : items) {
      String[] currencyToRate = item.split(String.valueOf(itemDelimiter));
      if (currencyToRate.length != 2) {
        continue;
      }

      currencies.add(new Currency(currencyToRate[0], new BigDecimal(currencyToRate[1])));
    }

    return currencies;
  }
}
