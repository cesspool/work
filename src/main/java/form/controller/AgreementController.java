package form.controller;


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

import beans.Rate;
import beans.Transport;
import beans.TransportRate;
import dbservice.TranspRateDAOService;
import exception.LogisticsException;
import exception.RateAlreadyExistException;
import form.request.NewAgreementForm;
import form.request.TransportForm;
import service.TranspRateService;
import utils.Tools;
import web.Message;
import web.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import web.Message.Type;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AgreementController extends BaseController {
    private TranspRateService transpRateService;
    private MessageSource messageSource;
    


    @RequestMapping(value = "/newrate", method = RequestMethod.POST)
    public String agreement(@ModelAttribute("newrate") NewAgreementForm formData,
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
        	try {
        		if(formData.getCargoID() == 0)
            	{
            		List<Rate> transportRate = transpRateService.createRate(formData);// (formData);
                    redirectAttributes.addFlashAttribute(Pages.NEWRATE, formData);
                    return "redirect:changingAgreement";
            	} else {
            		transpRateService.updateRateById(formData);
            		return "redirect:changingAgreement";
            	}
        	} catch(LogisticsException ex) {
        		Message errMsg = ex.getMsg();
        		errMsg.setMsg(messageSource.getMessage(errMsg.getKey(), null, locale));
        		redirectAttributes.addFlashAttribute(Pages.ATR_MESSAGE, errMsg);
        		return "redirect:newrate";
        	}
        	
        }
    }
    @RequestMapping(value = "/newrate", method = RequestMethod.GET)
    public String showNewRateForm(Model model) {
    	model.addAttribute("railID", 3);
    	model.addAttribute("airID", 2);
    	model.addAttribute("cargoID", 1);
        return Pages.NEWRATE;
    }
    
   


//    @RequestMapping(value = "/registrationform", method = RequestMethod.GET)
//    public String showRegistrationForm(Model model) {
//        RegistrationForm formData = new RegistrationForm();
//        model.addAttribute(Pages.ATR_CUSTOMER, formData);
//        return Pages.REGISTRATION;
//    }
//
//    @RequestMapping(value = "/registrationform/{id}", method = RequestMethod.GET)
//    public String showCustomerForm(@PathVariable("id") Long id, Model model) {
//        customerService.getByID(id).ifPresent(cmr -> {
//            RegistrationForm formData = Tools.customerToRegistrationForm(cmr);
//            model.addAttribute(Pages.ATR_CUSTOMER, formData);
//        });
//        return Pages.REGISTRATION;
//    }


    @Autowired
    private void setAgreementService(TranspRateService service) {
        this.transpRateService = service;
    }

    @Autowired
    protected void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private Message validateForm(NewAgreementForm formData) {
//        if (Tools.isBlank(formData.getPsw())) {
//            Message msg = new Message(Type.ERROR, "registration.no-pass");
//            return msg;
//        }
//        if (!formData.getPsw().equals(formData.getPswRepeat())) {
//            Message msg = new Message(Type.ERROR, "registration.wrong-repeat");
//            return msg;
//        }
//
//        if (Tools.isBlank(formData.getFirstName()) ||
//            Tools.isBlank(formData.getLastName()) ||
//            Tools.isBlank(formData.getEmail()) ||
//            Tools.isBlank(formData.getTelephone()) ||
//            Tools.isBlank(formData.getPatronymic()) ||
//            Tools.isBlank(formData.getCity())) {
//            Message msg = new Message(Type.ERROR, "registration.missed-field");
//            return msg;
//        }
        return null;
    }
    


}
