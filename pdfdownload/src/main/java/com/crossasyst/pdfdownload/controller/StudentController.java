package com.crossasyst.pdfdownload.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import com.crossasyst.pdfdownload.generator.PdfGenerator;
import com.crossasyst.pdfdownload.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import com.lowagie.text.DocumentException;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students/pdf")
    public void downloadPdfFile(HttpServletResponse httpServletResponse) throws DocumentException, IOException
    {
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=student-data.pdf");
        PdfGenerator generator = new PdfGenerator(studentService);
        generator.fileGenerator(httpServletResponse);
    }
}