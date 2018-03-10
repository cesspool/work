package service;

import beans.Customer;
import web.Message;

import java.util.Optional;

public interface CustomerService {

    void createCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void setPassword(Customer customer, String pass);
    
    Optional<Customer> getByEmail(String email);
    
    Optional<Customer> getByID(Long ID);
    
    Customer authenticate(String email, String pass, Message msg);
}
