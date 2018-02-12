package beans;

public class TypeTransport {
    private int id;
    private String variety;
    private double avSpeed;
    private double maxHeight;
    private double maxWidth;
    private double maxLength;
    private double totalWeight;
    private double totalCapacity;
    private double costKm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCostKm() {
        return costKm;
    }

    public void setCostKm(double costKm) {
        this.costKm = costKm;
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

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public double getAvSpeed() {
        return avSpeed;
    }

    public void setAvSpeed(double avSpeed) {
        this.avSpeed = avSpeed;
    }

}
