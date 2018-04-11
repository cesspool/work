package service;

import beans.Boxing;
import dbservice.BoxingDAOService;
import form.request.NewBoxingForm;
import utils.Tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BoxingServiceImpl implements BoxingService {
    private static final Logger logger = LoggerFactory.getLogger(BoxingServiceImpl.class);
    
    @Autowired
    private BoxingDAOService boxingDAOService;
    
    @Override
    public List<Boxing> getAllInfoBoxes(){
    	List<Boxing> boxes = boxingDAOService.getAllInfoBoxes();
    	return boxes;
    }

    @Override
    public void createBoxing(Boxing boxing) {
        if (boxing != null) {
            // validate the bean's fileds
            boxingDAOService.insertBoxing(boxing);
        }
    }

    @Override
    public Boxing createBoxing(NewBoxingForm boxForm) {
        Boxing box = Tools.boxingFormToBoxing(boxForm);
        createBoxing(box);
        return box;
    }
    

    @Override
    public Map<Long, String> getAllBoxes() {
        return boxingDAOService.getAllBoxes();
    }
    
    @Override
    public void deleteBoxing(Long id){
        boxingDAOService.deleteBoxing(id);
    }
    
}
