package beans;

import javax.persistence.criteria.CriteriaBuilder;

public class Package {
    private Long id;
    private String name;
    private Double weight;
    private int quantity;
    private Double width;
    private Double length;
    private Double height;
    private Boolean envelope;
    private Double size;

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Boolean isEnvelope() {
        return envelope;
    }

    public void isEnvelope(Boolean envelope) {
        this.envelope = envelope;
    }

}
