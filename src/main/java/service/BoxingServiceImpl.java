package service;

import beans.Boxing;
import dbservice.BoxingDAOService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BoxingServiceImpl implements BoxingService {
    private static final Logger logger = LoggerFactory.getLogger(BoxingServiceImpl.class);

    private BoxingDAOService boxingDAOService;

    public void createBoxing(Boxing box) {
        if (box != null) {
            // validate the bean's fileds
            boxingDAOService.insertBoxing(box);
        }
    }
}
