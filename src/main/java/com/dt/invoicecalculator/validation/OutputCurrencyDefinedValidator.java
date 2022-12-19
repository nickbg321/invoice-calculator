package com.dt.invoicecalculator.validation;

import com.dt.invoicecalculator.dto.CalculatorInputDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public final class OutputCurrencyDefinedValidator implements
    ConstraintValidator<OutputCurrencyDefined, CalculatorInputDto> {

  @Override
  public void initialize(final OutputCurrencyDefined outputCurrencyDefined) {
  }

  @Override
  public boolean isValid(final CalculatorInputDto calculatorInputDto,
      final ConstraintValidatorContext context) {
    if (calculatorInputDto == null) {
      return true;
    }

    return calculatorInputDto.getCurrencyList().contains(calculatorInputDto.getOutputCurrency());
  }
}
