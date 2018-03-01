package beans;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;

public class Rate {
    private Long id;
    private String name;
    private double costShipping;
    private double additionalCost;
    private Date startAction;
    private Date endAction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public double getAdditionalCost() {
        return additionalCost;
    }

    public void setAdditionalCost(double additionalCost) {
        this.additionalCost = additionalCost;
    }

    public Date getEndAction() {
        return endAction;
    }

    public void setEndAction(Date endAction){
        this.endAction = endAction;
    }

    public Date getStartAction() {
        return startAction;
    }

    public void setStartAction(Date startAction){
        this.startAction = startAction;
    }

}
