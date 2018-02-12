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

    public void setId(int id) { this.id = id; }
    public void setCostKm(double costKm) { this.costKm = costKm; }
    public void setTotalCapacity(double totalCapacity) { this.totalCapacity = totalCapacity; }
    public void setTotalWeight(double totalWeight) { this.totalWeight = totalWeight; }
    public void setMaxHeight(double maxHeight) { this.maxHeight = maxHeight; }
    public void setMaxLength(double maxLength) { this.maxLength = maxLength; }
    public void setMaxWidth(double maxWidth) { this.maxWidth = maxWidth; }
    public void setVariety(String variety) { this.variety = variety; }
    public void setAvSpeed(double avSpeed) { this.avSpeed = avSpeed; }

    public int getId() { return id; }
    public String getVariety() { return variety; }
    public double getAvSpeed() { return avSpeed; }
    public double getCostKm() { return costKm; }
    public double getMaxHeight() { return maxHeight; }
    public double getMaxLength() { return maxLength; }
    public double getMaxWidth() { return maxWidth; }
    public double getTotalCapacity() { return totalCapacity; }
    public double getTotalWeight() { return totalWeight; }
}
