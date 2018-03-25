package web;

public class Pages {
    /**
     * Application main page (all can see)
     */
    public static final String MAIN = "index";

    /**
     * page shows current and next rate(tariff) (all can see)
     */
    public static final String RATE = "rate";

    /**
     * main page for admin for adding new node (admin can see)
     */
    public static final String ADMIN = "adminMain";

    /**
     * page shows information about the customer(from customer's personal area)
     */
    public static final String CONTACT = "contact";

    /**
     * page shows completed orders(from customer's personal area)
     */
    public static final String HISTORY = "history";

    /**
     * authorization page
     */
    public static final String LOGIN = "login";

    /**
     * page for adding new boxing (admin can see)
     */
    public static final String BOXING = "newBoxing";

    /**
     * page for adding new rate(tariff) (admin can see)
     */
    public static final String NEWRATE = "newRate";

    /**
     * main page for customer's personal area that shows orders in progress
     */
    public static final String PERSON = "personal";

    /**
     * page for calculating new order (customer can see)
     */
    public static final String COST = "personCost";

    /**
     * page that shows result of transportation's calculating (customer can see)
     */
    public static final String RESULT = "resultCost";

    /**
     * page for sending new order(customer can see)
     */
    public static final String ORDER = "personOrder";

    /**
     * registration page
     */
    public static final String REGISTRATION = "registration";

    /**
     * page for changing status of orders (manager and admin can see)
     */
    public static final String STATUS = "statusOrder";

    
    //=============== Page's attributes ====================================================================
    /** Customer instance */
    public static final String ATR_CUSTOMER = "customer";
    /** Message to show at the target page  */
    public static final String ATR_MESSAGE = "message";
    
    
    
}
