package Problem2AnimalFarm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String name = s.nextLine();
        int age = Integer.parseInt(s.nextLine());

        Chicken chicken = new Chicken(name,age);

        System.out.println(chicken.toString());
    }
}
