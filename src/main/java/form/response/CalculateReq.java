package form.response;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CalculateReq {
    private String FullPath;
    private double totalCost;
    private Date dateCurrent;
    private String dateDelivery;
    private long quatityHours;
    private String typeDelivery;
    private List<Long> pathId;
    
    

    public List<Long> getPathId() {
		return pathId;
	}

	public void setPathId(List<Long> pathId) {
		this.pathId = pathId;
	}

	public String getFullPath() {
		return FullPath;
	}

	public void setFullPath(String fullPath) {
		FullPath = fullPath;
	}

	public long getQuatityHours() {
		return quatityHours;
	}

	public void setQuatityHours(long quatityHours) {
		this.quatityHours = quatityHours;
	}

	public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getDateCurrent() {  //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Date
    	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    	dateCurrent = new Date();
        return dateFormat.format(dateCurrent);
    }

    public void setDateCurrent(Date dateCurrent) {
        this.dateCurrent = dateCurrent;
    }

    public String getDateDelivery() { //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Date
    	return dateDelivery;
    }

    public void setDateDelivery(String dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public String getTypeDelivery() {
        return typeDelivery;
    }

    public void setTypeDelivery(String typeDelivery) {
        this.typeDelivery = typeDelivery;
    }
}
