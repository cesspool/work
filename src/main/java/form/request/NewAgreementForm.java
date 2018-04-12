package form.request;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

//// !!!!!!!!!! DATA TYPE @DATE@ MAY BE WRONG!!!!!!!!!!!!!!!!!!!!!
public class NewAgreementForm {
    private String name;
    private double costShippingRail;
    private double costShippingAir;
    private double costShippingCargo;
    private double addCostShippingRail;
    private double addCostShippingAir;
    private double addCostShippingCargo;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startAction;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endAction;
    private double totalCapacity;
    private double costKmCargo;
    private double costKmAir;
	private double costKmRail;
    private long railID;
    private long airID;
    private long cargoID;
    private long trRailID;
    private long trAirID;
    private long trCargoID;

    

	public long getTrRailID() {
		return trRailID;
	}

	public void setTrRailID(long trRailID) {
		this.trRailID = trRailID;
	}

	public long getTrAirID() {
		return trAirID;
	}

	public void setTrAirID(long trAirID) {
		this.trAirID = trAirID;
	}

	public long getTrCargoID() {
		return trCargoID;
	}

	public void setTrCargoID(long trCargoID) {
		this.trCargoID = trCargoID;
	}

	public long getRailID() {
		return railID;
	}

	public void setRailID(long railID) {
		this.railID = railID;
	}

	public long getAirID() {
		return airID;
	}

	public void setAirID(long airID) {
		this.airID = airID;
	}

	public long getCargoID() {
		return cargoID;
	}

	public void setCargoID(long cargoID) {
		this.cargoID = cargoID;
	}

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getCostShippingAir(){
        return costShippingAir;
    }

    public void setCostShippingAir (double costShippingAir) {
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
