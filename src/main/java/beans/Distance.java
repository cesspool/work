package beans;

public class Distance {
    private double length;
    private Node nodeStart;
    private Node nodeTarget;
    private Long nodeFrom;
    private Long nodeTo;
    

    public Long getNodeFrom() {
		return nodeFrom;
	}

	public void setNodeFrom(Long nodeFrom) {
		this.nodeFrom = nodeFrom;
	}

	public Long getNodeTo() {
		return nodeTo;
	}

	public void setNodeTo(Long nodeTo) {
		this.nodeTo = nodeTo;
	}

	public double getLength(){
        return length;
    }

    public void setLength(double length){
        this.length = length;
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
