package form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.Pages;
import web.Principal;

import javax.servlet.http.HttpSession;

@Component
public class BaseController {
    private HttpSession session;
    
    public Principal getPrincipal() {
        return (Principal)session.getAttribute(Pages.ATR_PRINCIPAL);
    }

    public boolean hasPrincipal() {
        return getPrincipal() != null;
    }
    
    public boolean isForAdmin() {
        return true;
    }
    
    public boolean isForManager() {
        return false;
    }
    
    public boolean isForCustomer() {
        return false;
    }
    
    public boolean isForFree() {
        return false;
    }
    
    
    @Autowired
    private void setHttpSession(HttpSession session) {
        this.session = session;
    }
    
}
