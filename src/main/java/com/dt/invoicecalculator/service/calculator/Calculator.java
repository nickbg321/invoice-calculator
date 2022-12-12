package com.dt.invoicecalculator.service.calculator;

import com.dt.invoicecalculator.dto.CalculatorInputDto;
import com.dt.invoicecalculator.dto.DocumentDto;
import com.dt.invoicecalculator.exception.UnsupportedCurrencyException;
import com.dt.invoicecalculator.service.currency.CurrencyExchange;
import com.dt.invoicecalculator.service.currency.CurrencyListParser;
import com.dt.invoicecalculator.service.document.CsvDocumentReader;
import com.dt.invoicecalculator.service.document.DocumentParentValidator;
import com.dt.invoicecalculator.service.document.DocumentReaderInterface;
import com.dt.invoicecalculator.service.document.DocumentType;
import com.dt.invoicecalculator.value.Currency;
import com.dt.invoicecalculator.value.Customer;
import com.dt.invoicecalculator.value.Money;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class Calculator {

  private final CurrencyListParser currencyListParser;
  private final DocumentReaderInterface documentReaderInterface;
  private final CurrencyExchange currencyExchange;
  private final DocumentParentValidator documentParentValidator;

  public Calculator(final CurrencyListParser currencyListParser,
      final CsvDocumentReader documentReaderInterface, final CurrencyExchange currencyExchange,
      final DocumentParentValidator documentParentValidator) {
    this.currencyListParser = currencyListParser;
    this.documentReaderInterface = documentReaderInterface;
    this.currencyExchange = currencyExchange;
    this.documentParentValidator = documentParentValidator;
  }

  public List<Customer> calculate(@Valid CalculatorInputDto inputDto) throws Exception {
    List<DocumentDto> documentDtos = documentReaderInterface.read(inputDto.getFilePath());
    HashMap<String, Currency> currencies = currencyListParser.parseList(inputDto.getCurrencyList());
    Currency outputCurrency = currencies.get(inputDto.getOutputCurrency());

    currencyExchange.setCurrencyList(currencies);
    documentParentValidator.checkDocumentParents(documentDtos);

    HashMap<String, Money> totalPerCustomer = new HashMap<>();
    for (DocumentDto documentDto : documentDtos) {
      if (inputDto.getFilterByVat() != null && !inputDto.getFilterByVat()
          .equals(documentDto.getVatNumber())) {
        continue;
      }

      if (currencies.get(documentDto.getCurrencyCode()) == null) {
        throw new UnsupportedCurrencyException(documentDto.getCurrencyCode());
      }

      Money exchangedMoney = currencyExchange.exchange(
          new Money(documentDto.getTotal(), currencies.get(documentDto.getCurrencyCode())),
          outputCurrency);

      if (!totalPerCustomer.containsKey(documentDto.getCustomerName())) {
        totalPerCustomer.put(documentDto.getCustomerName(), new Money(outputCurrency));
      }

      Money total = totalPerCustomer.get(documentDto.getCustomerName());
      switch (DocumentType.valueOf(documentDto.getType())) {
        case DEBIT_NOTE, INVOICE ->
            totalPerCustomer.put(documentDto.getCustomerName(), total.add(exchangedMoney));
        case CREDIT_NOTE ->
            totalPerCustomer.put(documentDto.getCustomerName(), total.subtract(exchangedMoney));
      }
    }

    List<Customer> customers = new ArrayList<>();
    totalPerCustomer.forEach((name, total) -> customers.add(new Customer(name, total)));

    return customers;
  }
}
