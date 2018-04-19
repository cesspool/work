package form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import beans.NodeDistance;
import form.request.NewNodeForm;
import service.NodeDistanceService;
import web.Message;
import web.Pages;
import web.Principal;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController extends BaseController{
    private NodeDistanceService nodeService;
    private MessageSource messageSource;
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String showAdminForm(Model model) {
//        if(getPrincipal() == null) {
//            return "redirect:/loginform";
//        }
        
        
        Map<Long, String> res = nodeService.getAllCities();
        model.addAttribute("allCities", res);
        //model.addAttribute("chosenCities", nodeService.getCities(nodeID));
        return Pages.ADMIN;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String boxing(@ModelAttribute("admin") NewNodeForm formData,
                               BindingResult bundingResult,
                               Model uiModel,
                               HttpServletRequest httpServletRequest,
                               RedirectAttributes redirectAttributes,
                               Locale locale) {
        Message message = validateForm(formData);
        if (message != null) {
            message.setMsg(messageSource.getMessage(message.getKey(), null, locale));
            redirectAttributes.addFlashAttribute(Pages.ATR_MESSAGE, message);
            return "redirect:admin";
        } else {
        	if(formData.getIdNode()==null) {
        		NodeDistance nodeDistance = nodeService.createNode(formData);
                redirectAttributes.addFlashAttribute(Pages.ADMIN, formData);
                return "redirect:changingBranch";
        	} else {
        		nodeService.changeNodeById(formData);
        		return "redirect:changingBranch";
        	}
            
        }

    }
    
    @Autowired
    private void setNodeDistanceService(NodeDistanceService service) {
        this.nodeService = service;
    } 
    

    
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public String delete(Model uiModel,
//                               HttpServletRequest httpServletRequest,
//                               RedirectAttributes redirectAttributes,
//                               Locale locale) {
//        Message message = validateForm(formData);
//        if (message != null) {
//            message.setMsg(messageSource.getMessage(message.getKey(), null, locale));
//            redirectAttributes.addFlashAttribute(Pages.ATR_MESSAGE, message);
//            return "redirect:admin";
//        } else {
//            NodeDistance nodeDistance = nodeService.createNode(formData);
//            redirectAttributes.addFlashAttribute(Pages.ADMIN, formData);
//            return "redirect:admin";
//        }
//
//    }
    
    
    
    @Autowired
    protected void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    private Message validateForm(NewNodeForm formData) {
//        if (Tools.isBlank(formData.getPsw())) {
//            Message msg = new Message(Type.ERROR, "registration.no-pass");
//            return msg;
//        }
//        if (!formData.getPsw().equals(formData.getPswRepeat())) {
//            Message msg = new Message(Type.ERROR, "registration.wrong-repeat");
//            return msg;
//        }

//        if (Tools.isBlank(formData.getName()) ||
//            Tools.isBlank(formData.getCost())) {
//            Message msg = new Message(Type.ERROR, "registration.missed-field");
//            return msg;
//        }
        return null;
    }
    
    @Override
    public boolean isForFree() {
        return false;
    }
    
    @Override
    public boolean isForAdmin() {
        return true;
    }
    
}
