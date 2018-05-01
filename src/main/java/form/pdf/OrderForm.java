package form.pdf;

import form.pdf.OrderFormBean.RoutePart;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.support.GenericApplicationContext;
import utils.Pair;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class OrderForm extends PdfForm {
    private static Logger logger = LoggerFactory.getLogger(OrderForm.class);
    private MessageSource messageSource;
    
    public void buildForm(OrderFormBean bean, MessageSource messageSource) {
        this.messageSource = messageSource;
        File docFile = new File("OrderForm.pdf");
        PDDocument doc = createForm(bean, messageSource, new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()), 1, docFile).orElse(null);
    }
    
    //docRect-> height:595.27563 width: 841.8898 UpperRightX: 841.8898 UpperRightY: 595.27563 LowerLeftX: 0.0 LowerLeftY: 0.0
    protected void drawPage(PDPageContentStream cos, PDRectangle docRect, int pageNum)  throws IOException {
        PDRectangle headerRect = new PDRectangle(265, 495, 310, 65);
        drawHeader(cos, headerRect);
        PDRectangle bodyRect = new PDRectangle(57, 200, 722, 269);
        drawBody(cos, bodyRect);
        PDRectangle footerRect = new PDRectangle(57, 50, 722, 150);
        drawFooter(cos, footerRect);
        cos.close();
    }

    
    private void drawHeader(PDPageContentStream cos, PDRectangle headerRect) throws IOException {
        cos.setNonStrokingColor(Color.BLACK);
        cos.setStrokingColor(Color.WHITE);
        String title = "АИС \"Транспортная логистика\"";
        drawText(title, cos, getDefaultFonts().getBoldFont(), 16, 
            getHorizonalCenteredX(title, getDefaultFonts().getBoldFont(), 16, headerRect), 540);
        String str = "отправление " + getBean().getUrgency() + " класса"; 
        drawText(str, cos, getDefaultFonts().getRegularFont(), 14, 
            getHorizonalCenteredX(str, getDefaultFonts().getBoldFont(), 14, headerRect), 512);
        
        float scale = 0.02f;
        str = "Письмо " + getBean().getUrgency() + "-го класса";
        float x = getHorizonalCenteredX(str, getDefaultFonts().getRegularFont(), 10, headerRect);
        drawText(str, cos, getDefaultFonts().getRegularFont(), 10, x + 10, 495);
        PDImageXObject checkImg = getBean().isEnvelop() ? getImages().getCheckedOnImg() : getImages().getCheckedOffImg(); 
        cos.drawImage(checkImg, x, 495, checkImg.getWidth() * scale, checkImg.getHeight() * scale);

        
        str = "Посылка " + getBean().getUrgency() + "-го класса";
        drawText(str, cos, getDefaultFonts().getRegularFont(), 10, x + 10, 480);
        checkImg = getBean().isEnvelop() ? getImages().getCheckedOffImg() : getImages().getCheckedOnImg();
        cos.drawImage(checkImg, x, 480, checkImg.getWidth() * scale, checkImg.getHeight() * scale);
    }

    
    private void drawBody(PDPageContentStream cos, PDRectangle bodyRect) throws IOException {
      cos.setNonStrokingColor(Color.BLACK);
      float startY = bodyRect.getUpperRightY() - 20;
      String txt = "Отправитель";
      drawText(txt, cos, getDefaultFonts().getBoldFont(), 14, bodyRect.getLowerLeftX(), startY);
      PDFont fnt = getDefaultFonts().getRegularFont();
      int fntSize = 12;
      txt = "ФИО " + getBean().getSenderFullName();
      drawText(txt, cos, fnt, fntSize, bodyRect.getLowerLeftX(), startY - 20);
      txt = "Откуда г. " + getBean().getSenderCity();
      drawText(txt, cos, fnt, fntSize, bodyRect.getLowerLeftX(), startY - 40);
      txt = "Адрес " + getBean().getSenderAddress();
      drawText(txt, cos, fnt, fntSize, bodyRect.getLowerLeftX(), startY - 60);
      txt = "Телефон для SMS-уведомлений о";
      drawText(txt, cos, fnt, fntSize, bodyRect.getLowerLeftX(), startY - 80);
      txt = "вручении отправления ";
      drawText(txt, cos, fnt, fntSize, bodyRect.getLowerLeftX(), startY - 100);
      txt = getBean().getSenderPhone();
      drawText(txt, cos, fnt, fntSize, bodyRect.getLowerLeftX() + 10, startY - 120);
      
      startY = bodyRect.getUpperRightY() - 20;
      float startX = bodyRect.getUpperRightX() - 300; 
      txt = "Получатель";
      drawText(txt, cos, getDefaultFonts().getBoldFont(), 14, startX, startY);
      txt = "ФИО " + getBean().getRecipientFullName();
      drawText(txt, cos, fnt, fntSize, startX, startY - 20);
      txt = "Откуда г. " + getBean().getRecipientCity();
      drawText(txt, cos, fnt, fntSize, startX, startY - 40);
      txt = "Адрес " + getBean().getRecipientAddress();
      drawText(txt, cos, fnt, fntSize, startX, startY - 60);
      txt = "Телефон для SMS-уведомлений о";
      drawText(txt, cos, fnt, fntSize, startX, startY - 80);
      txt = "вручении отправления ";
      drawText(txt, cos, fnt, fntSize, startX, startY - 100);
      txt = getBean().getRecipientPhone();
      drawText(txt, cos, fnt, fntSize, startX + 10, startY - 120);
      
      float width = 450f;
      float height = 110f;
      PDRectangle centerRect = new PDRectangle((bodyRect.getWidth() - width)/2 + bodyRect.getLowerLeftX(), bodyRect.getLowerLeftY(), width, height);
      
      startX = centerRect.getLowerLeftX();
      startY = centerRect.getUpperRightY() - 15;
      txt = "Габариты груза (длина,см х ширина, см х высота, см";
      drawText(txt, cos, fnt, fntSize, 
          getHorizonalCenteredX(txt, fnt, fntSize, centerRect), startY);
      txt = getBean().getCargoLength() + " x " + getBean().getCargoWidth() + " x " + getBean().getCargoHeight();
      drawText(txt, cos, fnt, fntSize, 
          getHorizonalCenteredX(txt, fnt, fntSize, centerRect), startY - 15);
      txt = "Используемая упаковка";
      drawText(txt, cos, fnt, fntSize, 
          getHorizonalCenteredX(txt, fnt, fntSize, centerRect), startY - 30);
      txt = getBean().getBoxingName();
      drawText(txt, cos, fnt, fntSize, 
          getHorizonalCenteredX(txt, fnt, fntSize, centerRect), startY - 45);
      txt = "Количество " + getBean().getBoxingQuantity();
      drawText(txt, cos, fnt, fntSize, 
          getHorizonalCenteredX(txt, fnt, fntSize, centerRect), startY - 60);
      
    }
    
    
    private void drawFooter(PDPageContentStream cos, PDRectangle footerRect) throws IOException {
      cos.setNonStrokingColor(Color.GRAY);
      //cos.addRect(footerRect.getLowerLeftX(), footerRect.getLowerLeftY(), footerRect.getWidth(), footerRect.getHeight());
     // cos.fill();
        
      cos.setNonStrokingColor(Color.BLACK);
      String txt = "Маршрут доставки*";
      PDFont fnt = getDefaultFonts().getRegularFont();
      int fntSize = 14;
      drawText(txt, cos, fnt, fntSize, 
          getHorizonalCenteredX(txt, fnt, fntSize, footerRect), footerRect.getUpperRightY() - 10);
      
      PDRectangle gridRect = new PDRectangle(footerRect.getLowerLeftX(), footerRect.getLowerLeftY(), footerRect.getWidth(), footerRect.getHeight() - 20);
      drawGrid(cos, gridRect);
      txt = "*Маршрут может быть изменен по усмотрению поставщика и предоставляется в качестве наиболее вероятного пути следования отправления";
      drawText(txt, cos, fnt, 7, gridRect.getLowerLeftX(), gridRect.getLowerLeftY() - 10);
      txt = "Вес " + getBean().getCargoWeight() + " Стоимость " + getBean().getCargoCost() + " Подпись_________________________";
      drawText(txt, cos, fnt, 10, gridRect.getWidth() / 3 * 2, gridRect.getLowerLeftY() - 30);
    }
    
    
    private void drawGrid(PDPageContentStream cos, PDRectangle gridRect) throws IOException {
//        cos.setNonStrokingColor(Color.CYAN);
//        cos.addRect(gridRect.getLowerLeftX(), gridRect.getLowerLeftY(), gridRect.getWidth(), gridRect.getHeight());
//        cos.fill();
        
        cos.setStrokingColor(Color.BLACK);
        cos.setLineWidth(2);
        cos.setLineJoinStyle(1);
        cos.addRect(gridRect.getLowerLeftX(), gridRect.getLowerLeftY(), gridRect.getWidth(), gridRect.getHeight());
        cos.closeAndStroke();
        
        cos.setLineWidth(1);
        float startX = gridRect.getLowerLeftX();
        float startY = gridRect.getUpperRightY() - 30;
        float endX = gridRect.getUpperRightX();
        cos.moveTo(startX, startY);
        cos.lineTo(endX, startY);
        cos.moveTo(startX, startY - 20);
        cos.lineTo(endX, startY - 20);
        cos.moveTo(startX, startY - 40);
        cos.lineTo(endX, startY - 40);
        cos.moveTo(startX, startY - 60);
        cos.lineTo(endX, startY - 60);
        cos.moveTo(startX, startY - 80);
        cos.lineTo(endX, startY - 80);
        
        float cityFromColX = gridRect.getLowerLeftX() + 150;
        cos.moveTo(cityFromColX, gridRect.getUpperRightY());
        cos.lineTo(cityFromColX, gridRect.getLowerLeftY());
        float transportColX = cityFromColX + 150;
        cos.moveTo(transportColX, gridRect.getUpperRightY());
        cos.lineTo(transportColX, gridRect.getLowerLeftY());
        float cityToColX = transportColX + 150;
        cos.moveTo(cityToColX, gridRect.getUpperRightY());
        cos.lineTo(cityToColX, gridRect.getLowerLeftY());

        PDFont tblHeadFont = getDefaultFonts().getBoldFont();
        int tblHeadFontSize = 12; 
        float headY = gridRect.getUpperRightY() - 15;
        String txt = "Город отправления";
        drawText(txt, cos, tblHeadFont, tblHeadFontSize, gridRect.getLowerLeftX() + 10, headY);
        txt = "Транспорт";
        drawText(txt, cos, tblHeadFont, tblHeadFontSize, cityFromColX + 10, headY);
        txt = "Город прибытия";
        drawText(txt, cos, tblHeadFont, tblHeadFontSize, transportColX + 10, headY);
        txt = "Примечание";
        drawText(txt, cos, tblHeadFont, tblHeadFontSize, cityToColX + 10, headY);
        
        PDFont dtFont = getDefaultFonts().getRegularFont();
        int ftSize = 11;
        List<RoutePart> routeParts = getBean().getRouteParts();
        startX = gridRect.getLowerLeftX() + 5;
        startY = headY - 30;
        for(RoutePart part : routeParts) {
            drawText(part.getStartCity(), cos, dtFont, ftSize, startX, startY);
            drawText(part.getTransport(), cos, dtFont, ftSize, cityFromColX + 5, startY);
            drawText(part.getFinishCity(), cos, dtFont, ftSize, transportColX + 5, startY);
            startY -= 20;
        }
        cos.closeAndStroke();
    }
    
    
    public static void main(String[] args) throws Exception {
        MessageSource messageSource = new GenericApplicationContext();
        OrderForm of = new OrderForm();
        OrderFormBean bean = new OrderFormBean();
        bean.appendRoutePart("Москва", "Автомобиль");
        bean.appendRoutePart("Краснодар", "Железная дорога");
        bean.appendRoutePart("Сочи", "Железная дорога");
        bean.appendRoutePart("Ялта", "Автомобиль");
        bean.appendRoutePart("Москва", "Falcon Heavy");
        of.buildForm(bean, messageSource);
    }


//  cos.setNonStrokingColor(Color.GRAY);
//  cos.addRect(headerRect.getLowerLeftX(), headerRect.getLowerLeftY(), headerRect.getWidth(), headerRect.getHeight());
//  cos.fill();

}
