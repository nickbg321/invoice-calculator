package com.dt.invoicecalculator.calculator;

import com.dt.invoicecalculator.currency.Currency;
import com.dt.invoicecalculator.currency.CurrencyListParser;
import com.dt.invoicecalculator.document.Document;
import com.dt.invoicecalculator.document.DocumentReader;
import jakarta.validation.Valid;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class Calculator {

  private final CurrencyListParser currencyListParser;
  private final DocumentReader documentReader;

  public Calculator(final CurrencyListParser currencyListParser, final DocumentReader documentReader) {
    this.currencyListParser = currencyListParser;
    this.documentReader = documentReader;
  }

  public void calculate(@Valid CalculatorInput inputDto) throws FileNotFoundException {
    List<Document> documents = documentReader.read(inputDto.getFilePath());
    HashMap<String, Currency> currencies = currencyListParser.parseList(inputDto.getCurrencyList());

    System.out.println(currencies.get("EUR"));
  }
}
