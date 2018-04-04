package service;


import java.util.Map;

import beans.Boxing;
import form.request.NewBoxingForm;

public interface BoxingService {
    void createBoxing(Boxing boxing);
    Boxing createBoxing(NewBoxingForm boxForm);
    public Map<Long, String> getAllBoxes();
    void deleteBoxing(Boxing boxing);
}
