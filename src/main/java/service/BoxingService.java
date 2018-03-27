package service;


import beans.Boxing;
import form.request.NewBoxingForm;

public interface BoxingService {
    void createBoxing(Boxing boxing);
    Boxing createBoxing(NewBoxingForm boxForm);
    void deleteBoxing(Boxing boxing);
}
