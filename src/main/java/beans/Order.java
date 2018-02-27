package beans;

public class Order {
    private int id;
    private int name;
    private Boolean urgency;
    private Boolean ready;

    public int getId(){
        return id;
    }

    public void setId(int id){
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
