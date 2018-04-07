package service;

import java.util.List;

import beans.CharacteristicsPath;
import beans.OrderCalculate;
import beans.Transport;
import exception.PathNotFoundException;
import form.request.CalculateForm;
import form.response.CalculateReq;

public interface OrderService {
	public CalculateReq prepareOrder(CalculateForm form) throws PathNotFoundException;
	public CharacteristicsPath pathCalculate(CalculateForm form,  List<Transport> transports) throws PathNotFoundException;
}
