package beans;

public class Node {
    private int id;
    private String name;
    private String address;
    private double coordinateX;
    private double coordinateY;
    private char latitude;
    private char longitude;

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public double getCoordinateX(){
        return coordinateX;
    }
    public double getCoordinateY(){
        return coordinateY;
    }
    public char getLatitude(){
        return latitude;
    }
    public char getLongitude(){
        return longitude;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setCoordinateX(double coordinateX){
        this.coordinateX = coordinateX;
    }
    public void setCoordinateY(double coordinateY){
        this.coordinateY = coordinateY;
    }
    public void setLatitude(char latitude){
        this.latitude = latitude;
    }
    public void setLongitude(char longitude){
        this.longitude = longitude;
    }
}
