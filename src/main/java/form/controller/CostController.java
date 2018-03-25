package form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.Pages;

@Controller
public class CostController {
    
    @RequestMapping(value = "/costCalculation", method = {RequestMethod.POST, RequestMethod.GET})
    public String showOrderForm(Model model) {
        
        return "redirect:result"; //Pages.RESULT;
    }

    
}
