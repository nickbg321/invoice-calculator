package com.dt.invoicecalculator.calculator;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public final class CalculatorInput {

    @NotBlank
    @NotNull
    private final String filePath;

    @NotBlank
    private final String currencyList;

    @NotBlank
    private final String outputCurrency;

    private String filterByVat;

    public CalculatorInput(final String filePath, final String currencyList, final String outputCurrency) {
        this.filePath = filePath;
        this.currencyList = currencyList;
        this.outputCurrency = outputCurrency;
    }

    public CalculatorInput(final String filePath, final String currencyList, final String outputCurrency, final String filterByVat) {
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
