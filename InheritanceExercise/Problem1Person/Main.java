package Problem1Person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String name = s.nextLine();
        int age = Integer.parseInt(s.nextLine());

        Child child = new Child (name, age);

        System.out.println(child.getName());
        System.out.println(child.getAge());


    }
}
