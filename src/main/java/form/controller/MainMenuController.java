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

}
