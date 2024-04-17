package pdfmaker;

// Editing Existing PDF Files in Java
// https://www.baeldung.com/java-edit-existing-pdf

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.forms.fields.PdfTextFormField;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.IOException;

public class itext001 {
    public static void main(String[] args) throws IOException {
        PdfReader reader = new PdfReader("src/main/resources/pdftest.pdf");
        PdfWriter writer = new PdfWriter("src/main/resources/pdftest-modified.pdf");
        PdfDocument pdfDocument = new PdfDocument(reader, writer);
        addContentToDocument(pdfDocument);
        pdfDocument.close();
    }

    private static void addContentToDocument(PdfDocument pdfDocument){
        PdfFormField personal = PdfFormField.createEmptyField(pdfDocument);
        personal.setFieldName("information");
        PdfTextFormField name = PdfFormField.createText(pdfDocument, new Rectangle(35, 400, 100, 30), "name", "AAA");
        personal.addKid(name);
        PdfAcroForm.getAcroForm(pdfDocument, true)
                .addField(personal, pdfDocument.getFirstPage());
    }
}
