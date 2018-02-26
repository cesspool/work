package service;

import beans.Customer;
import dbservice.CustomerDAOService;
import dbservice.CustomerDAOServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private CustomerDAOService customerDAOService;

    @Override
    public void createCustomer(Customer customer) {
        if (customer != null) {
            // validate the bean's fileds
            customerDAOService.insertCustomer(customer);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void setPassword(Customer customer, String pass) {
        if ((pass == null)||(pass.length() == 0)){
            return;
        }
        String md5 = str2MD5(pass);
        customerDAOService.updatePassword(customer, md5);
        customer.setMd5(md5);
    }

    @Autowired
    private void setCustomerDAOService(CustomerDAOService customerDAOService) {
        this.customerDAOService = customerDAOService;
    }

    
    private String str2MD5(String str){
        try {
            MessageDigest msgDigst = MessageDigest.getInstance("MD5");
            byte[] md5 = msgDigst.digest(str.getBytes("UTF-8"));
            return new String(md5);
        } catch (NoSuchAlgorithmException algEx) {
            logger.error("Set password failed", algEx);
            throw new RuntimeException("Set password failed", algEx);
        } catch (UnsupportedEncodingException encEx) {
            logger.error("Set password failed", encEx);
            throw new RuntimeException("Set password failed", encEx);
        }
        
    }
}
