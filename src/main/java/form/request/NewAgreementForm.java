package form.request;

import java.util.Date;
import java.util.List;

//// !!!!!!!!!! DATA TYPE @DATE@ MAY BE WRONG!!!!!!!!!!!!!!!!!!!!!
public class NewAgreementForm {
    private String name;
    private double costShippingRail;
    private double costShippingAir;
    private double costShippingCargo;
    private double addCostShippingRail;
    private double addCostShippingAir;
    private double addCostShippingCargo;
    private Date startAction;
    private Date endAction;
    private double maxHeight;
    private double maxWidth;
    private double maxLength;
    private double totalWeight;
    private double totalCapacity;
    private double costKmCargo;
    private double costKmAir;
    private double costKmRail;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getCostShipping(){
        return costShippingAir;
    }

    public void setCostShipping (double costShippingAir) {
        this.costShippingAir = costShippingAir;
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

	public double getCostShippingCargo() {
		return costShippingCargo;
	}

	public void setCostShippingCargo(double costShippingCargo) {
		this.costShippingCargo = costShippingCargo;
	}

	public double getCostShippingRail() {
		return costShippingRail;
	}

	public void setCostShippingRail(double costShippingRail) {
		this.costShippingRail = costShippingRail;
	}

	public double getAddCostShippingRail() {
		return addCostShippingRail;
	}

	public void setAddCostShippingRail(double addCostShippingRail) {
		this.addCostShippingRail = addCostShippingRail;
	}

	public double getAddCostShippingAir() {
		return addCostShippingAir;
	}

	public void setAddCostShippingAir(double addCostShippingAir) {
		this.addCostShippingAir = addCostShippingAir;
	}

	public double getAddCostShippingCargo() {
		return addCostShippingCargo;
	}

	public void setAddCostShippingCargo(double addCostShippingCargo) {
		this.addCostShippingCargo = addCostShippingCargo;
	}

	public double getCostKmCargo() {
		return costKmCargo;
	}

	public void setCostKmCargo(double costKmCargo) {
		this.costKmCargo = costKmCargo;
	}

	public double getCostKmAir() {
		return costKmAir;
	}

	public void setCostKmAir(double costKmAir) {
		this.costKmAir = costKmAir;
	}

	public double getCostKmRail() {
		return costKmRail;
	}

	public void setCostKmRail(double costKmRail) {
		this.costKmRail = costKmRail;
	}
}
