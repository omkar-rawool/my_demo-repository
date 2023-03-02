package com.crossasyst.opencsv.generator;

import com.crossasyst.opencsv.entity.PersonEntity;
import com.crossasyst.opencsv.repository.PersonRepository;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class Generator {

    private final PersonRepository personRepository;

    public void csvGenerator(HttpServletResponse httpServletResponse) throws IOException {
        StatefulBeanToCsv<PersonEntity> writer = new StatefulBeanToCsvBuilder<PersonEntity>(httpServletResponse.getWriter()).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR).build();
        httpServletResponse.setContentType("csv");
        httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=Person-data.csv");
        try {
            writer.write(personRepository.findAll());
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            throw new RuntimeException(e);
        }
    }
}
