package form.response;

import beans.Boxing;
import beans.Order;

public class OrderingReq {
    private Order order;
    private Package cargo;
    private Boxing box;
    private String NodeStart;
    private String NodeEnd;
    
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Package getCargo() {
		return cargo;
	}
	public void setCargo(Package cargo) {
		this.cargo = cargo;
	}
	public Boxing getBox() {
		return box;
	}
	public void setBox(Boxing box) {
		this.box = box;
	}
	public String getNodeStart() {
		return NodeStart;
	}
	public void setNodeStart(String nodeStart) {
		NodeStart = nodeStart;
	}
	public String getNodeEnd() {
		return NodeEnd;
	}
	public void setNodeEnd(String nodeEnd) {
		NodeEnd = nodeEnd;
	}
    
    
}
