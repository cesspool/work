package form.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.Boxing;
import service.BoxingService;
import web.Pages;

@Controller
public class ChangingBoxController extends BaseController {
	
	@Autowired
	private BoxingService service;
	
    @RequestMapping(value = "/changingBox", method = RequestMethod.GET)
    public String showBoxForm(Model model) {
    	List<Boxing> boxes = service.getAllInfoBoxes();
        model.addAttribute("allBoxes", boxes);
        //model.addAttribute("chosenCities", nodeService.getCities(nodeID));
        return Pages.BOX;
    }
    
    @RequestMapping(value = "/changingBox/delete/{id}", method = RequestMethod.GET)
    public String deleteBoxForm(@PathVariable("id") Long id, Model model) {
    	service.deleteBoxing(id);
    	List<Boxing> boxes = service.getAllInfoBoxes();
        model.addAttribute("allBoxes", boxes);
        //model.addAttribute("chosenCities", nodeService.getCities(nodeID));
        return Pages.BOX;
    }
 
    
}
