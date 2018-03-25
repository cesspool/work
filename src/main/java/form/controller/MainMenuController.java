package form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.Pages;

@Controller
public class MainMenuController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showMainPage(Model model) {
        return Pages.MAIN;
    }

    @RequestMapping(value = "/rateform", method = RequestMethod.GET)
    public String showRatesForm(Model model) {
        return Pages.RATE;
    }

    @RequestMapping(value = "/loginform", method = RequestMethod.GET)
    public String showLoginForm(Model model) {
        return Pages.LOGIN;
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String showHistoryForm(Model model) {
        return Pages.HISTORY;
    }

    @RequestMapping(value = "/cost", method = RequestMethod.GET)
    public String showPersonCostForm(Model model) {
        return Pages.COST;
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String showPersonContactForm(Model model) {
        return Pages.CONTACT;
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String showAdminForm(Model model) {
        return Pages.ADMIN;
    }

    @RequestMapping(value = "/boxing", method = RequestMethod.GET)
    public String showBoxingForm(Model model) {
        return Pages.BOXING;
    }

    @RequestMapping(value = "/newrate", method = RequestMethod.GET)
    public String showNewRateForm(Model model) {
        return Pages.NEWRATE;
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String showResultForm(Model model) {
        return Pages.RESULT;
    }
    
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String showOrderForm(Model model) {
        return Pages.ORDER;
    }
    
}
