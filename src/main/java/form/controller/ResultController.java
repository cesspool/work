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

import beans.NodeDistance;
import form.request.NewNodeForm;
import form.response.CalculateReq;
import service.NodeDistanceService;
import web.Message;
import web.Pages;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ResultController {
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String showResultForm(Model model) {
		CalculateReq calculateReq = new CalculateReq();
		calculateReq.setTypeDelivery("1234");
		calculateReq.setTotalCost(158);
		//calculateReq.setDateCurrent();
		//calculateReq.setDateDelivery("");
		calculateReq.setPath("123");
		
	    model.addAttribute("typeDelivery", calculateReq.getTypeDelivery());
	    model.addAttribute("totalCost", calculateReq.getTotalCost());
	    model.addAttribute("dateSending", calculateReq.getDateCurrent());
	    model.addAttribute("dateDelivery", calculateReq.getDateDelivery());
	    model.addAttribute("fullPath", calculateReq.getPath());
	    return Pages.RESULT;
	}
}
	

