package beans;

public class CoordinatesPrep {
	private Node nodeStart;
	private Node nodeEnd;
	
	public CoordinatesPrep() {}
	
	public CoordinatesPrep(Node start, Node end) {
		this.nodeStart = start;
		this.nodeEnd = end;
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
