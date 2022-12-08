package com.dt.invoicecalculator.dto.factory;

import com.dt.invoicecalculator.dto.CalculatorInputDto;
import java.util.List;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public final class CalculatorInputDtoFactory {

  public CalculatorInputDto buildFromApplicationArgs(ApplicationArguments args) {
    String filePath = getArgumentValue(args.getOptionValues("filePath"));
    String currencyList = getArgumentValue(args.getOptionValues("currencyList"));
    String outputCurrency = getArgumentValue(args.getOptionValues("outputCurrency"));
    String filterByVat = getArgumentValue(args.getOptionValues("filterByVat"));

    if (filterByVat == null) {
      return new CalculatorInputDto(filePath, currencyList, outputCurrency);
    }

    return new CalculatorInputDto(filePath, currencyList, outputCurrency, filterByVat);
  }

  private String getArgumentValue(List<String> argumentList) {
    if (argumentList == null || argumentList.isEmpty()) {
      return null;
    }

    return argumentList.get(argumentList.size() - 1);
  }
}
