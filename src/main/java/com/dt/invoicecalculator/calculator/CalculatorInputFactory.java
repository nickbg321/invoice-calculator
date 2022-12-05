package com.dt.invoicecalculator.calculator;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class CalculatorInputFactory {

  public CalculatorInput buildFromApplicationArgs(ApplicationArguments args) {
    String filePath = getArgumentValue(args.getOptionValues("filePath"));
    String currencyList = getArgumentValue(args.getOptionValues("currencyList"));
    String outputCurrency = getArgumentValue(args.getOptionValues("outputCurrency"));
    String filterByVat = getArgumentValue(args.getOptionValues("filterByVat"));

    if (filterByVat == null) {
      return new CalculatorInput(filePath, currencyList, outputCurrency);
    }

    return new CalculatorInput(filePath, currencyList, outputCurrency, filterByVat);
  }

  private String getArgumentValue(List<String> argumentList) {
    if (argumentList == null || argumentList.isEmpty()) {
      return null;
    }

    return argumentList.get(argumentList.size() - 1);
  }
}
