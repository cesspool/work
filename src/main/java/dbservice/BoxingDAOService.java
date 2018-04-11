package dbservice;

import java.util.List;
import java.util.Map;

import beans.Boxing;

public interface BoxingDAOService {
    void insertBoxing(Boxing boxing);
    void deleteBoxing(Long ID);
    Map<Long, String> getAllBoxes();
    public Boxing getCostByID(Long ID);
    public List<Boxing> getAllInfoBoxes();
}