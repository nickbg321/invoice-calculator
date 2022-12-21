package com.dt.invoicecalculator.service.currency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dt.invoicecalculator.value.Currency;
import java.math.BigDecimal;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class CurrencyListParserTest {

  private final CurrencyListParser currencyListParser = new CurrencyListParser();

  @Test
  void currencyListIsCorrectlyParsed() {
    final String list = "EUR:1,USD:0.987,GBP:0.878,BGN,RON:0.776:0.888";
    final Map<String, Currency> currencies = currencyListParser.parseList(list);

    assertEquals(currencies.size(), 3);

    assertTrue(currencies.containsKey("EUR"));
    assertEquals(currencies.get("EUR").getCode(), "EUR");
    assertTrue(currencies.get("EUR").isDefault());
    assertEquals(currencies.get("EUR").getExchangeRate().compareTo(new BigDecimal("1")), 0);

    assertTrue(currencies.containsKey("USD"));
    assertEquals(currencies.get("USD").getCode(), "USD");
    assertFalse(currencies.get("USD").isDefault());
    assertEquals(currencies.get("USD").getExchangeRate().compareTo(new BigDecimal("0.987")), 0);

    assertTrue(currencies.containsKey("GBP"));
    assertEquals(currencies.get("GBP").getCode(), "GBP");
    assertFalse(currencies.get("GBP").isDefault());
    assertEquals(currencies.get("GBP").getExchangeRate().compareTo(new BigDecimal("0.878")), 0);
  }
}
