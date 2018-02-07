package beans;

public class Package {
    private int id;
    private String name;
    private String size;
    private String weight;
    private double sum;

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSize(){
        return size;
    }
    public String getWeight() {
        return weight;
    }
    public double getSum(){
        return sum;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSize(String size){
        this.size = size;
    }
    public void setWeight(String weight){
        this.weight = weight;
    }
    public void setSum(double sum){
        this.sum = sum;
    }
}
