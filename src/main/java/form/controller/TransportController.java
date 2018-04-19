package form.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import beans.TransportRate;
import form.request.NewAgreementForm;
import form.request.TransportForm;
import service.TranspRateService;
import web.Message;
import web.Pages;



@Controller
public class TransportController extends BaseController {
	private TranspRateService transpRateService;
	private MessageSource messageSource;
	
	 @RequestMapping(value = "/changingTransport", method = RequestMethod.POST)
	    public String agreement(@ModelAttribute("newrate") TransportForm formData,
	                               BindingResult bundingResult,
	                               Model uiModel,
	                               HttpServletRequest httpServletRequest,
	                               RedirectAttributes redirectAttributes,
	                               Locale locale) {
	        Message message = validateForm(formData);
	        if (message != null) {
	            message.setMsg(messageSource.getMessage(message.getKey(), null, locale));
	            redirectAttributes.addFlashAttribute(Pages.ATR_MESSAGE, message);
	            return "redirect:newrate";
	        } else {
	        	transpRateService.updateTransport(formData);
	        	return "redirect:changingAgreement";
	        }
	    }
	 
	 
	 @Autowired
	    private void setAgreementService(TranspRateService service) {
	        this.transpRateService = service;
	    }

	    @Autowired
	    protected void setMessageSource(MessageSource messageSource) {
	        this.messageSource = messageSource;
	    }

	    private Message validateForm(TransportForm formData) {
//	        if (Tools.isBlank(formData.getPsw())) {
//	            Message msg = new Message(Type.ERROR, "registration.no-pass");
//	            return msg;
//	        }
//	        if (!formData.getPsw().equals(formData.getPswRepeat())) {
//	            Message msg = new Message(Type.ERROR, "registration.wrong-repeat");
//	            return msg;
//	        }
	//
//	        if (Tools.isBlank(formData.getFirstName()) ||
//	            Tools.isBlank(formData.getLastName()) ||
//	            Tools.isBlank(formData.getEmail()) ||
//	            Tools.isBlank(formData.getTelephone()) ||
//	            Tools.isBlank(formData.getPatronymic()) ||
//	            Tools.isBlank(formData.getCity())) {
//	            Message msg = new Message(Type.ERROR, "registration.missed-field");
//	            return msg;
//	        }
	        return null;
	    }

}
