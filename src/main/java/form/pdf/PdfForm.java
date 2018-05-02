package form.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import utils.Pair;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

public abstract class PdfForm {
    private static Logger logger = LoggerFactory.getLogger(PdfForm.class);

    private FontBox fonts;
    private ImageBox images;
    private OrderFormBean bean;
    private MessageSource messageSource; 
    
    public Optional<PDDocument> createForm(OrderFormBean bean, MessageSource messageSource, PDRectangle docRec, int pageAmount, File docFile) {
        this.bean = bean;
        this.messageSource = messageSource;
        try {
            try (PDDocument doc = createDocument(docRec, pageAmount);) {
                doc.save(docFile);
                return Optional.of(doc);
            }
        } catch (IOException ioEx) {
            logger.error("Creating pdf document failed", ioEx);
            return Optional.empty();
        }
    }

    public Optional<PDDocument> createForm(OrderFormBean bean, MessageSource messageSource, PDRectangle docRec, int pageAmount, OutputStream outStream) {
        this.bean = bean;
        this.messageSource = messageSource;
        try {
            try (PDDocument doc = createDocument(docRec, pageAmount);) {
                doc.save(outStream);
                return Optional.of(doc);
            }
        } catch (IOException ioEx) {
            logger.error("Creating pdf document failed", ioEx);
            return Optional.empty();
        }
    }

    
    protected PDDocument createDocument(PDRectangle docRec, int pageAmount) throws IOException {
        PDDocument doc = new PDDocument();
        fonts = new FontBox(doc);
        images = new ImageBox(doc);
        for(int i=0; i < pageAmount; i++) {
            PDPage page = new PDPage(docRec);
            doc.addPage(page);
            PDPageContentStream cos = new PDPageContentStream(doc, page);
            drawPage(cos, page.getMediaBox(), i);
        }
        return doc;
    }

    protected FontBox getDefaultFonts() {
        return fonts;
    }

    protected ImageBox getImages() {
        return images;
    }
    
    protected OrderFormBean getBean() {
        return bean;
    }
    
    protected MessageSource getMessageSource() {
        return messageSource;
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

    
    protected float getHorizonalCenteredX(String text, PDFont font, int fontSize, PDRectangle rect) throws IOException {
        Pair<Float, Float> textSpace = getTextSpace(text, font, fontSize);
        float diffX = rect.getWidth() - textSpace.getRight();
        float shiftX = diffX < 0 ? 0 : diffX / 2;
        float x = rect.getLowerLeftX() + shiftX;
        return x;
    }
    
    protected float getHorizontalRightShiftedX(String text, PDFont font, int fontSize, PDRectangle rect) throws IOException {
        Pair<Float, Float> textSpace = getTextSpace(text, font, fontSize);
        float diffX = rect.getWidth() - textSpace.getRight();
        float x = rect.getLowerLeftX() + diffX;
        return x;
    }
    
    protected abstract void drawPage(PDPageContentStream cos, PDRectangle docRect, int pageNum) throws IOException;

}
