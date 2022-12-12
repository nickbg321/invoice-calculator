package com.dt.invoicecalculator.exception;

public class MissingDocumentParentException extends UserException {

  public MissingDocumentParentException(int number) {
    super("Parent document with number " + number + " does not exist.");
  }
}
