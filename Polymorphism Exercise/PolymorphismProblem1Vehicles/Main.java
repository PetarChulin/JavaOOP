package PolymorphismProblem1Vehicles;

import java.util.Scanner;

import static PolymorphismProblem1Vehicles.Car.makeCar;
import static PolymorphismProblem1Vehicles.Truck.makeTruck;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] carInfo = sc.nextLine().split("\\s+");
        String[] truckInfo = sc.nextLine().split("\\s+");
        int commands = Integer.parseInt(sc.nextLine());

        Vehicle car = makeCar(carInfo);
        Vehicle truck = makeTruck(truckInfo);

        for (int i = 0; i < commands; i++) {

            String[] command = sc.nextLine().split("\\s+");
            String action = command[0];
            String vehicleType = command[1];
            Double distance = Double.valueOf(command[2]);

            if (action.equals("Drive")) {
                if (vehicleType.equals("Car")) {
                    car.driving(distance);
                } else {
                    truck.driving(distance);
                }
            } else {
                Double liters = Double.valueOf(command[2]);
                if (command[1].equals("Car")) {
                    car.refueling(liters);
                } else {
                    truck.refueling(liters);
                }
            }
        }
        System.out.printf("Car: %.2f\n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f\n", truck.getFuelQuantity());
    }
}