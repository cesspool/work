package form.pdf;

import utils.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderFormBean {

    private DeliveryRoute delRoute = new DeliveryRoute();
    
    public void appendRoutePart(String city, String transport) {
        delRoute.addRoutePart(city, transport);
    }
    
    public Iterator<Pair<String, String>> getRouterItr() {
        return delRoute.getRouteItr();
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
    
    
    
    public static class DeliveryRoute {
        private List<Pair<String, String>> route = new ArrayList<>();
        
        public void addRoutePart(String city, String transport) {
            route.add(new Pair<>(city, transport));
        }
        
        
        public Iterator<Pair<String, String>> getRouteItr() {
            return route.iterator();
        }
    }
}
