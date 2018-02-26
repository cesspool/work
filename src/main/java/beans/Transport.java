package beans;

import javax.persistence.criteria.CriteriaBuilder;

public class Transport {
    private Integer id;
    private String variety;
    private Double avSpeed;
    private Double maxHeight;
    private Double maxWidth;
    private Double maxLength;
    private Double totalWeight;
    private Double totalCapacity;
    private Double costKm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCostKm() {
        return costKm;
    }

    public void setCostKm(Double costKm) {
        this.costKm = costKm;
    }

    public Double getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Double totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Double getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Double maxLength) {
        this.maxLength = maxLength;
    }

    public Double getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(Double maxWidth) {
        this.maxWidth = maxWidth;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public Double getAvSpeed() {
        return avSpeed;
    }

    public void setAvSpeed(Double avSpeed) {
        this.avSpeed = avSpeed;
    }
}
