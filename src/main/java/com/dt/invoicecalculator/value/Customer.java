package com.dt.invoicecalculator.value;

import lombok.Getter;

@Getter
public class Customer {

  private final String name;
  private final Money total;

  public Customer(String name, Money total) {
    this.name = name;
    this.total = total;
  }
}
