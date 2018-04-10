package service;

import java.util.List;
import java.util.Optional;

import beans.CharacteristicsPath;
import beans.OrderCalculate;
import beans.OrderShow;
import beans.OrderWriter;
import beans.Transport;
import exception.PathNotFoundException;
import form.request.CalculateForm;
import form.request.OrderingForm;
import form.response.CalculateReq;

public interface OrderService {
	public CalculateReq prepareOrder(CalculateForm form) throws PathNotFoundException;
	public void createOrder(OrderWriter orderWriter, OrderingForm formData);
	public Optional<List<OrderShow>> getOrderByParam(Long ID, boolean ready);
	public CharacteristicsPath pathCalculate(CalculateForm form,  List<Transport> transports) throws PathNotFoundException;
}
