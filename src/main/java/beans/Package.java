package beans;

public class Package {
    private int id;
    private String name;
    private double weight;
    private int quantity;
    private double width;
    private double length;
    private double height;
    private boolean envelope;
    private double size;

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public boolean isEnvelope() {
        return envelope;
    }

    public void isEnvelope(boolean envelope) {
        this.envelope = envelope;
    }

}
