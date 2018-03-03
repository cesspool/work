package form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value="/welcome", method=RequestMethod.GET)
    public String setupForm(Model model) {
        model.addAttribute("phrase", "W E L C O M !");
        return "login";
    }
}
