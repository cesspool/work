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

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getWeight() { return weight; }
    public int getQuantity(){ return quantity; }
    public double getHeight() { return height; }
    public double getLength() { return length; }
    public double getWidth() { return width; }
    public boolean isEnvelope() { return envelope; }

    public void setEnvelope(boolean envelope) { this.envelope = envelope; }
    public void setHeight(double height) { this.height = height; }
    public void setLength(double length) { this.length = length; }
    public void setWidth(double width) { this.width = width; }
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
