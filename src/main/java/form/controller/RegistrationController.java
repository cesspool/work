package form.controller;

import beans.Customer;
import form.request.RegistrationForm;
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
import utils.Tools;
import web.Message;
import web.Pages;

import java.util.Locale;

import web.Message.Type;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController extends BaseController {
    private CustomerService customerService;
    private MessageSource messageSource;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("customer") RegistrationForm formData,
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
            Customer cmr = customerService.createCustomer(formData);
            redirectAttributes.addFlashAttribute(Pages.ATR_CUSTOMER, formData);
            if((getPrincipal() != null)&&(getPrincipal().isAdmin())) {
            	return "redirect:changingBranch";
            } else {
            	return "redirect:loginform";
            }
        }
    }

    @RequestMapping(value = "/registrationform", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        RegistrationForm formData = new RegistrationForm();
        model.addAttribute(Pages.ATR_CUSTOMER, formData);
        return Pages.REGISTRATION;
    }
    
    

    @Autowired
    private void setCustomerService(CustomerService service) {
        this.customerService = service;
    }

    @Autowired
    protected void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
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

    @Override
    public boolean isForFree() {
        return true;
    }
    
    @Override
    public boolean isForAdmin() {
        return false;
    }
}
