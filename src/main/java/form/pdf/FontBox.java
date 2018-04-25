package form.pdf;

import org.apache.fontbox.ttf.TTFParser;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class FontBox {
    private static Logger logger = LoggerFactory.getLogger(FontBox.class);
    
   private PDFont regularFont;
   private PDFont boldFont;
   private PDFont italicFont;
   private PDFont boldItalicFont;
   
    public FontBox(PDDocument doc) {
        init(doc);
    }
    
    private void init(PDDocument doc) {
        regularFont = loadFont(doc, "NotoSans-Regular.ttf");
        boldFont = loadFont(doc, "NotoSans-Bold.ttf");
        italicFont = loadFont(doc, "NotoSans-Italic.ttf");
        boldItalicFont = loadFont(doc, "NotoSans-BoldItalic.ttf");
    }
    
    private PDFont loadFont(PDDocument doc, String fontName) {
        try{
            InputStream fontStrm = this.getClass().getClassLoader().getResourceAsStream("font/" + fontName);
            TrueTypeFont ttf = new TTFParser().parse(fontStrm);
            return PDType0Font.load(doc, ttf, true);
        
        } catch(IOException ioEx) {
            logger.error("Font initialization failed:[" + fontName + "]", ioEx);
            return null;
        }
    }
    
    public PDFont getRegularFont() {
        return regularFont;
    }
    
    public PDFont getBoldFont() {
        return boldFont;
    }
    
    public PDFont getItalicFont() {
        return italicFont;
    }
    
    public PDFont getBoldItalicFont() {
        return boldItalicFont;
    }
}
