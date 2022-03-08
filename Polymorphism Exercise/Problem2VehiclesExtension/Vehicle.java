package PolymorphismProblem2VehiclesExtension;

public abstract class Vehicle {

    private Double fuelQuantity;
    private Double fuelConsumption;
    private Integer tankCapacity;

    public Vehicle(Double fuelQuantity, Double fuelConsumption, Integer tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public Integer getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(Integer tankCapacity) {
        this.tankCapacity = tankCapacity;
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

    public abstract void driving(Double distance);

    public void refueling(Double liters) {
        refuel(liters);
    }

    public void refuel(Double liters) {
        if (getTankCapacity() <= 0 || liters <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if ((getFuelQuantity() + liters) > getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            setFuelQuantity(getFuelQuantity() + liters);
        }
    }
}

