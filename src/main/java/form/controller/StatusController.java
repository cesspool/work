package form.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import beans.OrderShow;
import beans.OrderWriter;
import exception.PathNotFoundException;
import form.request.CalculateForm;
import form.request.StatusForm;
import form.response.CalculateReq;
import form.response.OrderingReq;
import service.BoxingService;
import service.NodeDistanceService;
import service.OrderService;
import utils.Tools;
import web.Message;
import web.Pages;

@Controller
public class StatusController extends BaseController {
	private MessageSource messageSource;
	private OrderService orderService;
	
	    @RequestMapping(value = "/status", method = RequestMethod.GET)
	    public String showStatusForm(Model model) {
	        return Pages.STATUS;
	    }
	    
	
	
	   @RequestMapping(value = "/status", method = RequestMethod.POST)
	    public String statusOrder(@ModelAttribute("status") StatusForm formData,
	                               BindingResult bundingResult,
	                               Model uiModel,
	                               HttpServletRequest httpServletRequest,
	                               RedirectAttributes redirectAttributes,
	                               Locale locale) {
	        Message message = validateForm(formData);
	        if (message != null) {
	            message.setMsg(messageSource.getMessage(message.getKey(), null, locale));
	            redirectAttributes.addFlashAttribute(Pages.ATR_MESSAGE, message);
	            return "redirect:result";
	        } else {
	        	//List<OrderShow> orders = 
	        orderService.getOrderByRecipientName(formData.getNameRecip()).ifPresent(ord -> {
	        	List<OrderingReq> orderReq = Tools.orderToHistoryForm(ord);
	        	for (OrderingReq ordReq : orderReq) {
	        		ordReq.setTypeDelivery(messageSource.getMessage(ordReq.getTypeDelivery(), null, locale));
	        		ordReq.setTypeCargo(messageSource.getMessage(ordReq.getTypeCargo(), null, locale));
	        	}
	            uiModel.addAttribute(Pages.ATR_ORDER_READY, orderReq);
	        });
	        	return Pages.STATUS;	
	        }
	    }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   @RequestMapping(value = "/statusOrder", method = RequestMethod.POST)
	    public String showOrderForm(@ModelAttribute("statusOrder") StatusForm formData,
	                               BindingResult bundingResult,
	                               Model uiModel,
	                               HttpServletRequest httpServletRequest,
	                               RedirectAttributes redirectAttributes,
	                               Locale locale) {
	        Message message = validateForm(formData);
	        if (message != null) {
	            message.setMsg(messageSource.getMessage(message.getKey(), null, locale));
	            redirectAttributes.addFlashAttribute(Pages.ATR_MESSAGE, message);
	            return "redirect:result";
	        } else {
	        	formData.readOrdersDone(httpServletRequest.getParameterMap());
	        	orderService.updateById(formData.getOrderDoneIDs());
	        	//List<OrderShow> orders = 
	        	
	        	return Pages.STATUS;	
	        }
	    }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	    @Autowired
	    private void setOrderService(OrderService service) {
	        this.orderService = service;
	    }

	    
	   private Message validateForm(StatusForm formData) {
//	        if (Tools.isBlank(formData.getPsw())) {
//	            Message msg = new Message(Type.ERROR, "registration.no-pass");
//	            return msg;
//	        }
//	        if (!formData.getPsw().equals(formData.getPswRepeat())) {
//	            Message msg = new Message(Type.ERROR, "registration.wrong-repeat");
//	            return msg;
//	        }

//	        if (Tools.isBlank(formData.getName()) ||
//	            Tools.isBlank(formData.getCost())) {
//	            Message msg = new Message(Type.ERROR, "registration.missed-field");
//	            return msg;
//	        }
	        return null;
	    }
	    
	    
	    
	    @Autowired
	    protected void setMessageSource(MessageSource messageSource) {
	        this.messageSource = messageSource;
	    }
	    
}
