package com.dt.invoicecalculator.exception;

public class UnsupportedDocumentTypeException extends UserException {

  public UnsupportedDocumentTypeException(final int type) {
    super("Document type " + type + " is not supported.");
  }
}
