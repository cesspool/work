package logic;

import java.util.Arrays;

public class CostPackage {

    private double maxWeight;
    private int maxQuantity;
    private double maxWidth;
    private double maxLength;
    private double maxHigh;
    private double costShipping;
    private double additionalCost;

    public int filter(double high, double length, double width, double weight, int quantity){
        if((this.maxWeight < weight) || (this.maxQuantity < quantity) ||
                (this.maxWidth < width) || (this.maxLength < length) ||
                (this.maxHigh < high)) {
            return 0; // you shall not pass
        }
    }

    public double getCost(double high, double length, double width, double weight, int quantity) {
        final double minDensity = 100;
        final double maxDensity = 5000;
        final int count=4;
        double volume = high * length * width;
        double firstCost = volume * costShipping + weight * costShipping;
        double density = weight / volume;
        // weight check
        if (density < minDensity) {
            firstCost += volume * additionalCost;
        }else if(density > maxDensity) {
            firstCost+= weight * additionalCost;
        }
        //volume check
        double mas[] = {high, length, width};
        Arrays.sort(mas);
        if((mas[1]*count > mas[2])||(mas[0]*count > mas[1])){
            firstCost += volume * additionalCost;
        }
        firstCost = firstCost * quantity;
        return firstCost;
    }
}
