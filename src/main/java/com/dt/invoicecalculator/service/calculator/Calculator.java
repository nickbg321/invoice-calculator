package com.dt.invoicecalculator.service.calculator;

import com.dt.invoicecalculator.dto.CalculatorInputDto;
import com.dt.invoicecalculator.dto.DocumentDto;
import com.dt.invoicecalculator.service.currency.CurrencyListParser;
import com.dt.invoicecalculator.service.document.DocumentReader;
import com.dt.invoicecalculator.value.Currency;
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

  public Calculator(final CurrencyListParser currencyListParser,
      final DocumentReader documentReader) {
    this.currencyListParser = currencyListParser;
    this.documentReader = documentReader;
  }

  public void calculate(@Valid CalculatorInputDto inputDto) throws FileNotFoundException {
    List<DocumentDto> documentDtos = documentReader.read(inputDto.getFilePath());
    HashMap<String, Currency> currencies = currencyListParser.parseList(inputDto.getCurrencyList());
  }
}
