package beans;

public class Node {
    private Long id;
    private String name;
    private String address;
    private String city;
    private double coordinateX;
    private double coordinateY;
    private String code;
    private String airport;
    private String rail;
    
    

    public String getAirport() {
		return airport;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}

	public String getRail() {
		return rail;
	}

	public void setRail(String rail) {
		this.rail = rail;
	}

	public Long getId(){
        return id;
    }

    public void setId(Long id){
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
