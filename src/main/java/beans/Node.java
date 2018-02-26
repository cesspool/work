package beans;

public class Node {
    private Integer id;
    private String name;
    private String address;
    private Double coordinateX;
    private Double coordinateY;
    private String code;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
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

    public Double getCoordinateX(){
        return coordinateX;
    }

    public void setCoordinateX(Double coordinateX){
        this.coordinateX = coordinateX;
    }

    public Double getCoordinateY(){
        return coordinateY;
    }

    public void setCoordinateY(Double coordinateY){
        this.coordinateY = coordinateY;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
