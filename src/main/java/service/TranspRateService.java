package service;

import beans.Rate;
import beans.Transport;

public interface TranspRateService {
    void createRate(Rate rate, Transport transport);
    Transport getByID(Long ID);
}
