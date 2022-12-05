package com.dt.invoicecalculator.document;

public enum DocumentType {
  INVOICE(1),
  CREDIT_NOTE(2),
  DEBIT_NOTE(3);

  private final int type;

  DocumentType(final int type) {
    this.type = type;
  }

  public int getType() {
    return type;
  }
}