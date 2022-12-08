package com.dt.invoicecalculator.validation;

import com.dt.invoicecalculator.dto.CalculatorInputDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OutputCurrencyDefinedValidator implements
    ConstraintValidator<OutputCurrencyDefined, CalculatorInputDto> {

  @Override
  public void initialize(OutputCurrencyDefined outputCurrencyDefined) {
  }

  @Override
  public boolean isValid(CalculatorInputDto calculatorInputDto, ConstraintValidatorContext cxt) {
    if (calculatorInputDto == null) {
      return true;
    }

    return calculatorInputDto.getCurrencyList().contains(calculatorInputDto.getOutputCurrency());
  }
}
