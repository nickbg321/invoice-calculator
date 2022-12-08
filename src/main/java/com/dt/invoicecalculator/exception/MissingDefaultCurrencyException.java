package com.dt.invoicecalculator.exception;

public class MissingDefaultCurrencyException extends Exception {

  public MissingDefaultCurrencyException() {
    super("Default currency has not been specified.");
  }
}
