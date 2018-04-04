package dbservice;

import java.util.Map;

import beans.Boxing;

public interface BoxingDAOService {
    void insertBoxing(Boxing boxing);
    void deleteBoxing(Boxing boxing);
    Map<Long, String> getAllBoxes();
}