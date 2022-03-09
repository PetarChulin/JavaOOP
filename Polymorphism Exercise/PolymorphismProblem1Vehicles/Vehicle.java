package PolymorphismProblem1Vehicles;

import java.text.DecimalFormat;

public class Vehicle {

    private Double fuelQuantity;
    private Double fuelConsumption;

    public Vehicle(Double fuelQuantity, Double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void driving(Double distance) {

        double fuelRequired = distance * getFuelConsumption();
        if (getFuelQuantity() >= fuelRequired) {
            setFuelQuantity(getFuelQuantity() - fuelRequired);
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.printf("%s travelled " + df.format(distance) + " km\n", getClass().getSimpleName());
        } else {
            System.out.printf("%s needs refueling\n", getClass().getSimpleName());
        }
    }

    public void refueling(Double liters) {
        this.fuelQuantity += liters;
    }
}

