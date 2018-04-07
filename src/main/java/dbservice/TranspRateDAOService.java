package dbservice;

import beans.Rate;
import beans.Transport;
import beans.TransportRate;
import utils.Pair;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface TranspRateDAOService {
    void insertRate(TransportRate transportRate);

    Pair<Rate, Transport> getByDate(LocalDate date);
    
    public List<Transport> getAllTransports();

    Collection<Transport> getTransports();
    public List<Rate> getCurrentRate();
}
