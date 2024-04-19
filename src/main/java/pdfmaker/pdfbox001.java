package pdfmaker;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

public class pdfbox001 {

    public static void main(String[] args) throws IOException {
        // Specify the existing PDF and output PDF paths
        String existingPdf = "src/main/resources/input.pdf";
        String outputPdf = "src/main/resources/output.pdf";

        // Load the existing PDF document
        PDDocument document = PDDocument.load(new File(existingPdf));

        // Create a new AcroForm (interactive form) for the document, if it doesn't exist
        PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
        if (acroForm == null) {
            acroForm = new PDAcroForm(document);
            document.getDocumentCatalog().setAcroForm(acroForm);
        }

        // Define the text field properties
        float x = 100; // X-coordinate of the field (adjust as needed)
        float y = 500; // Y-coordinate of the field (adjust as needed)
        float width = 200; // Width of the field (adjust as needed)
        float height = 50; // Height of the field (adjust as needed)
        String fieldName = "MyTextField"; // Any unique name for the field

        // Create a PDF text field object
        PDTextField textField = new PDTextField(acroForm);

        // Set the field's default value (optional)
        textField.setValue("");  // Set an initial value for the text field

        // Set the field's name using a more reliable method (works consistently across versions)
        acroForm.getField(fieldName);  // Create if it doesn't exist
        // Set the field's location and size
        COSDictionary fieldDict = textField.getCOSObject();
        COSArray rect = new COSArray();
        rect.add(new COSFloat(x));
        rect.add(new COSFloat(y));
        rect.add(new COSFloat(x + width));
        rect.add(new COSFloat(y + height));
        fieldDict.setItem(COSName.RECT, rect);

        // Add the field to the AcroForm (not strictly necessary in this case)
        // acroForm.getFields().add(textField);

        // Save the modified PDF document
        document.save(new File(outputPdf));
        document.close();

        System.out.println("Text field added to PDF successfully!");
    }
}
