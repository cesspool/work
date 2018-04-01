package beans;

public class OrderPackage {
	private Order order;
	private Package cargo;
	private Boxing boxing;
	private Node nodeStart;
	private Node nodeTarget;
	private String contactInfo;
	
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
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
	public Boxing getBoxing() {
		return boxing;
	}
	public void setBoxing(Boxing boxing) {
		this.boxing = boxing;
	}
	public Node getNodeStart() {
		return nodeStart;
	}
	public void setNodeStart(Node nodeStart) {
		this.nodeStart = nodeStart;
	}
	public Node getNodeTarget() {
		return nodeTarget;
	}
	public void setNodeTarget(Node nodeTarget) {
		this.nodeTarget = nodeTarget;
	}

}
