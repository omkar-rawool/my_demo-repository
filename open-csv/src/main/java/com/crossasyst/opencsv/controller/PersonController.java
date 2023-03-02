package com.crossasyst.opencsv.controller;

import com.crossasyst.opencsv.entity.PersonEntity;
import com.crossasyst.opencsv.service.PersonService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(path = "/persons/csv")
    public ResponseEntity<Void> downloadCSV(HttpServletResponse httpServletResponse) throws IOException {

        personService.findAllPersons(httpServletResponse);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    public ResponseEntity<Void> getAllDataInCSV() throws IOException {
        personService.getIntoCSV();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
