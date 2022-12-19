package com.dt.invoicecalculator.exception;

abstract public class UserException extends Exception {

  public UserException(final String message) {
    super(message);
  }
}
