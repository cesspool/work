package form.request;

public class RegistrationForm {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String telephone;
    private String email;
    private String city;
    private String psw;
    private String pswRepeat;
    private int privilege;
    private Long id;
    private String perk;
    
    


	public String getPerk() {
		return perk;
	}

	public void setPerk(String perk) {
		this.perk = perk;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getPswRepeat() {
        return pswRepeat;
    }

    public void setPswRepeat(String pswRepeat) {
        this.pswRepeat = pswRepeat;
    }

	public int getPrivilege() {
		return privilege;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}


    
    
}
