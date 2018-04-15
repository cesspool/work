package form.controller;

import beans.Boxing;
import beans.Customer;
import beans.OrderWriter;
import form.request.CalculateForm;
import form.request.NewBoxingForm;
import form.request.OrderingForm;
import form.request.RegistrationForm;
import form.response.CalculateReq;

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

import service.BoxingService;
import service.CustomerService;
import service.OrderService;
import utils.Tools;
import web.Message;
import web.Pages;

import java.util.Locale;

import web.Message.Type;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("orderWriter")
public class OrderController extends BaseController {
    private CustomerService customerService;
	private OrderService orderService;
	private MessageSource messageSource;

	    @RequestMapping(value = "/order", method = RequestMethod.GET)
	    public String showOrder(Model model) {
	    	return Pages.ORDER;
	    }
	    
	    @RequestMapping(value = "/order", method = RequestMethod.POST)
	    public String createOrder(@ModelAttribute("orderWriter")OrderWriter orderWriter, 	  
	    		 				   OrderingForm formData,
	                               BindingResult bundingResult,
	                               Model uiModel,
	                               HttpServletRequest httpServletRequest,
	                               RedirectAttributes redirectAttributes,
	                               Locale locale) {
	        Message message = validateForm(formData);
	        CalculateReq calcReq = orderWriter.getCalculateReq();
	        CalculateForm calcForm = orderWriter.getForm();
	        if (message != null) {
	            message.setMsg(messageSource.getMessage(message.getKey(), null, locale));
	            redirectAttributes.addFlashAttribute(Pages.ATR_MESSAGE, message);
	            return "redirect:boxing";
	        } else {
	        	orderWriter.setRecipientId(1L);
	        	orderService.createOrder(orderWriter, formData);
	            //Order box = orderService.(formData); // mistake is here, don't go to DAO service
	            redirectAttributes.addFlashAttribute(Pages.COST, formData);
	            return "redirect:costCalculation";
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

	    private Message validateForm(OrderingForm formData) {
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
	    
	    
	    @RequestMapping(value = "/contact", method = RequestMethod.POST)
	    public String updateCustomer(@ModelAttribute("customer") RegistrationForm formData,
	                               BindingResult bundingResult,
	                               Model uiModel,
	                               HttpServletRequest httpServletRequest,
	                               RedirectAttributes redirectAttributes,
	                               Locale locale) {
	        Message message = validateForm(formData);
	        if (message != null) {
	            message.setMsg(messageSource.getMessage(message.getKey(), null, locale));
	            redirectAttributes.addFlashAttribute(Pages.ATR_MESSAGE, message);
	            return "redirect:registrationform";
	        } else {
	            Customer cmr = customerService.updateCustomer(formData);
	            redirectAttributes.addFlashAttribute(Pages.ATR_CUSTOMER, formData);
	            return "redirect:contact/"+cmr.getId();
	        }
	    }
	    
	    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
	    public String showPersonContactForm(@PathVariable("id") Long id, Model model, Locale locale) {   
	    		customerService.getByID(id).ifPresent(cmr -> {
	            RegistrationForm formData = Tools.customerToRegistrationForm(cmr);
	            formData.setPerk(messageSource.getMessage(formData.getPerk(), null, locale));
	            model.addAttribute(Pages.ATR_CUSTOMER, formData);
	        });
	        return Pages.CONTACT;
	    }
	    
	    
	    private Message validateForm(RegistrationForm formData) {
	    	if (Tools.isBlank(formData.getPsw())) {
	            Message msg = new Message(Type.ERROR, "registration.no-pass");
	            return msg;
	        }
	        if (!formData.getPsw().equals(formData.getPswRepeat())) {
	            Message msg = new Message(Type.ERROR, "registration.wrong-repeat");
	            return msg;
	        }

	        if (Tools.isBlank(formData.getFirstName()) ||
	            Tools.isBlank(formData.getLastName()) ||
	            Tools.isBlank(formData.getEmail()) ||
	            Tools.isBlank(formData.getTelephone()) ||
	            Tools.isBlank(formData.getPatronymic()) ||
	            Tools.isBlank(formData.getCity())) {
	            Message msg = new Message(Type.ERROR, "registration.missed-field");
	            return msg;
	        }
	        return null;
	    }
	    
	    @Autowired
	    private void setCustomerService(CustomerService service) {
	        this.customerService = service;
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
