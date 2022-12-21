package com.dt.invoicecalculator.service.document;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.dt.invoicecalculator.dto.DocumentDto;
import com.dt.invoicecalculator.exception.MissingDocumentParentException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DocumentParentValidatorTest {

  private final DocumentParentValidator documentParentValidator = new DocumentParentValidator();

  @Test
  void correctDocumentsPassValidation() throws Exception {
    final List<DocumentDto> documents = new ArrayList<>();

    final DocumentDto document1 = new DocumentDto();
    document1.setType(1);
    document1.setId(100);
    documents.add(document1);

    final DocumentDto document2 = new DocumentDto();
    document2.setType(2);
    document2.setParentId(100);
    documents.add(document2);

    final DocumentDto document3 = new DocumentDto();
    document3.setType(1);
    document1.setId(100);
    documents.add(document3);

    documentParentValidator.validateParents(documents);
  }

  @Test
  void exceptionIsThrownIfParentIsMissing() {
    final List<DocumentDto> documents = new ArrayList<>();

    final DocumentDto document1 = new DocumentDto();
    document1.setType(1);
    document1.setId(100);
    documents.add(document1);

    final DocumentDto document2 = new DocumentDto();
    document2.setType(2);
    document2.setParentId(101);
    documents.add(document2);

    assertThrows(MissingDocumentParentException.class, () -> {
      documentParentValidator.validateParents(documents);
    });
  }
}
