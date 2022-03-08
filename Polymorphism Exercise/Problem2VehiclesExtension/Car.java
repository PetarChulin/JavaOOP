package PolymorphismProblem2VehiclesExtension;

import java.text.DecimalFormat;

public class Car extends Vehicle {


    public Car(Double fuelQuantity, Double fuelConsumption, Integer tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
    }

    @Override
    public void driving(Double distance) {
        double fuelRequired = distance * (getFuelConsumption() + 0.9);
        if (getFuelQuantity() >= fuelRequired) {
            setFuelQuantity(getFuelQuantity() - fuelRequired);
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.println("Car travelled " + df.format(distance) + " km");
        } else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void refueling(Double liters) {
       refuel(liters);
    }

    protected static Vehicle makeCar(String[] carInfo) {
        return new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Integer.parseInt(carInfo[3]));
    }
}
