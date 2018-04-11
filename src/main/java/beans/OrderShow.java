package beans;

public class OrderShow {
	private Order order;
	private Package cargo;
	private Boxing box;
	private Node nodeStart;
	private Node nodeEnd;
	
	
	public OrderShow() {
		order = new Order();
		cargo = new Package();
		box = new Boxing();
		nodeStart = new Node();
		nodeEnd = new Node();
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
	public Node getNodeStart() {
		return nodeStart;
	}
	public void setNodeStart(Node nodeStart) {
		this.nodeStart = nodeStart;
	}
	public Node getNodeEnd() {
		return nodeEnd;
	}
	public void setNodeEnd(Node nodeEnd) {
		this.nodeEnd = nodeEnd;
	}
	
	
	
}
