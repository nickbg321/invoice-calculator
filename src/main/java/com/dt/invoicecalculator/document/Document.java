package com.dt.invoicecalculator.document;

import com.opencsv.bean.CsvBindByName;

public final class Document {

  @CsvBindByName(column = "Document number", required = true)
  private int number;

  @CsvBindByName(column = "Customer", required = true)
  private String customerName;

  @CsvBindByName(column = "Vat number")
  private String vatNumber;

  @CsvBindByName(column = "type", required = true)
  private int type;

  @CsvBindByName(column = "Parent document")
  private int parentId;

  @CsvBindByName(column = "Currency", required = true)
  private String currencyCode;

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getVatNumber() {
    return vatNumber;
  }

  public void setVatNumber(String vatNumber) {
    this.vatNumber = vatNumber;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public int getParentId() {
    return parentId;
  }

  public void setParentId(int parentId) {
    this.parentId = parentId;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }
}
