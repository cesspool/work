package web;

import beans.Customer;

public class Principal {
    private final Customer user;
    
    public Principal(Customer user) {
        this.user = user;
    }
    
    public boolean isAdmin() {
        return user.isAdmin() != null ? user.isAdmin() : false;
    }
    
    public boolean isManager() {
        return user.isManager() != null ? user.isManager() : false;
    }
    
}
