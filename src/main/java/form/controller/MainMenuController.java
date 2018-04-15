package form.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.Rate;
import beans.Transport;
import dbservice.TranspRateDAOService;
import form.request.RegistrationForm;
import utils.Tools;
import web.Pages;

@Controller
public class MainMenuController extends BaseController {
	
    @Autowired
    private TranspRateDAOService transpRateDAOService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showMainPage(Model model) {
        return Pages.MAIN;
    }


    @RequestMapping(value = "/noaccess", method = RequestMethod.GET)
    public String showAccessForm(Model model) {
        return Pages.NO_ACCESS;
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
    
    @Override
    public boolean isForAdmin() {
        return false;
    }
    
    @Override
    public boolean isForFree() {
        return true;
    }

    
}
