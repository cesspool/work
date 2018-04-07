package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.Boxing;
import beans.CharacteristicsPath;
import beans.Distance;
import beans.Node;
import beans.Package;
import beans.Rate;
import beans.Order;
import beans.OrderCalculate;
import beans.Transport;
import dbservice.BoxingDAOService;
import dbservice.BoxingDAOServiceImpl;
import dbservice.NodeDistanceDAOService;
import dbservice.NodeDistanceDAOServiceImpl;
import dbservice.TranspRateDAOService;
import dbservice.TranspRateDAOServiceImpl;
import dijkstra.Test;
import exception.PathNotFoundException;
import form.request.CalculateForm;
import form.response.CalculateReq;
import utils.Pair;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private NodeDistanceDAOService nodeDistanceDAOService = new NodeDistanceDAOServiceImpl();
    @Autowired
    private TranspRateDAOService transpRateDAOService = new TranspRateDAOServiceImpl();
    @Autowired
    private BoxingDAOService boxingDAOService = new BoxingDAOServiceImpl();
    
    private CalculateReq calculateReq =  new CalculateReq();
	
    @Override
	public CalculateReq prepareOrder(CalculateForm form) throws PathNotFoundException {
    	Boxing box = boxingDAOService.getCostByID(form.getBoxesList());
    	double costOfBoxing = box.getCost();
    	List<Transport> transports = transpRateDAOService.getAllTransports();
    	//CalculateReq calculateReq = new CalculateReq();
		CharacteristicsPath charPath = pathCalculate(form, transports);
		calculateReq.setFullPath(getNodesTransport(charPath, transports));
		calculateReq.setTotalCost(conversionCost(charPath, costOfBoxing));
		calculateReq.setQuatityHours(Math.round(charPath.getTime()));
		calculateReq.setDateDelivery(conversionDate(charPath));
		calculateReq.setTypeDelivery(getTypeDelivery(charPath.getTransport()));
		
		return calculateReq;
    }
	
	
    @Override
	public CharacteristicsPath pathCalculate(CalculateForm form, List<Transport> transports) throws PathNotFoundException {
    	Package cargo = new Package();
    	cargo.isEnvelope(form.isEnvelope());
    	cargo.setLength(form.getLength());
    	cargo.setWidth(form.getWidth());
    	cargo.setHeight(form.getHeight());
    	cargo.setWeight(form.getWeight());
    	cargo.setQuantity(form.getQuantity());
		Map<Long, String> nodes = nodeDistanceDAOService.getAllCities();
		List<Distance> distances = nodeDistanceDAOService.getAllDistances();
		List<Pair<Long, Long>> nodeTransport = nodeDistanceDAOService.getAllNodeTransports();
		List<Rate> rates = transpRateDAOService.getCurrentRate();
		Order order = new Order();
		
		Node nodeStart = nodeDistanceDAOService.getByName(form.getCityStart());
		Node nodeTarget = nodeDistanceDAOService.getByName(form.getCityTarget());
		order.setNodeStart(nodeStart.getId());
		order.setNodeTarget(nodeTarget.getId());
		order.isUrgency(form.isUrgency());
		Test calculate = new Test();
		CharacteristicsPath charPath = calculate.testExcute(nodes, distances, transports, rates, order, nodeTransport, cargo);
		return charPath;
	}
    
    public double conversionCost(CharacteristicsPath charPath, double costOfBoxing) {
    	double fullCost = charPath.getCost()+costOfBoxing;
    	return fullCost;
    }
    
    
    public String getNodesTransport(CharacteristicsPath charPath, List<Transport> transports) {
    	String fullPath = new String();
    	charPath.getPath();
    	charPath.getTransport();
    	Map<Integer, String> transportMap = new HashMap();
    	transportMap.put(0, transports.get(0).getVariety());
    	transportMap.put(1, transports.get(1).getVariety());
    	transportMap.put(2, transports.get(2).getVariety());
    	for (int i =0; i< charPath.getTransport().size(); i++) {
    		fullPath += charPath.getPath().get(i) +" - "+ transportMap.get(charPath.getTransport().get(i)) +" - ";
    	}
    	fullPath = fullPath + charPath.getPath().get(charPath.getPath().size()-1) ;
    	return fullPath;
    }
    
    public String getTypeDelivery(List<Integer> transports) {
    	if((transports == null) || transports.isEmpty()) {
    		return null;
    	}
    	boolean allEq = transports.stream().allMatch(transports.get(0)::equals);
    	if (!allEq) {
    		return "result.transport-multiple";
    	}
    	String key = null;
    	switch(transports.get(0)) {
    		case 0 :
    			key = "result.transport-cargo";
    			break;
    		case 1 :
    			key = "result.transport-air";
    			break;
    		case 2 :
    			key = "result.transport-rail";
    			break;
    	}
    	
    	// all equal 0 - cargo
    	// all equal 1 - air
    	// all equal 2 - rail
    	// -multipal
    	return key;
    }
    
    public String conversionDate(CharacteristicsPath charPath) {
    	int hours = (int)Math.round(charPath.getTime());
    	Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(new Date()); // sets calendar time/date
        cal.add(Calendar.HOUR_OF_DAY, hours); // adds one hour
        cal.getTime(); // returns new date object, one hour in the future
        
    	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    	return dateFormat.format(cal.getTime());
    }
	
}
