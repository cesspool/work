package form.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.Pages;

@Controller
public class changingAgreementConroller extends BaseController {
	
    @RequestMapping(value = "/changingBranch", method = RequestMethod.GET)
    public String showBranchForm(Model model) {
    	
        //Map<Long, String> res = nodeService.getAllCities();
        //model.addAttribute("allCities", res);
        //model.addAttribute("chosenCities", nodeService.getCities(nodeID));
        return Pages.CHANGING_RATES;
    }

}
