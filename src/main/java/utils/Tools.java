package utils;

import beans.Customer;
import form.request.RegistrationForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tools {
    private static final Logger logger = LoggerFactory.getLogger(Tools.class);
    
    public static String stringToMD5(String str){
        try {
            MessageDigest msgDigst = MessageDigest.getInstance("MD5");
            byte[] md5 = msgDigst.digest(str.getBytes("UTF-8"));
            return new String(md5);
        } catch (NoSuchAlgorithmException algEx) {
            logger.error(algEx.getMessage(), algEx);
            throw new RuntimeException(algEx);
        } catch (UnsupportedEncodingException encEx) {
            logger.error(encEx.getMessage(), encEx);
            throw new RuntimeException(encEx);
        }
    }

    
    public static boolean isBlank(String str) {
        if ((str == null) && (str.trim().length() == 0)) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public static Customer registrationFormToCustomer(RegistrationForm form) {
        Customer cmr = new Customer();
        cmr.setFirstName(form.getFirstName());
        cmr.setLastName(form.getLastName());
        cmr.setPatronymic(form.getPatronymic());
        cmr.setAddress(form.getCity());
        cmr.setEmail(form.getEmail());
        cmr.setTelephone(form.getTelephone());
        cmr.setMd5(form.getPsw());
        cmr.setAdmin(form.isAdmin());
        cmr.setManager(form.isManager());
        return cmr;
    }

    
    public static RegistrationForm customerToRegistrationForm(Customer cmr) {
        RegistrationForm form = new RegistrationForm();
        form.setFirstName(cmr.getFirstName());
        form.setLastName(cmr.getLastName());
        form.setPatronymic(cmr.getPatronymic());
        form.setCity(cmr.getAddress());
        form.setEmail(cmr.getEmail());
        form.setTelephone(cmr.getTelephone());
        form.setAdmin(cmr.isAdmin());
        form.setManager(cmr.isManager());
        return form;
    }

}
