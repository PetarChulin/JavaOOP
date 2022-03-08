package PolymorphismProblem2VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    public Bus(Double fuelQuantity, Double fuelConsumption, Integer tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
    }

    @Override
    public void driving(Double distance) {
        double fuelRequired = distance * (getFuelConsumption() + 1.4);
        busDriving(fuelRequired, distance);
    }
    @Override
    public void refueling(Double liters) {
       refuel(liters);
    }

    public void driveEmpty(Double distance) {
        double fuelRequired = distance * (getFuelConsumption());
        busDriving(fuelRequired, distance);
    }

    private void busDriving(double fuelRequired, Double distance) {
        if (getFuelQuantity() >= fuelRequired) {
            setFuelQuantity(getFuelQuantity() - fuelRequired);
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.println("Bus travelled " + df.format(distance) + " km");
        } else {
            System.out.println("Bus needs refueling");
        }
    }
    protected static Vehicle makeBus(String[] busInfo) {
        return new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Integer.parseInt(busInfo[3]));
    }
}
