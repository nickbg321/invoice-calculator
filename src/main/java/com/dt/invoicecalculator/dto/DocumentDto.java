package com.dt.invoicecalculator.dto;

import com.opencsv.bean.CsvBindByName;

public class DocumentDto {

  @CsvBindByName(column = "Document number", required = true)
  private int id;

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

  @CsvBindByName(column = "Total", required = true)
  private String total;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }
}
