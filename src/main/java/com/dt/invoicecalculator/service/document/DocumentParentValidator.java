package com.dt.invoicecalculator.service.document;

import com.dt.invoicecalculator.dto.DocumentDto;
import com.dt.invoicecalculator.exception.MissingDocumentParentException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DocumentParentValidator {

  public void validateParents(final List<DocumentDto> documentDtos) throws Exception {
    final List<Integer> specifiedIds = new ArrayList<>();
    final List<Integer> availableIds = new ArrayList<>();

    for (DocumentDto documentDto : documentDtos) {
      switch (DocumentType.valueOf(documentDto.getType())) {
        case INVOICE -> availableIds.add(documentDto.getId());
        case CREDIT_NOTE, DEBIT_NOTE -> specifiedIds.add(documentDto.getParentId());
      }
    }

    for (int id : specifiedIds) {
      if (!availableIds.contains(id)) {
        throw new MissingDocumentParentException(id);
      }
    }
  }
}
