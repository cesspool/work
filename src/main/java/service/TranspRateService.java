package service;

import beans.Rate;
import beans.Transport;
import beans.TransportRate;
import form.request.NewAgreementForm;

public interface TranspRateService {
    void createRate(TransportRate transportRate);
    TransportRate createRate(NewAgreementForm Agrform);
    Transport getByID(Long ID);
}
