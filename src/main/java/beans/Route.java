package beans;

public class Route {
    private int numberNode;
    private Long orderId;
    private Long nodeId;
    

    public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public int getNumberNode() {
        return numberNode;
    }

    public void setNumberNode(int numberNode) {
        this.numberNode = numberNode;
    }
}
