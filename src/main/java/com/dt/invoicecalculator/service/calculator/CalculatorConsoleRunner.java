package com.dt.invoicecalculator.service.calculator;

import com.dt.invoicecalculator.dto.CalculatorInputDto;
import com.dt.invoicecalculator.dto.factory.CalculatorInputDtoFactory;
import com.dt.invoicecalculator.value.Customer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CalculatorConsoleRunner implements ApplicationRunner {

  private final Calculator calculator;
  private final CalculatorInputDtoFactory calculatorInputDtoFactory;

  public CalculatorConsoleRunner(final Calculator calculator,
      final CalculatorInputDtoFactory calculatorInputDtoFactory) {
    this.calculator = calculator;
    this.calculatorInputDtoFactory = calculatorInputDtoFactory;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    CalculatorInputDto inputDto = calculatorInputDtoFactory.buildFromApplicationArgs(args);
    List<Customer> customers = calculator.calculate(inputDto);

    for (Customer customer : customers) {
      BigDecimal total = customer.getTotal().getAmount().setScale(2, RoundingMode.HALF_UP);
      String currencyCode = customer.getTotal().getCurrency().getCode();

      System.out.println(
          "Customer: " + customer.getName() + ", total: " + total + " " + currencyCode);
    }
  }
}
