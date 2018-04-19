package dbservice;

import beans.Rate;
import beans.Transport;
import beans.TransportRate;
import exception.RateAlreadyExistException;
import utils.Pair;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface TranspRateDAOService {
	public void insertRate(List<Rate> rates) throws RateAlreadyExistException;

    Pair<Rate, Transport> getByDate(LocalDate date);
    
    public List<Transport> getAllTransports();
    public void updateTransport(Transport transport);
    public Collection<Transport> getTransports();
    public List<Rate> getCurrentRate();
    public List<Rate> getRatesById(Long ID);
    public List<Rate> getAllRate();
    public void updateRateById(List<Rate> rates);// throws RateAlreadyExistException;
    public void insertTransport(Transport transport);
}
