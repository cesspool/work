package dbservice;

import java.util.List;

import beans.Order;
import beans.Package;
import beans.Route;

public interface OrderDAOService {
	//void inserOrder(Order order);
	public void insertNewOrder(Order order, Package cargo, List<Route> routes);
}
