package form.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import beans.NodeDistance;
import beans.OrderCalculate;
import beans.OrderWriter;
import exception.PathNotFoundException;
import form.request.CalculateForm;
import form.request.NewNodeForm;
import form.response.CalculateReq;
import service.BoxingService;
import service.NodeDistanceService;
import service.OrderService;
import web.Message;
import web.Pages;

@Controller
@SessionAttributes("orderWriter")
public class CostController extends BaseController {
    private NodeDistanceService nodeService;
    private BoxingService boxingService;
    private MessageSource messageSource;
    private OrderService orderService;
    private CalculateReq calculateReq = new CalculateReq();
    
    @RequestMapping(value = "/costCalculation", method = {/**RequestMethod.POST, **/RequestMethod.GET}) // value = /costCalculation
    public String showOrderForm(Model model) {
        Map<Long, String> res = nodeService.getAllCities();
        Map<Long, String> bx = boxingService.getAllBoxes();
        model.addAttribute("allCities", res);
        model.addAttribute("allBoxes", bx);
    	model.addAttribute("envelopVal", 1);
    	model.addAttribute("cargoVal", 0);
    	model.addAttribute("economyVal", 0);
    	model.addAttribute("expressVal", 1);
        
        return Pages.COST;// "redirect:cost"; //Pages.RESULT;
    }
    
    @RequestMapping(value = "/costCalculation", method = RequestMethod.POST)
    public String boxing(@ModelAttribute("admin") CalculateForm formData,
                               BindingResult bundingResult,
                               Model uiModel,
                               HttpServletRequest httpServletRequest,
                               RedirectAttributes redirectAttributes,
                               Locale locale) {
        Message message = validateForm(formData);
        if (message != null) {
            message.setMsg(messageSource.getMessage(message.getKey(), null, locale));
            redirectAttributes.addFlashAttribute(Pages.ATR_MESSAGE, message);
            return "redirect:result";
        } else {
        	try {
        		OrderWriter orderWriter = new OrderWriter();
	        	calculateReq = orderService.prepareOrder(formData);
	        	calculateReq.setTypeDelivery(messageSource.getMessage(calculateReq.getTypeDelivery(), null, locale));
        		orderWriter.setForm(formData);
        		orderWriter.setCalculateReq(calculateReq);
        		uiModel.addAttribute("orderWriter", orderWriter);
	        	uiModel.addAttribute(Pages.ATR_COST_CALC_RESULT, calculateReq);
	            return "resultCost";
        	} catch(PathNotFoundException ex) {
        		Message errMsg = ex.getMsg();
        		errMsg.setMsg(messageSource.getMessage(errMsg.getKey(), null, locale));
        		uiModel.addAttribute(Pages.ATR_MESSAGE, errMsg);
        		return "personCost";
        	}    
        }
    }
    
    
    
    private Message validateForm(CalculateForm formData) {
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
    

    @Autowired
    private void setOrderService(OrderService service) {
        this.orderService = service;
    }
    

    @Autowired
    private void setNodeDistanceService(NodeDistanceService service) {
        this.nodeService = service;
    } 
    
    @Autowired
    private void setBoxingService(BoxingService service) {
        this.boxingService = service;
    }

	public CalculateReq getCalculateReq() {
		return calculateReq;
	}

	public void setCalculateReq(CalculateReq calculateReq) {
		this.calculateReq = calculateReq;
	} 
    
    @Autowired
    protected void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    
}
