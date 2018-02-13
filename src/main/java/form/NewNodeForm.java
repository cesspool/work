package form;

import java.util.List;

public class NewNodeForm {
    boolean airport;
    boolean railway;
    private String name;
    private String address;
    private double coordinateX;
    private double coordinateY;
    private List<String> linkNodes;

    public List<String> getNodes() {
        return linkNodes;
    }

    public void setNodes(List<String> linkNodes) {
        this.linkNodes = linkNodes;
    }

    public boolean isAirport() {
        return airport;
    }

    public void setAirport(boolean airport) {
        this.airport = airport;
    }

    public boolean isRailway() {
        return railway;
    }

    public void setRailway(boolean railway) {
        this.railway = railway;
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

}
