package com.dt.invoicecalculator.currency.validation;

import com.dt.invoicecalculator.calculator.CalculatorInput;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OutputCurrencyDefinedValidator implements
    ConstraintValidator<OutputCurrencyDefined, CalculatorInput> {

  @Override
  public void initialize(OutputCurrencyDefined outputCurrencyDefined) {
  }

  @Override
  public boolean isValid(CalculatorInput calculatorInput, ConstraintValidatorContext cxt) {
    if (calculatorInput == null) {
      return true;
    }

    return calculatorInput.getCurrencyList().contains(calculatorInput.getOutputCurrency());
  }
}
