package dbservice;

import beans.Customer;

public interface CustomerDAOService {
    
    Customer getByID(Long ID);
    
    Customer getByEmail(String email);
    
    void insertCustomer(Customer customer);
    
    void updateCustomer(Customer customer);
    
    void deleteCustomer(Customer customer);
}
