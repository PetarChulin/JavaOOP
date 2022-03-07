package PolymorphismLabP02Shapes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double height = Double.parseDouble(sc.nextLine());
        double width = Double.parseDouble(sc.nextLine());
        double radius = Double.parseDouble(sc.nextLine());

        Shape circle = new Circle(radius);

        Shape rectangle = new Rectangle(height,width);

        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());

        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());
    }
}
