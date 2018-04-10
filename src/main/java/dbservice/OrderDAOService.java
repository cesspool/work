package dbservice;

import java.util.List;
import java.util.Optional;

import beans.CharacteristicsPath;
import beans.Order;
import beans.OrderShow;
import beans.Package;
import beans.Route;

public interface OrderDAOService {
	//void inserOrder(Order order);
	public void insertNewOrder(Order order, Package cargo, CharacteristicsPath charPath);
	public Optional<List<OrderShow>> getOrders(Long ID, boolean ready);
}
