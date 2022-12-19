package com.dt.invoicecalculator.service.calculator;

import com.dt.invoicecalculator.dto.CalculatorInputDto;
import com.dt.invoicecalculator.dto.factory.CalculatorInputDtoFactory;
import com.dt.invoicecalculator.exception.UserException;
import com.dt.invoicecalculator.value.Customer;
import jakarta.validation.ConstraintViolationException;
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
  public void run(final ApplicationArguments args) throws Exception {
    final CalculatorInputDto inputDto = calculatorInputDtoFactory.buildFromApplicationArgs(args);

    try {
      final List<Customer> customers = calculator.calculate(inputDto);

      for (Customer customer : customers) {
        System.out.println(
            "Customer: " + customer.getName() + ", total: " + customer.getTotal().getAmount()
                .setScale(2, RoundingMode.HALF_UP) + " " + customer.getTotal().getCurrency()
                .getCode());
      }
    } catch (UserException e) {
      System.out.println(e.getMessage());
    } catch (ConstraintViolationException e) {
      e.getConstraintViolations()
          .forEach((constraintViolation) -> System.out.println(constraintViolation.getMessage()));
    }
  }
}
