package com.dt.invoicecalculator.exception;

public class UnsupportedDocumentTypeException extends Exception {

  public UnsupportedDocumentTypeException(int type) {
    super("Document type " + type + " is not supported.");
  }
}
