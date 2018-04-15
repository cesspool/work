package form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import form.request.RegistrationForm;
import utils.Tools;
import web.Pages;

@Controller
public class MainMenuController extends BaseController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showMainPage(Model model) {
        return Pages.MAIN;
    }


//    @RequestMapping(value = "/cost", method = RequestMethod.GET)
//    public String showPersonCostForm(Model model) {
//        return Pages.COST;
//    }



    @RequestMapping(value = "/newrate", method = RequestMethod.GET)
    public String showNewRateForm(Model model) {
    	model.addAttribute("railID", 3);
    	model.addAttribute("airID", 2);
    	model.addAttribute("cargoID", 1);
        return Pages.NEWRATE;
    }
    
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String showAdminForm(Model model) {
        return Pages.STATUS;
    }
    
    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public String showReportForm(Model model) {
    	model.addAttribute("ord1", 1);
    	model.addAttribute("ord2", 2);
        return Pages.REPORT;
    }
    
}
