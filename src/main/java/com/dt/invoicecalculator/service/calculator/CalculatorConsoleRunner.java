package com.dt.invoicecalculator.service.calculator;

import com.dt.invoicecalculator.dto.CalculatorInputDto;
import com.dt.invoicecalculator.dto.factory.CalculatorInputDtoFactory;
import java.io.FileNotFoundException;
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
  public void run(ApplicationArguments args) throws FileNotFoundException {
    CalculatorInputDto input = calculatorInputDtoFactory.buildFromApplicationArgs(args);
    calculator.calculate(input);
  }
}
