package dbservice;

import beans.Rate;
import beans.Transport;

import java.util.Collection;

public interface TranspRateDAOService {
    void insertRate(Rate rate, Transport transport);

    Collection<Transport> getTransports();
}
