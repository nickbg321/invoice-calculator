package com.dt.invoicecalculator.calculator;

import com.dt.invoicecalculator.currency.Currency;
import com.dt.invoicecalculator.currency.CurrencyListParser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Component
@Validated
public class CalculatorService {

  @Autowired
  private CurrencyListParser currencyListParser;

  public void calculate(@Valid CalculatorInput inputDto) {
    System.out.println(inputDto.getFilePath());
    System.out.println(inputDto.getCurrencyList());
    System.out.println(inputDto.getOutputCurrency());
    System.out.println(inputDto.getFilterByVat());

    List<Currency> currencies = currencyListParser.parseList("EUR:1,USD:0.987,GBP:0.878");
    for (Currency currency : currencies) {
      System.out.println(
          "Code: " + currency.getCode() + ", Exchange rate: " + currency.getExchangeRate()
              + ", is default: " + currency.isDefault());
    }
  }
}
