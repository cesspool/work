package form.controller;
import form.request.NewBoxingForm;
import form.request.NewNodeForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import beans.Boxing;
import beans.Distance;
import beans.Node;
import beans.NodeDistance;
import service.BoxingService;
import service.NodeDistanceService;
import utils.Pair;
import utils.Tools;
import web.Message;
import web.Pages;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import web.Message.Type;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ChangingBranchController extends BaseController {
    private NodeDistanceService nodeService;
    private MessageSource messageSource;

    @RequestMapping(value = "/changingBranch", method = RequestMethod.GET)
    public String showBranchForm(Model model) {
        Map<Long, String> res = nodeService.getAllCities();
        model.addAttribute("allCities", res);
        //model.addAttribute("chosenCities", nodeService.getCities(nodeID));
        return Pages.BRANCH;
    }
    
    @RequestMapping(value = "/changingBranch/delete/{id}", method = RequestMethod.GET)
    public String deleteBranch(@PathVariable("id") Long id, Model model) {
    	nodeService.deleteNodeById(id);
        Map<Long, String> res = nodeService.getAllCities();
        model.addAttribute("allCities", res);
        //model.addAttribute("chosenCities", nodeService.getCities(nodeID));
        return Pages.BRANCH;
    } 
    
    @RequestMapping(value = "/changingBranch/change/{id}", method = RequestMethod.GET)
    public String changeBranch(@PathVariable("id") Long id, Model model) {
    	//NewNodeForm nodeForm = nodeService.changeNodeById(id);
        Map<Long, String> linkedNode = nodeService.getCities(id);
        Map<Long, String> allNode = nodeService.getAllCities();
        Node node = nodeService.getInfoNode(id);
        node.setId(id);
        allNode.keySet().removeAll(linkedNode.keySet());
        allNode.remove(id);
        model.addAttribute("allCities", allNode);
        model.addAttribute("linkedNodes", linkedNode);
        model.addAttribute("node", node);
        //model.addAttribute("chosenCities", nodeService.getCities(nodeID));
        return Pages.ADMIN;
    }
    

	    @Autowired
	    private void setNodeDistanceService(NodeDistanceService service) {
	        this.nodeService = service;
	    } 

	    @Autowired
	    protected void setMessageSource(MessageSource messageSource) {
	        this.messageSource = messageSource;
	    }
	    
	    private Message validateForm(NewNodeForm formData) {
//	        if (Tools.isBlank(formData.getPsw())) {
//	            Message msg = new Message(Type.ERROR, "registration.no-pass");
//	            return msg;
//	        }
//	        if (!formData.getPsw().equals(formData.getPswRepeat())) {
//	            Message msg = new Message(Type.ERROR, "registration.wrong-repeat");
//	            return msg;
//	        }

//	        if (Tools.isBlank(formData.getName()) ||
//	            Tools.isBlank(formData.getCost())) {
//	            Message msg = new Message(Type.ERROR, "registration.missed-field");
//	            return msg;
//	        }
	        return null;
	    }
	    
	
}
