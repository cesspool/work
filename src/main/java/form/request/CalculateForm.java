package form.request;

import java.util.Map;

public class CalculateForm {
    private String cityStart;
    private String cityTarget;
    private boolean urgency;
    private boolean envelope;
    private int quantity;
    private double weight;
    private double width;
    private double length;
    private double height;
    private double size;
    private long boxesList;

    
//    public String getStartNode() {
//        return startNode;
//    }
//
//    public void setStartNode(String startNode) {
//        this.startNode = startNode;
//    }
//
//    public String getTargetNode() {
//        return targetNode;
//    }
//
//    public void setTargetNode(String targetNode) {
//        this.targetNode = targetNode;
//    }

    public String getCityStart() {
		return cityStart;
	}

	public void setCityStart(String cityStart) {
		this.cityStart = cityStart;
	}

	public String getCityTarget() {
		return cityTarget;
	}

	public void setCityTarget(String cityTarget) {
		this.cityTarget = cityTarget;
	}


	public boolean isUrgency() {
        return urgency;
    }

    public void setUrgency(boolean urgency) {
        this.urgency = urgency;
    }

    public boolean isEnvelope() {
        return envelope;
    }

    public void setEnvelope(boolean envelope) {
        this.envelope = envelope;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public long getBoxesList() {
        return boxesList;
    }

    public void setBoxesList(long boxesList) {
        this.boxesList = boxesList;
    }

}
