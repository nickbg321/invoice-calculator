package com.dt.invoicecalculator.dto;

import com.dt.invoicecalculator.validation.FileExists;
import com.dt.invoicecalculator.validation.OutputCurrencyDefined;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@OutputCurrencyDefined
public class CalculatorInputDto {

  @NotBlank
  @FileExists
  private final String filePath;

  @NotBlank
  @Pattern(
      regexp = "^([A-Z]{3}:((\\d+\\.\\d+)|(\\d+)),?)+$",
      message = "Currency list must match the following format: EUR:1,USD:0.987,GBP:0.878"
  )
  @Pattern(
      regexp = "^.*[A-Z]{3}:1(?![0-9.]).*",
      message = "Default currency must be provided"
  )
  private final String currencyList;

  @NotBlank
  @Pattern(
      regexp = "^[A-Z]{3}$",
      message = "Output currency must be a valid ISO 4217 value (BGN or EUR for e.g.)"
  )
  private final String outputCurrency;

  private String filterByVat;

  public CalculatorInputDto(final String filePath, final String currencyList,
      final String outputCurrency) {
    this.filePath = filePath;
    this.currencyList = currencyList;
    this.outputCurrency = outputCurrency;
  }

  public CalculatorInputDto(final String filePath, final String currencyList,
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
