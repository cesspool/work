package dbservice;

import beans.Rate;
import beans.Transport;
import beans.TransportRate;
import utils.Pair;

import java.time.LocalDate;
import java.util.Collection;

public interface TranspRateDAOService {
    void insertRate(TransportRate transportRate);

    Pair<Rate, Transport> getByDate(LocalDate date);

    Collection<Transport> getTransports();
}
