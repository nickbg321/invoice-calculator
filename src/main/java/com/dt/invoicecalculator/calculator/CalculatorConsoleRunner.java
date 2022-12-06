package com.dt.invoicecalculator.calculator;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
public class CalculatorConsoleRunner implements ApplicationRunner {

  private final Calculator calculator;
  private final CalculatorInputFactory calculatorInputFactory;

  public CalculatorConsoleRunner(final Calculator calculator,
      final CalculatorInputFactory calculatorInputFactory) {
    this.calculator = calculator;
    this.calculatorInputFactory = calculatorInputFactory;
  }

  @Override
  public void run(ApplicationArguments args) throws FileNotFoundException {
    CalculatorInput input = calculatorInputFactory.buildFromApplicationArgs(args);
    calculator.calculate(input);
  }
}
