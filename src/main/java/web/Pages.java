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
     * page for changing status of orders (manager can see)
     */
    public static final String STATUS = "statusOrder";
    
    /**
     * page for reports(get requsts only) (manager can see)
     */
    public static final String REPORT = "reports";

    /**
     * page for all manipulations with branch (admin can see)
     */
    public static final String BRANCH = "changingBranch";
    
    /**
     * page for all manipulations with branch (admin can see)
     */
    public static final String BOX = "changingBox";
    
    /**
     * page for changing branch (admin can see)
     */
    public static final String TRANSFORM_BRANCH = "transformBranch";
    
    
    /**
     * page for changing rate (admin can see)
     */
    public static final String CHANGING_RATES = "changingAgreement";
    
    /**
     * page for changing transport (admin can see)
     */
    public static final String TRANSFORM_TRANSPORT = "transformTransport";
    
    //=============== Page's attributes ====================================================================
    /** Customer instance */
    public static final String ATR_CUSTOMER = "customer";
    /** Message to show at the target page  */
    public static final String ATR_MESSAGE = "message";
    
    public static final String ATR_COST_CALC_RESULT = "costCalcRes";
    
    public static final String ATR_ORDER_READY = "orderReq";
    
    
}
