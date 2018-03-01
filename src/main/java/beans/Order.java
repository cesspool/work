package beans;

public class Order {
    private Long id;
    private int name;
    private Boolean urgency;
    private Boolean ready;

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
