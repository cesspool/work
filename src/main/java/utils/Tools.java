package utils;

import beans.Boxing;
import beans.Customer;
import beans.NodeDistance;
import beans.Order;
import beans.OrderCalculate;
import beans.OrderShow;
import beans.OrderWriter;
import beans.Rate;
import beans.Transport;
import beans.TransportRate;
import form.request.CalculateForm;
import form.request.NewAgreementForm;
import form.request.NewBoxingForm;
import form.request.NewNodeForm;
import form.request.OrderingForm;
import form.request.RegistrationForm;
import form.response.OrderingReq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import beans.Package;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tools {
    private static final Logger logger = LoggerFactory.getLogger(Tools.class);
    
    public static String stringToMD5(String str){
        try {
            MessageDigest msgDigst = MessageDigest.getInstance("MD5");
            byte[] md5 = msgDigst.digest(str.getBytes("UTF-8"));
            return new String(md5);
        } catch (NoSuchAlgorithmException algEx) {
            logger.error(algEx.getMessage(), algEx);
            throw new RuntimeException(algEx);
        } catch (UnsupportedEncodingException encEx) {
            logger.error(encEx.getMessage(), encEx);
            throw new RuntimeException(encEx);
        }
    }

    
    public static boolean isBlank(String str) {
        if ((str == null) && (str.trim().length() == 0)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static Date fromSQLDate(java.sql.Date sqlDate) {
    	return new Date(sqlDate.getTime());
    }
    
    public static java.sql.Date toSQLDate(Date date) {
    	return new java.sql.Date(date.getTime());
    }
    
    
    public static Customer registrationFormToCustomer(RegistrationForm form) {
        Customer cmr = new Customer();
        cmr.setFirstName(form.getFirstName());
        cmr.setLastName(form.getLastName());
        cmr.setPatronymic(form.getPatronymic());
        cmr.setAddress(form.getCity());
        cmr.setEmail(form.getEmail());
        cmr.setTelephone(form.getTelephone());
        cmr.setMd5(form.getPsw());
        if (form.getPrivilege()==1) {
        	cmr.setManager(true);
        	cmr.setAdmin(false);
        }
        if (form.getPrivilege()==2) {
        	cmr.setManager(false);
        	cmr.setAdmin(true);
        } else {
        	cmr.setAdmin(false);
        	cmr.setManager(false);
        }

        return cmr;
    }

    
    public static RegistrationForm customerToRegistrationForm(Customer cmr) {
        RegistrationForm form = new RegistrationForm();
        form.setFirstName(cmr.getFirstName());
        form.setLastName(cmr.getLastName());
        form.setPatronymic(cmr.getPatronymic());
        form.setCity(cmr.getAddress());
        form.setEmail(cmr.getEmail());
        form.setTelephone(cmr.getTelephone());
        if (cmr.isAdmin()) {
        	form.setPrivilege(2);
        }
        if(cmr.isManager()) {
        	form.setPrivilege(1);
        } else {
        	form.setPrivilege(0);
        }
        return form;
    }
    
    public static Boxing boxingFormToBoxing(NewBoxingForm form) {
    	Boxing box = new Boxing();
    	box.setVariety(form.getName());
    	box.setCost(form.getCost());
    	return box;
    }
    
    public static NewBoxingForm boxingToNewBoxingForm (Boxing box) {
    	NewBoxingForm form = new NewBoxingForm();
    	form.setName(box.getVariety());
    	form.setCost(form.getCost());
    	return form;
    }
    
    public static TransportRate newAgreementFormToTransportRate(NewAgreementForm form) {
    	Transport transport = new Transport();
    	transport.setMaxHeight(form.getMaxHeight());
    	transport.setMaxWidth(form.getMaxWidth());
    	transport.setMaxLength(form.getMaxLength());
    	transport.setTotalWeight(form.getTotalWeight());
    	
    	Rate rateCargo = new Rate();	
    	rateCargo.setName(form.getName());
    	rateCargo.setCostShipping(form.getCostShippingCargo());
    	rateCargo.setAdditionalCost(form.getAddCostShippingCargo());
    	rateCargo.setStartAction(form.getStartAction());
    	rateCargo.setEndAction(form.getEndAction());
    	rateCargo.setTransportID(form.getCargoID());
    	
    	Rate rateAir = new Rate();
    	rateAir.setName(form.getName());
    	rateAir.setCostShipping(form.getCostShippingAir());
    	rateAir.setAdditionalCost(form.getAddCostShippingAir());
    	rateAir.setStartAction(form.getStartAction());
    	rateAir.setEndAction(form.getEndAction());
    	rateAir.setTransportID(form.getAirID());
    	
    	Rate rateRail = new Rate();
    	rateRail.setName(form.getName());
    	rateRail.setCostShipping(form.getCostShippingRail());
    	rateRail.setAdditionalCost(form.getAddCostShippingRail());
    	rateRail.setStartAction(form.getStartAction());
    	rateRail.setEndAction(form.getEndAction());
    	rateRail.setTransportID(form.getRailID());
    	List<Rate> rates = new ArrayList<>();
    	rates.add(rateCargo);
    	rates.add(rateAir);
    	rates.add(rateRail);
    	TransportRate transportRate = new TransportRate(rates, transport);
    	return transportRate;
    }
    
    
    public static NodeDistance NewNodeFormToNodeDistance(NewNodeForm form) {
    	NodeDistance nodeDistance = new NodeDistance();
    	nodeDistance.getNode().setName(form.getName());
    	nodeDistance.getNode().setCity(form.getCity());
    	nodeDistance.getNode().setAddress(form.getAddress());
    	nodeDistance.getNode().setCoordinateX(form.getCoordinateX());
    	nodeDistance.getNode().setCoordinateY(form.getCoordinateY());
    	if (form.getAirport() != 0) {
    		nodeDistance.getTransport().add(form.getAirport());
    	}
    	if (form.getRailway() !=0) {
    		nodeDistance.getTransport().add(form.getRailway());
    	}
    	
    	String selCities = form.getSelectedCities();
    	if (selCities.trim().length() > 0) {
    		String[] cityIDs = selCities.split(",");
    		int ln = cityIDs.length;
    		nodeDistance.setCities(cityIDs);
    	}
    	//nodeDistance.setAllCities(form.getAllCities());
    	return nodeDistance;
    }
    
    public static OrderCalculate CalculateFormToCalculateOrder(CalculateForm form) {
    	OrderCalculate orderCalculate = new OrderCalculate();
//    	orderCalculate.getCargo().isEnvelope(form.isEnvelope());
//    	orderCalculate.getCargo().setLength(form.getLength());
//    	orderCalculate.getCargo().setWidth(form.getWidth());
//    	orderCalculate.getCargo().setHeight(form.getHeight());
//    	orderCalculate.getCargo().setWeight(form.getWeight());
//    	orderCalculate.getCargo().setQuantity(form.getQuantity());
    	return orderCalculate;
    }
    
    public static String orderingFormToString(OrderingForm formData) {
    	String info = new String();
    	info = formData.getFirstName()+" "+formData.getLastName()+" "+
    			formData.getPatronymic()+" - "+formData.getTelephone();
    	return info;
    }
    
    public static Order orderWriterToOrder(OrderWriter orderWriter, OrderingForm formData) {
    	String info = orderingFormToString(formData);
    	Order order = new Order();
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    	try {
    		order.setPlanDate(formatter.parse(orderWriter.getCalculateReq().getDateDelivery()));
    	} catch (ParseException e) {
    		e.printStackTrace();
    	}
    	order.setRecipientId(orderWriter.getRecipientId());
    	order.isUrgency(orderWriter.getForm().isUrgency());
    	order.setReady(false);
    	order.setCost(orderWriter.getCalculateReq().getTotalCost());
    	order.setContact_information(info);   	
    	order.setBoxingId(orderWriter.getForm().getBoxesList());
    	order.setNodeStart(orderWriter.getCalculateReq().getPathId().get(0));
    	order.setNodeTarget(orderWriter.getCalculateReq().getPathId()
    				.get(orderWriter.getCalculateReq().getPathId().size()-1));
    	return order;
    }
    
    public static Package orderWriterCargo(OrderWriter orderWriter) {
    	Package cargo = new Package();
    	cargo.setName("1");
    	cargo.isEnvelope(orderWriter.getForm().isEnvelope());
    	cargo.setHeight(orderWriter.getForm().getHeight());
    	cargo.setWidth(orderWriter.getForm().getWidth());
    	cargo.setLength(orderWriter.getForm().getLength());
    	cargo.setWeight(orderWriter.getForm().getWeight());
    	cargo.setQuantity(orderWriter.getForm().getQuantity());
    	cargo.setSize(orderWriter.getForm().getHeight() *
    			orderWriter.getForm().getWidth() *
    			orderWriter.getForm().getLength());
    	return cargo;
    }
    
    public static List<OrderingReq> orderToHistoryForm(List<OrderShow> orders) {
    	List<OrderingReq> orderReq = new ArrayList();
    	for (OrderShow ord : orders) {
    		OrderingReq order = new OrderingReq();
    		if (ord.getOrder().isUrgency()==true) {
    			order.setTypeDelivery("history.express-delivery");
    		} else {
    			order.setTypeDelivery("history.econom-delivery");
    		}
    		if (ord.getCargo().isEnvelope()==true) {
    			order.setTypeCargo("history.envelope-package");
    		} else {
    			order.setTypeCargo("history.cargo-package");
    		}
    		order.setBox(ord.getBox());
    		order.setCargo(ord.getCargo());
    		order.setOrder(ord.getOrder());
    		order.setNodeStart(ord.getNodeStart());
    		order.setNodeEnd(ord.getNodeEnd());
    		orderReq.add(order);
    	}
    	//orderReq.getBox.setVariety((order.getBox().getVariety()));
    	return orderReq;
    }

}
