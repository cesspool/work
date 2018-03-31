package form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.NodeDistanceService;
import web.Pages;

import java.util.Map;

@Controller
public class AdminController {
    private NodeDistanceService nodeService;
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String showAdminForm(Model model) {
        Map<Long, String> res = nodeService.getAllCities();
        model.addAttribute("allCities", res);
        //model.addAttribute("chosenCities", nodeService.getCities(nodeID));
        return Pages.ADMIN;
    }

    @Autowired
    private void setNodeDistanceService(NodeDistanceService service) {
        this.nodeService = service;
    } 
}
