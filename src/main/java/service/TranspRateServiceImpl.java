package service;

import beans.Boxing;
import beans.Rate;
import beans.Transport;
import beans.TransportRate;
import dbservice.TranspRateDAOService;
import form.request.NewAgreementForm;
import form.request.NewBoxingForm;
import utils.Tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
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
    public TransportRate createRate(NewAgreementForm rateForm) {
    	TransportRate transportRate = Tools.newAgreementFormToTransportRate(rateForm);
        createRate(transportRate);
        return transportRate;
    }

    @Override
    public void createRate(TransportRate transportRate){
        if (transportRate!=null) {
            // validate the bean's fileds
        	transportRate.getTransport().setTotalCapacity(transportRate.getTransport().getMaxHeight() *
        			transportRate.getTransport().getMaxLength() * transportRate.getTransport().getMaxWidth());
                transpRateDAOService.insertRate(transportRate);
        }
    }

    @Override
    public Transport getByID(Long ID){
        return transportCache.get(ID);
    }
}
