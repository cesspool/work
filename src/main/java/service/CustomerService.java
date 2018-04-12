package service;

import beans.Customer;
import form.request.RegistrationForm;
import web.Message;

import java.util.Optional;

public interface CustomerService {

    void createCustomer(Customer customer);
    
    Customer createCustomer(RegistrationForm regForm);

    //void updateCustomer(Customer customer);

    void setPassword(Customer customer, String pass);
    
    Optional<Customer> getByEmail(String email);
    
    Optional<Customer> getByID(Long ID);
    
    Customer authenticate(String email, String pass, Message msg);
    
    Customer updateCustomer(RegistrationForm regForm);
}
