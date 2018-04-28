package form.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class ImageBox {
    private static Logger logger = LoggerFactory.getLogger(ImageBox.class);
    
    private PDImageXObject checkOnImg;
    private PDImageXObject checkOffImg;
    
    public ImageBox(PDDocument doc) {
        init(doc);
    }
    
    private void init(PDDocument doc) {
        checkOffImg = loadImage("checkedOff.png", doc);
        checkOnImg = loadImage("checkedOn.png", doc);
    }
    
    private PDImageXObject loadImage(String imgName, PDDocument doc) {
        try{
            InputStream inStrm = this.getClass().getClassLoader().getResourceAsStream("img/" + imgName);
            byte[] imgArr = new byte[inStrm.available()];
            inStrm.read(imgArr, 0, inStrm.available());
            PDImageXObject ximage = PDImageXObject.createFromByteArray(doc, imgArr, imgName);
            return ximage;
        } catch(IOException ioEx) {
            logger.error("Image loading error", ioEx);
            return null;
        }
    }

    
    public PDImageXObject getCheckedOnImg() {
        return checkOnImg;
    }
    
    public PDImageXObject getCheckedOffImg() {
        return checkOffImg;
    }
}
