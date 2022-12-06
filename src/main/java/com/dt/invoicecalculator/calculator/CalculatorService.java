package com.dt.invoicecalculator.calculator;

import com.dt.invoicecalculator.currency.Currency;
import com.dt.invoicecalculator.currency.CurrencyListParser;
import com.dt.invoicecalculator.document.Document;
import com.dt.invoicecalculator.document.DocumentReader;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.io.FileNotFoundException;
import java.util.List;

@Component
@Validated
public class CalculatorService {

  private final CurrencyListParser currencyListParser;
  private final DocumentReader documentReader;

  public CalculatorService(final CurrencyListParser currencyListParser, final DocumentReader documentReader) {
    this.currencyListParser = currencyListParser;
    this.documentReader = documentReader;
  }

  public void calculate(@Valid CalculatorInput inputDto) throws FileNotFoundException {
    System.out.println(inputDto.getFilePath());
    System.out.println(inputDto.getCurrencyList());
    System.out.println(inputDto.getOutputCurrency());
    System.out.println(inputDto.getFilterByVat());

    List<Currency> currencies = currencyListParser.parseList(inputDto.getCurrencyList());
    for (Currency currency : currencies) {
      System.out.println(
          "Code: " + currency.getCode() + ", Exchange rate: " + currency.getExchangeRate()
              + ", is default: " + currency.isDefault());
    }

    List<Document> documents = documentReader.read(inputDto.getFilePath());

    for (Document document: documents) {
      System.out.println("Number: " + document.getNumber() + ", vendor: " + document.getCustomerName());
    }
  }
}
