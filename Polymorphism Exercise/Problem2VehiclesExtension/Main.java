package PolymorphismProblem2VehiclesExtension;

import java.util.Scanner;

import static PolymorphismProblem2VehiclesExtension.Bus.makeBus;
import static PolymorphismProblem2VehiclesExtension.Car.makeCar;
import static PolymorphismProblem2VehiclesExtension.Truck.makeTruck;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] carInfo = sc.nextLine().split("\\s+");
        String[] truckInfo = sc.nextLine().split("\\s+");
        String[] busInfo = sc.nextLine().split("\\s+");
        int commands = Integer.parseInt(sc.nextLine());

        Vehicle car = makeCar(carInfo);
        Vehicle truck = makeTruck(truckInfo);
        Vehicle bus = makeBus(busInfo);

        for (int i = 0; i < commands; i++) {

            String[] command = sc.nextLine().split("\\s+");
            String action = command[0];
            String vehicleType = command[1];
            Double distance = Double.valueOf(command[2]);

            switch (action) {
                case "Drive":
                    driveVehicle(car, truck, bus, vehicleType, distance);
                    break;
                case "Refuel":
                    refuelVehicle(car, truck, bus, command, vehicleType);
                    break;
                case "DriveEmpty":
                    ((Bus) bus).driveEmpty(distance);
                    break;
            }
        }
        System.out.printf("Car: %.2f\n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f\n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f\n", bus.getFuelQuantity());
    }

    private static void refuelVehicle(Vehicle car, Vehicle truck, Vehicle bus, String[] command, String vehicleType) {
        Double liters = Double.valueOf(command[2]);
        if (vehicleType.equals("Car")) {
            car.refueling(liters);
        } else if (vehicleType.equals("Truck")) {
            truck.refueling(liters);
        } else {
            bus.refueling(liters);
        }
    }

    private static void driveVehicle(Vehicle car, Vehicle truck, Vehicle bus, String vehicleType, Double distance) {
        if (vehicleType.equals("Car")) {
            car.driving(distance);
        } else if (vehicleType.equals("Truck")) {
            truck.driving(distance);
        } else {
            bus.driving(distance);
        }
    }
}