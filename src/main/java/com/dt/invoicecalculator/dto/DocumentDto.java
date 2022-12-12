package com.dt.invoicecalculator.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
