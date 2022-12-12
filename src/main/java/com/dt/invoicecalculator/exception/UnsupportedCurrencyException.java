package com.dt.invoicecalculator.exception;

public class UnsupportedCurrencyException extends UserException {

  public UnsupportedCurrencyException(String currencyCode) {
    super("Currency " + currencyCode + " is not in the list of supported currencies.");
  }
}
