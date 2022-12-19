package com.dt.invoicecalculator.service.document;

import com.dt.invoicecalculator.dto.DocumentDto;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public final class CsvDocumentReader implements DocumentReaderInterface {

  public List<DocumentDto> read(final String filePath) throws FileNotFoundException {
    return new CsvToBeanBuilder<DocumentDto>(new FileReader(filePath)).withType(DocumentDto.class)
        .build()
        .parse();
  }
}
