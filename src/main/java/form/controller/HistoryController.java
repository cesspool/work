package form.controller;

import form.pdf.OrderForm;
import form.pdf.OrderFormBean;
import form.response.OrderingReq;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.OrderService;
import utils.Tools;
import web.Pages;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HistoryController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(HistoryController.class);
    
    private OrderService orderService;
    private MessageSource messageSource;
	
    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String showHistoryForm(Model model) {
        return Pages.HISTORY;
    }
	
	
    
	@RequestMapping(value = "/history/{id}", method = RequestMethod.GET)
    public String showHistorySepForm(@PathVariable("id") Long id, Model model, Locale locale) {
		
        orderService.getOrderByParam(id, true).ifPresent(ord -> {
        	List<OrderingReq> orderReq = Tools.orderToHistoryForm(ord);
        	for (OrderingReq ordReq : orderReq) {
        		ordReq.setTypeDelivery(messageSource.getMessage(ordReq.getTypeDelivery(), null, locale));
        		ordReq.setTypeCargo(messageSource.getMessage(ordReq.getTypeCargo(), null, locale));
        		ordReq.getOrder().setCost(Math.ceil(ordReq.getOrder().getCost()));
        	}
            model.addAttribute(Pages.ATR_ORDER_READY, orderReq);
        });
        return Pages.HISTORY;
    }
	
	//getPrincipal().getId();
	
	@RequestMapping(value = "/personal/{id}", method = RequestMethod.GET)
    public String showPersonalForm(@PathVariable("id") Long id, Model model, Locale locale) {
        orderService.getOrderByParam(id, false).ifPresent(ord -> {
        	List<OrderingReq> orderReq = Tools.orderToHistoryForm(ord);
        	for (OrderingReq ordReq : orderReq) {
        		ordReq.setTypeDelivery(messageSource.getMessage(ordReq.getTypeDelivery(), null, locale));
        		ordReq.setTypeCargo(messageSource.getMessage(ordReq.getTypeCargo(), null, locale));
        		ordReq.getOrder().setCost(Math.ceil(ordReq.getOrder().getCost()));
        	}
            model.addAttribute(Pages.ATR_ORDER_READY, orderReq);
        });
        return Pages.PERSON;
    }

	
	@RequestMapping(value="/orderform/{id}", method = RequestMethod.GET)
	public void readPdfForm(@PathVariable("id") Long orderID, Locale locale,
	                    HttpServletRequest req, HttpServletResponse resp) {

	    OrderFormBean bean = new OrderFormBean();
	    bean.setId(String.valueOf(orderID));
	    bean.setSenderFullName("Сидоров Сидор Степаныч");
	    bean.setSenderCity("Москва");
	    bean.setSenderAddress("100456б г. Москваб ул.Мосфильмовскаяб д.13 кв.123");
	    bean.setSenderPhone("+7(495) 223-322");
	    bean.setRecipientFullName("Иванов Иван Иваныч");
	    bean.setRecipientCity("Челябинск");
	    bean.setRecipientAddress("344006 г.Челябинскб ул.Ленина, д.15. кв.43");
	    bean.setRecipientPhone("3444-34-34-34");
	    bean.setCargoCost("234567р. 63коп.");
	    bean.setCargoHeight("23");
	    bean.setCargoLength("115");
	    bean.setCargoWeight("45");
	    bean.setCargoWidth("34");
	    bean.setBoxingName("Короб");
	    bean.setBoxingQuantity("1");
	    bean.setEnvelop(false);
	    bean.setUrgency("1");
	    bean.appendRoutePart("Москва", "Железная дорога");
	    bean.appendRoutePart("Сочи", "Автотранспорт");
	    bean.appendRoutePart("NewYork", "Falcon Heavy");
	    OrderForm form = new OrderForm();
	    try {
	        ByteArrayOutputStream outBf = new ByteArrayOutputStream();
	        PDDocument pdfDoc = form.createForm(bean, messageSource, new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()), 1, outBf).orElse(null);
	        resp.setContentType(MediaType.APPLICATION_PDF_VALUE);
	        resp.setHeader("Content-Disposition", "attachment; filename=OrderForm_" + orderID + ".pdf");
	        resp.setHeader("Content-Length", String.valueOf(outBf.size()));
	        FileCopyUtils.copy(outBf.toByteArray(), resp.getOutputStream());
	        
	    } catch(IOException ioEx) {
	        logger.error("Creating PDF failed", ioEx);
	    } 
	}
	
	
	@Autowired
    private void setOrderService(OrderService service) {
        this.orderService = service;
    }

    @Autowired
    protected void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    @Override
    public boolean isForCustomer() {
        return true;
    }
    
    @Override
    public boolean isForAdmin() {
        return false;
    }

}
