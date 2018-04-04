package service;

import beans.CharacteristicsPath;
import beans.OrderCalculate;
import form.request.CalculateForm;

public interface OrderService {
	public OrderCalculate prepareOrder(CalculateForm form);
	public CharacteristicsPath pathCalculate(CalculateForm form);
	public void conversionData(CharacteristicsPath charPath);
}
