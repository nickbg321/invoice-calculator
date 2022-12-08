package com.dt.invoicecalculator.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.io.File;

public final class FileExistsValidator implements
    ConstraintValidator<FileExists, String> {

  @Override
  public void initialize(FileExists fileExistsConstraint) {
  }

  @Override
  public boolean isValid(String filePath, ConstraintValidatorContext cxt) {
    if (filePath == null || filePath.isEmpty()) {
      return true;
    }

    return new File(filePath).isFile();
  }
}
