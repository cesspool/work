package form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import beans.Boxing;
import beans.NodeDistance;
import exception.PathNotFoundException;
import form.request.CalculateForm;
import form.request.NewNodeForm;
import form.response.CalculateReq;
import service.NodeDistanceService;
import service.OrderService;
import service.OrderServiceImpl;
import web.Message;
import web.Pages;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ResultController extends BaseController {
	
	private MessageSource messageSource;
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String showResultForm(Model model) {
	    return Pages.RESULT;
	}
	
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(@ModelAttribute("admin") CalculateForm formData,
                               BindingResult bundingResult,
                               Model uiModel,
                               HttpServletRequest httpServletRequest,
                               RedirectAttributes redirectAttributes,
                               Locale locale) {
        Message message = validateForm(formData);
        if (message != null) {
            message.setMsg(messageSource.getMessage(message.getKey(), null, locale));
            redirectAttributes.addFlashAttribute(Pages.ATR_MESSAGE, message);
            return "redirect:costCalculation";
        } else {
        	
            return "redirect:order";
        }


    }
    
    
    private Message validateForm(CalculateForm formData) {
//      if (Tools.isBlank(formData.getPsw())) {
//          Message msg = new Message(Type.ERROR, "registration.no-pass");
//          return msg;
//      }
//      if (!formData.getPsw().equals(formData.getPswRepeat())) {
//          Message msg = new Message(Type.ERROR, "registration.wrong-repeat");
//          return msg;
//      }

//      if (Tools.isBlank(formData.getName()) ||
//          Tools.isBlank(formData.getCost())) {
//          Message msg = new Message(Type.ERROR, "registration.missed-field");
//          return msg;
//      }
      return null;
  }
    
    
    @Autowired
    protected void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    @Override
    public boolean isForCustomer() {
        return true;
    }
    
    @Override
    public boolean isForAdmin() {
        return false;
    }
    
}
	

