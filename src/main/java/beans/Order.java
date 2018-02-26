package beans;

public class Order {
    private Integer id;
    private Integer name;
    private Boolean urgency;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getName(){
        return name;
    }

    public void setName(Integer name){
        this.name = name;
    }

    public Boolean isUrgency(){
        return urgency;
    }

    public void isUrgency(Boolean urgency){
        this.urgency = urgency;
    }
}
