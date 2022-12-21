package com.dt.invoicecalculator.service.currency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.dt.invoicecalculator.exception.MissingDefaultCurrencyException;
import com.dt.invoicecalculator.value.Currency;
import com.dt.invoicecalculator.value.Money;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CurrencyExchangeTest {

  private final static Currency currencyEUR = new Currency("EUR", "1");
  private final static Currency currencyUSD = new Currency("USD", "0.987");
  private final static Currency currencyGBP = new Currency("GBP", "0.878");
  private final CurrencyExchange currencyExchange = new CurrencyExchange();
  private final Currency outputCurrency = currencyGBP;

  private static Stream<Arguments> dataProvider() {
    return Stream.of(
        Arguments.of(new Money(new BigDecimal("50"), currencyGBP), new BigDecimal("50")),
        Arguments.of(new Money(new BigDecimal("50"), currencyEUR), new BigDecimal("43.9")),
        Arguments.of(new Money(new BigDecimal("50"), currencyUSD), new BigDecimal("44.48"))
    );
  }

  @ParameterizedTest
  @MethodSource(value = "dataProvider")
  void currencyIsCorrectlyExchanged(final Money input, final BigDecimal expectedAmount)
      throws MissingDefaultCurrencyException {
    final Map<String, Currency> list = new HashMap<>();
    list.put(currencyEUR.getCode(), currencyEUR);
    list.put(currencyUSD.getCode(), currencyUSD);
    list.put(currencyGBP.getCode(), currencyGBP);

    currencyExchange.setCurrencyList(list);

    final Money result = currencyExchange.exchange(input, outputCurrency);
    final MathContext mathContext = new MathContext(2);

    assertSame(result.getCurrency(), outputCurrency);
    assertEquals(result.getAmount().round(mathContext), expectedAmount.round(mathContext));
  }

  @Test
  void exceptionIsThrownIfNoDefaultCurrency() {
    final Map<String, Currency> list = new HashMap<>();
    list.put(currencyUSD.getCode(), currencyUSD);
    list.put(currencyGBP.getCode(), currencyGBP);

    currencyExchange.setCurrencyList(list);

    assertThrows(MissingDefaultCurrencyException.class,
        () -> currencyExchange.exchange(new Money(currencyUSD), currencyGBP));
  }
}
