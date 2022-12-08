package com.dt.invoicecalculator.service.document;

import com.dt.invoicecalculator.dto.DocumentDto;
import java.util.List;

public interface DocumentReaderInterface {

  List<DocumentDto> read(String filePath) throws Exception;
}
