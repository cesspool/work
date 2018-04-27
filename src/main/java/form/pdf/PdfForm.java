package form.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Pair;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public abstract class PdfForm {
    private static Logger logger = LoggerFactory.getLogger(PdfForm.class);

    private FontBox fonts;
    private ImageBox images;
    
    public Optional<PDDocument> createForm(PDRectangle docRec, int pageAmount) {
        try {
            try (PDDocument doc = createDocument(docRec, pageAmount);) {
                fonts = new FontBox(doc);
                images = new ImageBox(doc);
                int pageNum = 0;
                for (PDPage page : doc.getPages()) {
                    PDPageContentStream cos = new PDPageContentStream(doc, page);
                    drawPage(cos, page.getMediaBox(), ++pageNum);
                }
                doc.save(new File("OrderForm.pdf"));
                return Optional.of(doc);
            }
        } catch (IOException ioEx) {
            logger.error("Creating pdf document failed", ioEx);
            return Optional.empty();
        }
    }

    protected PDDocument createDocument(PDRectangle docRec, int pageAmount) {
        PDDocument doc = new PDDocument();
        for(int i=0; i < pageAmount; i++) {
            PDPage page = new PDPage(docRec);
            doc.addPage(page);
        }
        return doc;
    }

    protected FontBox getDefaultFonts() {
        return fonts;
    }

    protected ImageBox getImages() {
        return images;
    }
    
    protected void drawText(String text, PDPageContentStream cos, PDFont font, int fontSize, float tx, float ty) throws IOException {
        cos.beginText();
        cos.setFont(font, fontSize);
        cos.newLineAtOffset(tx, ty);
        cos.showText(text);
        cos.endText();
    }
    
    /**
     * 
     * @param text
     * @param font
     * @param fontSize
     * @return left - height, right - width 
     * @throws IOException
     */
    protected Pair<Float,Float> getTextSpace(String text, PDFont font, float fontSize) throws IOException {
     // Get the non-justified string width in text space units.
        float stringWidth = font.getStringWidth(text)/1000f * fontSize;
        // Get the string height in text space units.
        float stringHeight = font.getFontDescriptor().getFontBoundingBox().getHeight()/1000f * fontSize;
        return new Pair<Float, Float>(stringHeight, stringWidth);
    }

    
    protected float getHorizonalCenteredX(String text, PDFont font, float fontSize, PDRectangle rect) throws IOException {
        Pair<Float, Float> textSpace = getTextSpace(text, font, fontSize);
        float diffX = rect.getWidth() - textSpace.getRight();
        float shiftX = diffX < 0 ? 0 : diffX / 2;
        float x = rect.getLowerLeftX() + shiftX;
        return x;
    }
    
    
    protected abstract void drawPage(PDPageContentStream cos, PDRectangle docRect, int pageNum) throws IOException;

}
