package beans;

public class Order {
    private int id;
    private int name;
    private Boolean urgency;

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
}
