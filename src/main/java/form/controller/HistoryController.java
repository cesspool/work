package form.controller;



import beans.Customer;
import form.request.RegistrationForm;
import form.response.OrderingReq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.CustomerService;
import service.OrderService;
import utils.Tools;
import web.Message;
import web.Pages;

import java.util.List;
import java.util.Locale;

import web.Message.Type;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HistoryController extends BaseController {
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
