package form.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.Order;
import service.OrderService;
import web.Pages;

@Controller
public class ReportController extends BaseController {
	private OrderService orderService;
    private MessageSource messageSource;
    
    
    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public String showReportForm(Model model) {
    	List<Order> urgOrders = orderService.getUrgencyOrder(true);
    	List<Order> ecOrders = orderService.getUrgencyOrder(false);
    	List<List<Order>> totalReadyMorePlan = new ArrayList<>();
    	List<List<Order>> totalReadyEqualPlan = new ArrayList<>();
    	List<List<Order>> totalReadyLessPlan = new ArrayList<>();
    	List<Double> average = new ArrayList<>();
    	double divider = 0;
    	double pieCost=0;
    	double comboCost=0;
    	for (int i = 1; i< 6; i++) {
    		totalReadyMorePlan.add(orderService.getOrderReadyMorePlan(i));
    		if(orderService.getOrderReadyMorePlan(i).size()!=0) {
    			divider++;
    		}
    		totalReadyEqualPlan.add(orderService.getOrderReadyEqualPlan(i));
    		if(orderService.getOrderReadyEqualPlan(i).size()!=0) {
    			divider++;
    		}
    		totalReadyLessPlan.add(orderService.getOrderReadyLessPlan(i));
    		if(orderService.getOrderReadyLessPlan(i).size()!=0) {
    			divider++;
    		}
    		average.add((orderService.getOrderReadyMorePlan(i).size() + 
    				orderService.getOrderReadyEqualPlan(i).size() +
    				orderService.getOrderReadyLessPlan(i).size())/divider );
    		
    	}
    	comboCost = Math.ceil(getComboCost(totalReadyMorePlan) + getComboCost(totalReadyEqualPlan) + 
    			getComboCost(totalReadyLessPlan));
    	pieCost = Math.ceil(getPieCost(urgOrders) + getPieCost(ecOrders));
    	model.addAttribute("urgOrd", urgOrders);
    	model.addAttribute("ecOrd", ecOrders);
    	model.addAttribute("readyMore", totalReadyMorePlan);
    	model.addAttribute("readyEqual", totalReadyEqualPlan);
    	model.addAttribute("readyLess", totalReadyLessPlan);
    	model.addAttribute("average", average);
    	model.addAttribute("comboCost", comboCost);
    	model.addAttribute("pieCost", pieCost);
        return Pages.REPORT;
    }
    

    @Autowired
    public void setOrderService(OrderService service) {
    	this.orderService = service;
    }
    
    @Autowired
    protected void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    private double getComboCost(List<List<Order>> totalReadyMorePlan) {
    	double costOrder = 0;
		for(List<Order> ordersList : totalReadyMorePlan) {
			for(Order order: ordersList) {
				costOrder = costOrder + order.getCost();
			}
		}
		return costOrder;
    }
    
    
    private double getPieCost(List<Order> ordersList) {
    	double costOrder = 0;
		for(Order order: ordersList) {
			costOrder = costOrder + order.getCost();
		}
		return costOrder;
    }
    
}
