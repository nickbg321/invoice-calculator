package com.dt.invoicecalculator.exception;

public class DifferentCurrencyException extends Exception {

  public DifferentCurrencyException() {
    super("Money operations can only be performed on the same currency.");
  }
}
