package PolymorphismProblem1Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {


    public Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
    }

    @Override
    public void driving(Double distance) {
        double fuelRequired = distance * (getFuelConsumption() + 0.9);
        if (getFuelQuantity() >= fuelRequired) {
            setFuelQuantity(getFuelQuantity() - fuelRequired);
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.println("Car travelled " + df.format(distance) +" km");
        } else {
            System.out.println("Car needs refueling");
        }
    }
    @Override
    public void refueling(Double liters) {
        setFuelQuantity(getFuelQuantity() + liters);
    }
}
