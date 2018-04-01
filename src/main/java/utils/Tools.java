package utils;

import beans.Boxing;
import beans.Customer;
import beans.NodeDistance;
import beans.Rate;
import beans.Transport;
import beans.TransportRate;
import form.request.NewAgreementForm;
import form.request.NewBoxingForm;
import form.request.NewNodeForm;
import form.request.RegistrationForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        cmr.setAdmin(form.isAdmin());
        cmr.setManager(form.isManager());
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
        form.setAdmin(cmr.isAdmin());
        form.setManager(cmr.isManager());
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
    	//nodeDistance.setAllCities(form.getAllCities());
    	return nodeDistance;
    }

}
