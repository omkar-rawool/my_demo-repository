package com.crossasyst.opencsv.service;

import com.crossasyst.opencsv.entity.PersonEntity;
import com.crossasyst.opencsv.generator.Generator;
import com.crossasyst.opencsv.repository.PersonRepository;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {


    private final PersonRepository personRepository;
    private final Generator generator;


    public List<PersonEntity> findAllPersons(HttpServletResponse httpServletResponse) throws IOException {


        generator.csvGenerator(httpServletResponse);

        return personRepository.findAll();
    }

    public void getIntoCSV() throws IOException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter("personData.csv"));
        List<PersonEntity> rows=personRepository.findAll();
       //csvWriter.writeAll(rows);
    }
}
