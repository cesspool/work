package dbservice;

import beans.Customer;

import java.util.Optional;

public interface CustomerDAOService {
    
    Optional<Customer> getByID(Long ID);
    
    Customer getByEmail(String email);
    
    void insertCustomer(Customer customer);
    
    void updateCustomer(Customer customer);
    
    void deleteCustomer(Customer customer);
    
    void updatePassword(Customer customer, String password);
}
