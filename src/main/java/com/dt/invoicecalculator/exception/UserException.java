package com.dt.invoicecalculator.exception;

abstract public class UserException extends Exception {

  public UserException(String message) {
    super(message);
  }
}
