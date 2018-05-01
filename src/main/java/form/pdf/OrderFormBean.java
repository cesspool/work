package form.pdf;

import java.util.ArrayList;
import java.util.List;

public class OrderFormBean {

    private DeliveryRoute delRoute = new DeliveryRoute();
    
    public void appendRoutePart(String city, String transport) {
        delRoute.addRoutePart(city, transport);
    }
    
    public List<RoutePart> getRouteParts() {
        return delRoute.getRouteParts();
    }
    
    public String getUrgency() {
        return "1";
    }
    
    public boolean isEnvelop() {
        return true;
    }
    
    public String getSenderFullName() {
        return "Сидоров Сидор Сидорыч";
    }
    
    public String getSenderCity() {
        return "Москва";
    }
    
    public String getSenderAddress() {
        return "480056 г. Москва, ул. Ленинаб д.123б кв.321";
    }
    
    public String getSenderPhone() {
        return "322-233-579";
    }
    
    public String getRecipientFullName() {
        return "Карлсон Изя Моисеевич";
    }
    
    public String getRecipientCity() {
        return "Сочи";
    }
    
    public String getRecipientAddress() {
        return "3334445б ул.Дерибасовскаяб д.15б кв.3";
    }
    
    public String getRecipientPhone() {
        return "444-445-776";
    }
    
    public String getCargoLength() {
        return "100";
    }
    
    public String getCargoWidth() {
        return "200";
    }
    
    public String getCargoHeight() {
        return "300";
    }
    
    public String getCargoCost() {
        return "$35999";
    }
    
    public String getCargoWeight() {
        return "345 кг";
    }
    
    public String getBoxingName() {
        return "Ящик";
    }
    
    public String getBoxingQuantity() {
        return "3";
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