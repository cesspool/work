package form.pdf;

import java.util.ArrayList;
import java.util.List;

public class OrderFormBean {

    private String id;
    private String urgency;
    private boolean envelop;
    private String senderFullName;
    private String senderCity;
    private String senderAddress;
    private String senderPhone;
    private String recipientFullName;
    private String recipientCity;
    private String recipientAddress;
    private String recipientPhone;
    private String cargoLength;
    private String cargoHeight;
    private String cargoWidth;
    private String cargoCost;
    private String cargoWeight;
    private String boxingName;
    private String boxingQuantity;
    private DeliveryRoute delRoute = new DeliveryRoute();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public boolean isEnvelop() {
        return envelop;
    }

    public void setEnvelop(boolean envelop) {
        this.envelop = envelop;
    }

    public String getSenderFullName() {
        return senderFullName;
    }

    public void setSenderFullName(String senderFullName) {
        this.senderFullName = senderFullName;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getRecipientFullName() {
        return recipientFullName;
    }

    public void setRecipientFullName(String recipientFullName) {
        this.recipientFullName = recipientFullName;
    }

    public String getRecipientCity() {
        return recipientCity;
    }

    public void setRecipientCity(String recipientCity) {
        this.recipientCity = recipientCity;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getCargoLength() {
        return cargoLength;
    }

    public void setCargoLength(String cargoLength) {
        this.cargoLength = cargoLength;
    }

    public String getCargoHeight() {
        return cargoHeight;
    }

    public void setCargoHeight(String cargoHeight) {
        this.cargoHeight = cargoHeight;
    }

    public String getCargoWidth() {
        return cargoWidth;
    }

    public void setCargoWidth(String cargoWidth) {
        this.cargoWidth = cargoWidth;
    }

    public String getCargoCost() {
        return cargoCost;
    }

    public void setCargoCost(String cargoCost) {
        this.cargoCost = cargoCost;
    }

    public String getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(String cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getBoxingName() {
        return boxingName;
    }

    public void setBoxingName(String boxingName) {
        this.boxingName = boxingName;
    }

    public String getBoxingQuantity() {
        return boxingQuantity;
    }

    public void setBoxingQuantity(String boxingQuantity) {
        this.boxingQuantity = boxingQuantity;
    }

    public void appendRoutePart(String city, String transport) {
        delRoute.addRoutePart(city, transport);
    }
    
    public List<RoutePart> getRouteParts() {
        return delRoute.getRouteParts();
    }
    
    
    
    
    public class DeliveryRoute {
        private List<RoutePart> route = new ArrayList<>();
        
        public void addRoutePart(String city, String transport) {
            if (route.size() > 0) {
                route.get(route.size() - 1).setFinishCity(city);
            }
            RoutePart rtPart = new RoutePart();
            rtPart.setStartCity(city);
            rtPart.setFinishCity(OrderFormBean.this.getRecipientCity());
            rtPart.setTransport(transport);
            route.add(rtPart);
        }
        
        
        public List<RoutePart> getRouteParts() {
            return route;
        }
    }
    
    
    public static class RoutePart {
        private String startCity;
        private String finishCity;
        private String transport;

        public String getStartCity() {
            return startCity;
        }
        public void setStartCity(String startCity) {
            this.startCity = startCity;
        }
        public String getFinishCity() {
            return finishCity;
        }
        public void setFinishCity(String finishCity) {
            
            this.finishCity = finishCity;
        }
        public String getTransport() {
            return transport;
        }
        public void setTransport(String transport) {
            this.transport = transport;
        }
        
    }
}