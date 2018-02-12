package beans;

import javax.xml.crypto.Data;

public class Rate {
    private int id;
    private String name;
    private double costShipping;
    private Data startAction;
    private Data endAction;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getCostShipping(){
        return costShipping;
    }

    public void setCostShipping (double costShipping) {
        this.costShipping = costShipping;
    }

    public Data getEndAction() {
        return endAction;
    }

    public void setEndAction(Data endAction){
        this.endAction = endAction;
    }

    public Data getStartAction() {
        return startAction;
    }

    public void setStartAction(Data startAction){
        this.startAction = startAction;
    }

}
