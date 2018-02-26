package service;

import beans.Customer;

public interface CustomerService {

    void createCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void setPassword(Customer customer, String pass);
}
