package com.dt.invoicecalculator.service.document;

import com.dt.invoicecalculator.exception.UnsupportedDocumentTypeException;
import lombok.Getter;

@Getter
public enum DocumentType {
  INVOICE(1),
  CREDIT_NOTE(2),
  DEBIT_NOTE(3);

  private final int type;

  DocumentType(final int type) {
    this.type = type;
  }

  public static DocumentType valueOf(final int type) throws UnsupportedDocumentTypeException {
    for (DocumentType documentType : values()) {
      if (documentType.getType() == type) {
        return documentType;
      }
    }

    throw new UnsupportedDocumentTypeException(type);
  }
}
