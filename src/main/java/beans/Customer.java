package beans;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String address;
    private String telephone;

    public int getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getPatronymic(){
        return patronymic;
    }
    public String getAddress(){
        return address;
    }
    public String getTelephone(){
        return telephone;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setFirstName(String firstname){
        this.firstName = firstname;
    }
    public void setLastName(String lastname){
        this.lastName = lastname;
    }
    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

}
