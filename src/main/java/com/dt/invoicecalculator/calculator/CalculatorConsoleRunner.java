package com.dt.invoicecalculator.calculator;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
public class CalculatorConsoleRunner implements ApplicationRunner {

  private final CalculatorService calculatorService;
  private final CalculatorInputFactory calculatorInputFactory;

  public CalculatorConsoleRunner(final CalculatorService calculatorService,
      final CalculatorInputFactory calculatorInputFactory) {
    this.calculatorService = calculatorService;
    this.calculatorInputFactory = calculatorInputFactory;
  }

  @Override
  public void run(ApplicationArguments args) throws FileNotFoundException {
    CalculatorInput inputDto = calculatorInputFactory.buildFromApplicationArgs(args);
    calculatorService.calculate(inputDto);
  }
}
