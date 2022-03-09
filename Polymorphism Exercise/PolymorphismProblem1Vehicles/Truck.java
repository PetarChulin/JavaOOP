package PolymorphismProblem1Vehicles;

public class Truck extends Vehicle {
    private static final Double ADD_FUEL_CONSUMED = 1.6;
    private static final Double LEAKAGE = 0.95;

    public Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity , fuelConsumption);
        setFuelConsumption(fuelConsumption + ADD_FUEL_CONSUMED);
    }
    @Override
    public void refueling(Double liters) {
        liters = liters * LEAKAGE;
        super.refueling(liters);
    }
    protected static Truck makeTruck(String[] truckInfo) {
        return new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));
    }
}
