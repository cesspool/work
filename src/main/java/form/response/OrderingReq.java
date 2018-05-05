package form.response;

import beans.Boxing;
import beans.Customer;
import beans.Node;
import beans.Order;
import beans.Package;

public class OrderingReq {
    private Order order;
    private Package cargo;
    private Boxing box;
    private Node NodeStart;
    private Node NodeEnd;
    private String typeDelivery;
    private String typeCargo;
    private Customer sender; //!!!!!!!
    
    
    
	public Customer getSender() {
		return sender;
	}
	public void setSender(Customer sender) {
		this.sender = sender;
	}
	public Node getNodeStart() {
		return NodeStart;
	}
	public void setNodeStart(Node nodeStart) {
		NodeStart = nodeStart;
	}
	public Node getNodeEnd() {
		return NodeEnd;
	}
	public void setNodeEnd(Node nodeEnd) {
		NodeEnd = nodeEnd;
	}
	public String getTypeDelivery() {
		return typeDelivery;
	}
	public void setTypeDelivery(String typeDelivery) {
		this.typeDelivery = typeDelivery;
	}
	public String getTypeCargo() {
		return typeCargo;
	}
	public void setTypeCargo(String typeCargo) {
		this.typeCargo = typeCargo;
	}
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
    
}
