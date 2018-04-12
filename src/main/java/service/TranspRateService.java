package service;

import java.util.List;

import beans.Rate;
import beans.Transport;
import beans.TransportRate;
import form.request.NewAgreementForm;
import form.request.TransportForm;

public interface TranspRateService {
	public void createRate(List<Rate> rates);
    public List<Rate> createRate(NewAgreementForm rateForm);
    Transport getByID(Long ID);
    public List<Rate> getAllRates();
    public List<Rate> getRatesById(Long ID);
    public List<Transport> getAllTransports();
    public void updateTransport(TransportForm formData);
    public void updateRateById(NewAgreementForm formData);
}
