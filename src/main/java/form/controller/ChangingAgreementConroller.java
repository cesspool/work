package form.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.Node;
import beans.Rate;
import beans.Transport;
import service.TranspRateService;
import web.Pages;

@Controller
public class ChangingAgreementConroller extends BaseController {
	
	@Autowired
	private TranspRateService transpRateService;
	
    @RequestMapping(value = "/changingAgreement", method = RequestMethod.GET)
    public String showAgreementForm(Model model) {
        //Map<Long, String> res = nodeService.getAllCities();
        //model.addAttribute("allCities", res);
    	List<Rate> rates = transpRateService.getAllRates();
    	List<Rate> ratesOut = new ArrayList<>();
    	for (int i =0; i< rates.size(); ) {
    		ratesOut.add(rates.get(i));
    		i=i+3;
    	}

    	List<Transport> transports = transpRateService.getAllTransports();
    	model.addAttribute("weight", transports.get(0).getTotalWeight());
    	model.addAttribute("length", transports.get(0).getMaxLength());
    	model.addAttribute("width", transports.get(0).getMaxWidth());
    	model.addAttribute("height", transports.get(0).getMaxHeight());
        model.addAttribute("allRates", ratesOut);
        return Pages.CHANGING_RATES;
    }
    
    @RequestMapping(value = "/changingAgreement/change/{id}", method = RequestMethod.GET)
    public String showChangingAgrForm(@PathVariable("id") Long id, Model model) {
    	List<Rate> rates = transpRateService.getRatesById(id);
        //Map<Long, String> res = nodeService.getAllCities();
        //model.addAttribute("allCities", res);idRateCargo
    	model.addAttribute("idRateCargo", rates.get(0).getId());
    	model.addAttribute("idRateAir", rates.get(1).getId());
    	model.addAttribute("idRateRail", rates.get(2).getId());
    	model.addAttribute("name", rates.get(0).getName());
    	model.addAttribute("dateStart", rates.get(0).getStartAction());
    	model.addAttribute("dateEnd", rates.get(0).getEndAction());
    	model.addAttribute("costShippingCargo", rates.get(0).getCostShipping());
    	model.addAttribute("costShippingAir", rates.get(1).getCostShipping());
    	model.addAttribute("costShippingRail", rates.get(2).getCostShipping());
    	model.addAttribute("addCostShippingCargo", rates.get(0).getAdditionalCost());
    	model.addAttribute("addCostShippingAir", rates.get(1).getAdditionalCost());
    	model.addAttribute("addCostShippingRail", rates.get(2).getAdditionalCost());
    	model.addAttribute("costKmCargo", rates.get(0).getCostKm());
    	model.addAttribute("costKmAir", rates.get(1).getCostKm());
    	model.addAttribute("costKmRail", rates.get(2).getCostKm());
        return Pages.NEWRATE;
    }
    
    @RequestMapping(value = "/changingTransport", method = RequestMethod.GET)
    public String showTransportForm(Model model) {
        //Map<Long, String> res = nodeService.getAllCities();
        //model.addAttribute("allCities", res);
    	List<Transport> transports = transpRateService.getAllTransports();
    	model.addAttribute("weight", transports.get(0).getTotalWeight());
    	model.addAttribute("length", transports.get(0).getMaxLength());
    	model.addAttribute("width", transports.get(0).getMaxWidth());
    	model.addAttribute("height", transports.get(0).getMaxHeight());
        return Pages.TRANSFORM_TRANSPORT;
    }
    
    
    

}
