package beans;

public class Order {
    private int id;
    private int name;
    private boolean urgency;

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

    public boolean isUrgency(){
        return urgency;
    }

    public void isUrgency(boolean urgency){
        this.urgency = urgency;
    }

}
