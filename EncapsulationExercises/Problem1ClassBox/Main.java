package EncapsulationExercises.Problem1ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double length = Double.parseDouble(s.nextLine());
        double width = Double.parseDouble(s.nextLine());
        double height = Double.parseDouble(s.nextLine());

        Box box = new Box(length, width , height);

        System.out.printf("Surface Area - %.2f\n" , box.calculateSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f\n" , box.calculateLateralSurfaceArea());
        System.out.printf("Volume – %.2f" , box.calculateVolume());
    }
}
