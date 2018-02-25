package beans;

public class Node {
    private int id;
    private String name;
    private String address;
    private double coordinateX;
    private double coordinateY;
    private String code;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public double getCoordinateX(){
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX){
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY(){
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY){
        this.coordinateY = coordinateY;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
