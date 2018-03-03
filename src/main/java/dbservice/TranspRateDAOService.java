package dbservice;

import beans.Rate;
import beans.Transport;
import utils.Pair;

import java.time.LocalDate;
import java.util.Collection;

public interface TranspRateDAOService {
    void insertRate(Rate rate, Transport transport);

    Pair<Rate, Transport> getByDate(LocalDate date);

    Collection<Transport> getTransports();
}
