package form.controller;

import beans.Boxing;
import beans.NodeDistance;
import form.request.NewBoxingForm;
import form.request.NewNodeForm;

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
import service.NodeDistanceService;
import utils.Tools;
import web.Message;
import web.Pages;

import java.util.Locale;

import web.Message.Type;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BranchController {
	    private NodeDistanceService nodeDistanceService;
	    private MessageSource messageSource;

	    @RequestMapping(value = "/admin", method = RequestMethod.POST)
	    public String boxing(@ModelAttribute("admin") NewNodeForm formData,
	                               BindingResult bundingResult,
	                               Model uiModel,
	                               HttpServletRequest httpServletRequest,
	                               RedirectAttributes redirectAttributes,
	                               Locale locale) {
	        Message message = validateForm(formData);
	        if (message != null) {
	            message.setMsg(messageSource.getMessage(message.getKey(), null, locale));
	            redirectAttributes.addFlashAttribute(Pages.ATR_MESSAGE, message);
	            return "redirect:admin";
	        } else {
	            NodeDistance nodeDistance = nodeDistanceService.createNode(formData); // mistake is here, don't go to DAO service
	            redirectAttributes.addFlashAttribute(Pages.ADMIN, formData);
	            return "redirect:admin";
	        }

	    }

//	    @RequestMapping(value = "/registrationform", method = RequestMethod.GET)
//	    public String showRegistrationForm(Model model) {
//	        RegistrationForm formData = new RegistrationForm();
//	        model.addAttribute(Pages.ATR_CUSTOMER, formData);
//	        return Pages.REGISTRATION;
//	    }
//
//	    @RequestMapping(value = "/registrationform/{id}", method = RequestMethod.GET)
//	    public String showCustomerForm(@PathVariable("id") Long id, Model model) {
//	        customerService.getByID(id).ifPresent(cmr -> {
//	            RegistrationForm formData = Tools.customerToRegistrationForm(cmr);
//	            model.addAttribute(Pages.ATR_CUSTOMER, formData);
//	        });
//	        return Pages.REGISTRATION;
//	    }


	    @Autowired
	    private void setNodeService(NodeDistanceService service) {
	        this.nodeDistanceService = service;
	    }

	    @Autowired
	    protected void setMessageSource(MessageSource messageSource) {
	        this.messageSource = messageSource;
	    }

	    private Message validateForm(NewNodeForm formData) {
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
}
