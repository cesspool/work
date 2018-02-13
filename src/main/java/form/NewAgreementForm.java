package form;

import java.util.Date;
import java.util.List;

//// !!!!!!!!!! DATA TYPE @DATE@ MAY BE WRONG!!!!!!!!!!!!!!!!!!!!!
public class NewAgreementForm {
    private String name;
    private double costShipping;
    private Date startAction;
    private Date endAction;
    private double maxHeight;
    private double maxWidth;
    private double maxLength;
    private double totalWeight;
    private double totalCapacity;
    private List<Double> costKm;
    private List<Double> avSpeed;

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

    public double getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(double totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public double getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(double maxLength) {
        this.maxLength = maxLength;
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(double maxWidth) {
        this.maxWidth = maxWidth;
    }

    public List<Double> getAvSpeed() {
        return avSpeed;
    }

    public void setAvSpeed(List<Double> avSpeed) {
        this.avSpeed = avSpeed;
    }

    public List<Double> getCostKm() {
        return costKm;
    }

    public void setCostKm(List<Double> costKm) {
        this.costKm = costKm;
    }
}
