package form.controller;

import beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.CustomerService;
import web.Message;
import web.Pages;
import web.Principal;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes(Pages.ATR_PRINCIPAL)
public class LoginController extends BaseController {
    private CustomerService customerService;
    private MessageSource messageSource;

    @RequestMapping(value = "/loginform", method = RequestMethod.GET)
    public String showLoginForm(Model model) {
        return Pages.LOGIN;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        model.remove(Pages.ATR_PRINCIPAL);
        logout();
        return Pages.LOGIN;
    }
   
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam(value = "email") String email,
                          @RequestParam(value = "pass") String pass,
                          Model uiModel,
                          HttpServletRequest httpServletRequest,
                          RedirectAttributes redirectAttributes,
                          Locale locale) {

        Message msg = new Message();    
        Customer cmr = customerService.authenticate(email, pass, msg);
        if(cmr == null) {
            msg.setMsg(messageSource.getMessage(msg.getKey(), null, locale));
            redirectAttributes.addFlashAttribute(Pages.ATR_MESSAGE, msg);
            return "redirect:/loginform";
        } else {
        	Principal principal = new Principal(cmr);
            uiModel.addAttribute(Pages.ATR_PRINCIPAL, principal);
            uiModel.addAttribute(Pages.ATR_CUSTOMER, cmr);
            if (cmr.isAdmin()) {
                return "redirect:/" + Pages.BRANCH;
            }
            if (cmr.isManager()) {
                return "redirect:/status";
            }
            return "redirect:/" + Pages.PERSON + "/" + principal.getId();    
        }
    }

    @Override
    public boolean isForFree() {
        return true;
    }

    @Override
    public boolean isForAdmin() {
        return false;
    }
    
    @Autowired
    protected void setCustomerService(CustomerService service) {
        this.customerService = service;
    }


    @Autowired
    protected void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

}
