package form.controller;

import form.request.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CustomerService;
import utils.Tools;
import web.Message;
import web.Pages;
import web.Message.Type;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {
    private CustomerService customerService;
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registration(RegistrationForm formData, BindingResult bundingResult, Model uiModel, HttpServletRequest httpRequest) {
        Message message = validateForm(formData);
        return "redirect:registrationform";
    }
    
    @RequestMapping(value = "/registrationform", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        return Pages.REGISTRATION;
    }
    
    
    @Autowired
    private void setCustomerService(CustomerService service) {
        this.customerService = service;
    }
    
    private Message validateForm(RegistrationForm formData) {
        if(Tools.isBlank(formData.getPsw())) {
            Message msg = new Message(Type.ERROR, "registration.no-pass");
            return msg;
        }
        if(!formData.getPsw().equals(formData.getPswRepeat())) {
            Message msg = new Message(Type.ERROR, "registration.wrong-repeat");
            return msg;
        }
        
        if(Tools.isBlank(formData.getFirstName())   ||
            Tools.isBlank(formData.getLastName())   ||
            Tools.isBlank(formData.getEmail())      || 
            Tools.isBlank(formData.getTelephone())  ||
            Tools.isBlank(formData.getPatronymic()) ||
            Tools.isBlank(formData.getCity())) {
            Message msg = new Message(Type.ERROR, "registration.missed-field");
            return msg;
        }
        return null;
    }
    
    
}
