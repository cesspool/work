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


    @RequestMapping(value = "/loginform", method = RequestMethod.GET)
    public String showLoginForm(Model model) {
        return Pages.LOGIN;
    }
    
    @RequestMapping(value = "/noaccess", method = RequestMethod.GET)
    public String showAccessForm(Model model) {
        return Pages.ACCESS;
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
    
   
    
}
