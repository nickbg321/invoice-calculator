package com.dt.invoicecalculator.document;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public final class DocumentReader {

  public List<Document> read(String filePath) throws FileNotFoundException {
    return new CsvToBeanBuilder<Document>(new FileReader(filePath)).withType(Document.class).build()
        .parse();
  }
}
