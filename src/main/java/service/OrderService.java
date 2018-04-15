package service;

import java.util.List;
import java.util.Optional;

import beans.CharacteristicsPath;
import beans.Order;
import beans.OrderShow;
import beans.OrderWriter;
import beans.Transport;
import exception.LogisticsException;
import form.request.CalculateForm;
import form.request.OrderingForm;
import form.response.CalculateReq;

public interface OrderService {
	public void updateById (List<String> IDs);
	public Optional<List<OrderShow>> getOrderByRecipientName(String recipient);
	public List<Order> getUrgencyOrder(boolean urg);
	public List<Order> getOrderReadyEqualPlan(Integer days);
	public List<Order> getOrderReadyMorePlan(Integer days);
	public List<Order> getOrderReadyLessPlan(Integer days);
	public CalculateReq prepareOrder(CalculateForm form) throws LogisticsException;
	public void createOrder(OrderWriter orderWriter, OrderingForm formData);
	public Optional<List<OrderShow>> getOrderByParam(Long ID, boolean ready);
	public CharacteristicsPath pathCalculate(CalculateForm form,  List<Transport> transports) throws LogisticsException;
}
