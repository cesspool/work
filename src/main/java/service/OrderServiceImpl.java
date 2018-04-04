package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.CharacteristicsPath;
import beans.Distance;
import beans.Node;
import beans.Order;
import beans.OrderCalculate;
import beans.Transport;
import dbservice.NodeDistanceDAOService;
import dbservice.NodeDistanceDAOServiceImpl;
import dbservice.TranspRateDAOService;
import dbservice.TranspRateDAOServiceImpl;
import dijkstra.Test;
import form.request.CalculateForm;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
	NodeDistanceDAOService nodeDistanceDAOService = new NodeDistanceDAOServiceImpl();
    @Autowired
	TranspRateDAOService transpRateDAOService = new TranspRateDAOServiceImpl();
	
    @Override
	public OrderCalculate prepareOrder(CalculateForm form) {
		OrderCalculate orderCalculate = new OrderCalculate();
		CharacteristicsPath charPath = pathCalculate(form);
		conversionData(charPath);
		return orderCalculate;
	}
	
    @Override
	public CharacteristicsPath pathCalculate(CalculateForm form) {
		Map<Long, String> nodes = nodeDistanceDAOService.getAllCities();
		List<Distance> distances = nodeDistanceDAOService.getAllDistances();
		List<Transport> transports = transpRateDAOService.getAllTransports();
		Map<Long, Long> nodeTransport = nodeDistanceDAOService.getAllNodeTransports();
		Order order = new Order();
		
		Node nodeStart = nodeDistanceDAOService.getByName(form.getCityStart());
		Node nodeTarget = nodeDistanceDAOService.getByName(form.getCityTarget());
		order.setNodeStart(nodeStart.getId());
		order.setNodeTarget(nodeTarget.getId());
		order.isUrgency(form.isUrgency());
		Test calculate = new Test();
		CharacteristicsPath charPath = calculate.testExcute(nodes, distances, transports, order, nodeTransport);
		return charPath;
	}
    
    @Override
    public void conversionData(CharacteristicsPath charPath) {
    	//charPath.ge
    }
	
}
