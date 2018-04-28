package form.pdf;

import org.apache.fontbox.ttf.TTFParser;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class TestOrderForm {
    private static Logger logger = LoggerFactory.getLogger(TestOrderForm.class);
    
    
    public void createForm() {
        try {
            PDDocument doc = createDoc();
            PDPage page =  doc.getPage(0);
            PDPageContentStream cos = new PDPageContentStream(doc, page);        
            //drawPage(cos, page.getMediaBox());

            doc.save(new File("/home/igor/JProjects/diplom/work/TestPdf.pdf"));
            doc.close();
        } catch(IOException ioEx) {
            logger.error(ioEx.toString(), ioEx);
        }
    }
    
    
    private void drawPage(PDPageContentStream cos, PDRectangle docRect, PDFont fontRu) throws IOException {
        int lineNum = 0;
        
        cos.beginText();
        cos.setFont(fontRu, 12);
            
        cos.endText();
        
        cos.beginText();
        //cos.setFont(fontItalic, 14);
        cos.setFont(fontRu, 14);
        cos.newLineAtOffset(100, docRect.getHeight() - 50 * (++lineNum));
        cos.showText("Русский фонт Line number one");
        cos.endText();
        
        cos.beginText();
        cos.setFont(fontRu, 14);
        cos.newLineAtOffset(100, docRect.getHeight() - 50 * (++lineNum));
        cos.showText("Line numberr two");
        cos.endText();

        cos.setLineWidth(2);
        cos.moveTo(200, 250);
        cos.lineTo(400, 250);
        cos.closeAndStroke();
        cos.setLineWidth(5);
        cos.moveTo(200, 300);
        cos.lineTo(400, 300);
        cos.closeAndStroke();
        
        
        // add an image
//        try {
//            PDImageXObject ximage = PDImageXObject.createFromFile("Simple.jpg", doc);
//            float scale = 0.5f; // alter this value to set the image size
//            cos.drawImage(ximage, 100, 400, ximage.getWidth()*scale, ximage.getHeight()*scale);
//        } catch (IOException ioex) {
//            System.out.println("No image for you");
//        }
        
        cos.close();
    }
    
    
    private PDDocument createDoc() {
        PDDocument doc = new PDDocument();
        //PDPage page = new PDPage(PDRectangle.A4);
        PDPage page = new PDPage(new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()));
        doc.addPage(page);
        return doc;
    }
    
    
    public static void main(String[] args) throws Exception {
        TestOrderForm of = new TestOrderForm();
        of.createForm();
    }
}
