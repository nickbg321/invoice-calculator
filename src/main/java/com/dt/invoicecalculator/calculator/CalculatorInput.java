package com.dt.invoicecalculator.calculator;

import com.dt.invoicecalculator.document.validation.FileExists;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public final class CalculatorInput {

  @NotBlank
  @FileExists
  private final String filePath;

  @NotBlank
  @Pattern(
      regexp = "^([A-Z]{3}:((\\d+\\.\\d+)|(\\d+)),?)+$",
      message = "Currency list must match the following format: EUR:1,USD:0.987,GBP:0.878"
  )
//  @Pattern(
//      regexp = "",
//      message = "Default currency must be provided"
//  )
  private final String currencyList;

  @NotBlank
  @Pattern(
      regexp = "^[A-Z]{3}$",
      message = "Output currency must be a valid ISO 4217 value (BGN or EUR for e.g.)"
  )
  private final String outputCurrency;

  private String filterByVat;

  public CalculatorInput(final String filePath, final String currencyList,
      final String outputCurrency) {
    this.filePath = filePath;
    this.currencyList = currencyList;
    this.outputCurrency = outputCurrency;
  }

  public CalculatorInput(final String filePath, final String currencyList,
      final String outputCurrency, final String filterByVat) {
    this(filePath, currencyList, outputCurrency);
    this.filterByVat = filterByVat;
  }

  public String getFilePath() {
    return filePath;
  }

  public String getCurrencyList() {
    return currencyList;
  }

  public String getOutputCurrency() {
    return outputCurrency;
  }

  public String getFilterByVat() {
    return filterByVat;
  }
}
