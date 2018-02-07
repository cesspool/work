package beans;

public class Node {
    private int id;
    private String name;
    private String address;
    private double timeLoad;
    private double costLoad;
    private double coordinateX;
    private double coordinateY;
    private boolean latitude;
    private boolean longitude;

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public double getTimeLoad(){
        return timeLoad;
    }
    public double getCostLoad(){
        return costLoad;
    }
    public double getCoordinateX(){
        return coordinateX;
    }
    public double getCoordinateY(){
        return coordinateY;
    }
    public boolean isLatitude(){
        return latitude;
    }
    public boolean isLongitude(){
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
    public void setTimeLoad(double timeLoad){
        this.timeLoad = timeLoad;
    }
    public void setCostLoad(double costLoad){
        this.costLoad = costLoad;
    }
    public void setCoordinateX(double coordinateX){
        this.coordinateX = coordinateX;
    }
    public void setCoordinateY(double coordinateY){
        this.coordinateY = coordinateY;
    }
    public void setLatitude(boolean latitude){
        this.latitude = latitude;
    }
    public void setLongitude(boolean longitude){
        this.longitude = longitude;
    }
}
