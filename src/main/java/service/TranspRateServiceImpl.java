package service;

import beans.Rate;
import beans.Transport;
import dbservice.TranspRateDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class TranspRateServiceImpl implements TranspRateService {
    private static final Logger logger = LoggerFactory.getLogger(TranspRateServiceImpl.class);

    private Map<Long, Transport> transportCache = new HashMap<>();

    private TranspRateDAOService transpRateDAOService;

//    @PostConstruct
//    private void init(){
//        transpRateDAOService.getTransports().forEach(tr -> {
//            transportCache.put(tr.getId(), tr);
//        });
//    }

    @Override
    public void createRate(Rate rate, Transport transport){
        if ((rate != null)||(transport!=null)) {
            // validate the bean's fileds
                transpRateDAOService.insertRate(rate, transport);
        }
    }

    @Override
    public Transport getByID(Long ID){
        return transportCache.get(ID);
    }
}
