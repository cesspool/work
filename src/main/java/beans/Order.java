package beans;

import java.util.Date;

public class Order {
    private Long id;
    private String name;
    private Boolean urgency;
    private Boolean ready;
    private Long nodeStart;
    private Long nodeTarget;
    private Date planDate;
    private Date realDate;
    private Date shipmentDate;
    private double cost;
    private String contact_information;
    private Long recipientId;
    private Long rateId;
    private Long packageId;
    private Long boxingId;
    private String fullPath;
    
        

    public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public Date getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public Long getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(Long recipientId) {
		this.recipientId = recipientId;
	}

	public Long getRateId() {
		return rateId;
	}

	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}

	public Long getPackageId() {
		return packageId;
	}

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

	public Long getBoxingId() {
		return boxingId;
	}

	public void setBoxingId(Long boxingId) {
		this.boxingId = boxingId;
	}

	public String getContact_information() {
		return contact_information;
	}

	public void setContact_information(String contact_information) {
		this.contact_information = contact_information;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public Date getRealDate() {
		return realDate;
	}

	public void setRealDate(Date realDate) {
		this.realDate = realDate;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Long getNodeStart() {
		return nodeStart;
	}

	public void setNodeStart(Long nodeStart) {
		this.nodeStart = nodeStart;
	}

	public Long getNodeTarget() {
		return nodeTarget;
	}

	public void setNodeTarget(Long nodeTarget) {
		this.nodeTarget = nodeTarget;
	}

	public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Boolean isUrgency(){
        return urgency;
    }

    public void isUrgency(Boolean urgency){
        this.urgency = urgency;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }
}
