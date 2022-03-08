package PolymorphismProblem1Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {

    public Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
    }

    @Override
    public void driving(Double distance) {
        double fuelRequired = distance * (getFuelConsumption() + 1.6);
        if (getFuelQuantity() >= fuelRequired) {
            setFuelQuantity(getFuelQuantity() - fuelRequired);
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.println("Truck travelled " + df.format(distance) +" km");
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refueling(Double liters) {
        setFuelQuantity(getFuelQuantity() + (liters * 0.95));
    }
}
