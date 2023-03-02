package com.crossasyst.pdfdownload.generator;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.crossasyst.pdfdownload.entity.StudentEntity;
import com.crossasyst.pdfdownload.service.StudentService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

@Component
public class PdfGenerator {


    private final StudentService studentService;

    public PdfGenerator(StudentService studentService) {
        this.studentService = studentService;
    }

    public void fileGenerator(HttpServletResponse response) throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setSize(20);

        Paragraph paragraph = new Paragraph("List of the Students", font);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new int[] {3,3,3,3});
        table.setSpacingBefore(5);

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(CMYKColor.white);
        cell.setPadding(5);

        Font textFont = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);

        cell.setPhrase(new Phrase("ID", textFont));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Student Name", textFont));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Email", textFont));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Mobile No", textFont));

        table.addCell(cell);
        List <StudentEntity> studentEntityList=studentService.getStudentList();

        for (StudentEntity student: studentEntityList) {
            table.addCell(String.valueOf(student.getId()));
            table.addCell(student.getStudentName());
            table.addCell(student.getEmail());
            table.addCell(student.getMobileNo());
        }

        document.add(table);
        document.close();
    }
}