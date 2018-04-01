package form.request;

import java.util.List;
import java.util.Map;

public class NewNodeForm {
    boolean airport;
    boolean railway;
    private String name;
    private String address;
    private String city;
    private double coordinateX;
    private double coordinateY;
    private String selectedCities;
	//List<String> chosenCities;
	
	
	
//    public String getAirport() {
//		return airport;
//	}
//
//	public void setAirport(String airport) {
//		this.airport = airport;
//	}
//
//	public String getRailway() {
//		return railway;
//	}
//
//	public void setRailway(String railway) {
//		this.railway = railway;
//	}

//	public List<String> getChosenCities() {
//		return chosenCities;
//	}

	public String getSelectedCities() {
		return selectedCities;
	}

	public void setSelectedCities(String selectedCities) {
		this.selectedCities = selectedCities;
	}

//	public void setChosenCities(List<String> chosenCities) {
//		this.chosenCities = chosenCities;
//	}
   

	public void setCity(String city) {
    	this.city=city;
    }
    
    public String getCity() {
    	return city;
    }

//    public List<String> getNodes() {
//        return linkNodes;
//    }
//
//    public void setNodes(List<String> linkNodes) {
//        this.linkNodes = linkNodes;
//    }

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
