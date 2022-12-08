package com.dt.invoicecalculator.value;

public class Customer {

  private final String name;
  private final Money total;

  public Customer(String name, Money total) {
    this.name = name;
    this.total = total;
  }

  public String getName() {
    return name;
  }

  public Money getTotal() {
    return total;
  }
}
