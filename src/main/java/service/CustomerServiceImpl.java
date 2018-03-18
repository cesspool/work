package service;

import beans.Customer;
import dbservice.CustomerDAOService;
import form.request.RegistrationForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.Tools;
import web.Message;
import web.Message.Type;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private CustomerDAOService customerDAOService;


    @Override
    public void createCustomer(Customer customer) {
        if (customer != null) {
            // validate the bean's fileds
            String md5 = Tools.stringToMD5(customer.getMd5());
            customer.setMd5(md5);
            customerDAOService.insertCustomer(customer);
        }
    }

    @Override
    public Customer createCustomer(RegistrationForm regForm) {
        Customer cmr = Tools.registrationFormToCustomer(regForm);
        createCustomer(cmr);
        return cmr;
    }


    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void setPassword(Customer customer, String pass) {
        if ((pass == null) || (pass.length() == 0)) {
            return;
        }
        String md5 = Tools.stringToMD5(pass);
        customerDAOService.updatePassword(customer, md5);
        customer.setMd5(md5);
    }

    @Autowired
    private void setCustomerDAOService(CustomerDAOService customerDAOService) {
        this.customerDAOService = customerDAOService;
    }

    @Override
    public Optional<Customer> getByEmail(String email) {
        return customerDAOService.getByEmail(email);
    }

    @Override
    public Optional<Customer> getByID(Long ID) {
        return customerDAOService.getByID(ID);
    }

    @Override
    public Customer authenticate(String email, String pass, Message msg) {

        String passMD5 = Tools.stringToMD5(pass);
        Customer cmr = getByEmail(email).orElse(null);
        if (cmr == null) {
            msg.setType(Type.ERROR);
            msg.setKey("login.user_not_found");
            return null;
        }
        if (!passMD5.equals(cmr.getMd5())) {
            msg.setType(Type.ERROR);
            msg.setKey("login.wrong_pass");
            return null;
        }
        return cmr;
    }


}
