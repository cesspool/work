package form.pdf;

public class OrderFormBean {
    
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
    
    public String getBoxingName() {
        return "Ящик";
    }
    
    public String getBoxingQuantity() {
        return "3";
    }
}
