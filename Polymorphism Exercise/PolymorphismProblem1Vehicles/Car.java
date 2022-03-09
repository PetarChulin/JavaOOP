package PolymorphismProblem1Vehicles;

public class Car extends Vehicle {
    private static final Double ADD_FUEL_CONSUMED = 0.9;

    public Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        setFuelConsumption(fuelConsumption + ADD_FUEL_CONSUMED);
    }
    protected static Car makeCar(String[] carInfo) {
        return new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
    }
}
