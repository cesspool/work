package beans;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

public class Rate {
    private Integer id;
    private String name;
    private Double costShipping;
    private Double additionalCost;
    private Date startAction;
    private Date endAction;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Double getCostShipping(){
        return costShipping;
    }

    public void setCostShipping (Double costShipping) {
        this.costShipping = costShipping;
    }

    public Double getAdditionalCost() {
        return additionalCost;
    }

    public void setAdditionalCost(Double additionalCost) {
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
