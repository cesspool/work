package service;

import beans.Boxing;
import beans.Rate;
import beans.Transport;
import beans.TransportRate;
import dbservice.TranspRateDAOService;
import exception.LogisticsException;
import form.request.NewAgreementForm;
import form.request.NewBoxingForm;
import form.request.TransportForm;
import utils.Tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TranspRateServiceImpl implements TranspRateService {
    private static final Logger logger = LoggerFactory.getLogger(TranspRateServiceImpl.class);

    private Map<Long, Transport> transportCache = new HashMap<>();
    
    @Autowired
    private TranspRateDAOService transpRateDAOService;

//    @PostConstruct
//    private void init(){
//        transpRateDAOService.getTransports().forEach(tr -> {
//            transportCache.put(tr.getId(), tr);
//        });
//    }
    @Override
    public List<Transport> getAllTransports() {
    	List<Transport> transports = new ArrayList<>();
    	transports=transpRateDAOService.getAllTransports();
    	return transports;
    }
    
    @Override 
    public void updateRateById(NewAgreementForm formData) throws LogisticsException {
    	List<Rate> rates = Tools.newAgreementFormToRate(formData);
    	transpRateDAOService.updateRateById(rates);
    }
    
    @Override
    public void updateTransport(TransportForm formData) {
    	Transport trans = Tools.newAgreementFormToTransport(formData);
    	transpRateDAOService.updateTransport(trans);
    }
    
    @Override
    public List<Rate> getAllRates(){
    	List<Rate> rates = transpRateDAOService.getAllRate();
    	return rates;
    }
    @Override
    public List<Rate> getRatesById(Long ID){
    	List<Rate> rates = transpRateDAOService.getRatesById(ID);
    	return rates;
    }
    
    
    @Override
    public List<Rate> createRate(NewAgreementForm rateForm) throws LogisticsException{
    	List<Rate> rates = Tools.newAgreementFormToRate(rateForm);
    	createRate(rates);
        return rates;
    }

    @Override
    public void createRate(List<Rate> rates) throws LogisticsException{
        if (rates!=null) {
            // validate the bean's fileds
//        	transportRate.getTransport().setTotalCapacity(transportRate.getTransport().getMaxHeight() *
//        			transportRate.getTransport().getMaxLength() * transportRate.getTransport().getMaxWidth());
                transpRateDAOService.insertRate(rates);
        }
    }

    @Override
    public Transport getByID(Long ID){
        return transportCache.get(ID);
    }
}
