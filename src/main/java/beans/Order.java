package beans;

public class Order {
    private Long id;
    private int name;
    private Boolean urgency;
    private Boolean ready;
    private Long nodeStart;
    private Long nodeTarget;
    

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

    public int getName(){
        return name;
    }

    public void setName(int name){
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
