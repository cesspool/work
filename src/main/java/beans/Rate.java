package beans;

import javax.xml.crypto.Data;

public class Rate {
    private int id;
    private String name;
    private boolean urgency;
    private double costShipping;
    private Data startAction;
    private Data endAction;

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public boolean isUrgency(){
        return urgency;
    }
    public double getCostShipping(){
        return costShipping;
    }
    public Data getEndAction() {
        return endAction;
    }
    public Data getStartAction() {
        return startAction;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void isUrgency(boolean urgency){
        this.urgency = urgency;
    }
    public void setCostShipping (double costShipping)
    {
        this.costShipping = costShipping;
    }
    public void setStartAction(Data startAction){
        this.startAction = startAction;
    }
    public void setEndAction(Data endAction){
        this.endAction = endAction;
    }
}
