package PolymorphismProblem2VehiclesExtension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {

    public Truck(Double fuelQuantity, Double fuelConsumption, Integer tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
    }

    @Override
    public void driving(Double distance) {
        double fuelRequired = distance * (getFuelConsumption() + 1.6);
        if (getFuelQuantity() >= fuelRequired) {
            setFuelQuantity(getFuelQuantity() - fuelRequired);
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.println("Truck travelled " + df.format(distance) + " km");
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refueling(Double liters) {
        if (getTankCapacity() <= 0 || liters <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if ((getFuelQuantity() + liters) > getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            setFuelQuantity(getFuelQuantity() + (liters * 0.95));
        }

    }
    protected static Vehicle makeTruck(String[] truckInfo) {
        return new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Integer.parseInt(truckInfo[3]));
    }
}
