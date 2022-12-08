package com.dt.invoicecalculator.service.calculator;

import com.dt.invoicecalculator.dto.CalculatorInputDto;
import com.dt.invoicecalculator.dto.DocumentDto;
import com.dt.invoicecalculator.service.currency.CurrencyListParser;
import com.dt.invoicecalculator.service.document.CsvDocumentReader;
import com.dt.invoicecalculator.service.document.DocumentReaderInterface;
import com.dt.invoicecalculator.value.Currency;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class Calculator {

  private final CurrencyListParser currencyListParser;
  private final DocumentReaderInterface documentReaderInterface;

  public Calculator(final CurrencyListParser currencyListParser,
      final CsvDocumentReader documentReaderInterface) {
    this.currencyListParser = currencyListParser;
    this.documentReaderInterface = documentReaderInterface;
  }

  public void calculate(@Valid CalculatorInputDto inputDto) throws Exception {
    List<DocumentDto> documentDtos = documentReaderInterface.read(inputDto.getFilePath());
    HashMap<String, Currency> currencies = currencyListParser.parseList(inputDto.getCurrencyList());
  }
}
