package com.dt.invoicecalculator.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.io.File;

public final class FileExistsValidator implements
    ConstraintValidator<FileExists, String> {

  @Override
  public void initialize(final FileExists fileExistsConstraint) {
  }

  @Override
  public boolean isValid(final String filePath, final ConstraintValidatorContext context) {
    if (filePath == null || filePath.isEmpty()) {
      return true;
    }

    return new File(filePath).isFile();
  }
}
