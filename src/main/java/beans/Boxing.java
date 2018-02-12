package beans;

public class Boxing {
    private int id;
    private String variety;
    private double cost;

    public String getVariety() { return variety; }
    public int getId(){
        return id;
    }
    public double getCost(){
        return cost;
    }

    public void setVariety(String variety) { this.variety = variety; }
    public void setId(int id){
        this.id = id;
    }
    public void setCost(double cost){
        this.cost = cost;
    }
}
