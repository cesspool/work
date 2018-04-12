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
    
    @Autowired
    private TranspRateDAOService transpRateDAOService;

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
        	if(formData.getCargoID() == 0)
        	{
        		List<Rate> transportRate = transpRateService.createRate(formData);// (formData);
                redirectAttributes.addFlashAttribute(Pages.NEWRATE, formData);
                return "redirect:newrate";
        	} else {
        		transpRateService.updateRateById(formData);
        		return "redirect:changingAgreement";
        	}
        }
    }
    
    
   
    
    @RequestMapping(value = "/rateform", method = RequestMethod.GET)	
    public String showRateForm(Model model) {
    	List<Transport> transports = transpRateDAOService.getAllTransports();
    	List<Rate> rates = transpRateDAOService.getCurrentRate();
    	model.addAttribute("name", rates.get(0).getName());
    	model.addAttribute("dateStart", rates.get(0).getStartAction());
    	model.addAttribute("dateEnd", rates.get(0).getEndAction());
    	model.addAttribute("weight", transports.get(0).getTotalWeight());
    	model.addAttribute("length", transports.get(0).getMaxLength());
    	model.addAttribute("width", transports.get(0).getMaxWidth());
    	model.addAttribute("height", transports.get(0).getMaxHeight());
    	model.addAttribute("costShippingCargo", rates.get(0).getCostShipping());
    	model.addAttribute("costShippingAir", rates.get(1).getCostShipping());
    	model.addAttribute("costShippingRail", rates.get(2).getCostShipping());
    	model.addAttribute("addCostShippingCargo", rates.get(0).getAdditionalCost());
    	model.addAttribute("addCostShippingAir", rates.get(1).getAdditionalCost());
    	model.addAttribute("addCostShippingRail", rates.get(2).getAdditionalCost());
    	model.addAttribute("costKmCargo", rates.get(0).getCostKm());
    	model.addAttribute("costKmAir", rates.get(1).getCostKm());
    	model.addAttribute("costKmRail", rates.get(2).getCostKm());

        return Pages.RATE;
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
