package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        Object animal = "";
        while (true) {
            String animalType = s.nextLine();
            if (animalType.equals("Beast!")) {
                break;
            }
            String[] animalInfo = s.nextLine().split("\\s+");
            String name = animalInfo[0];
            int age = Integer.parseInt(animalInfo[1]);
            String gender = animalInfo[2];

            try {
                switch (animalType) {
                    case "Cat":
                        animal = new Cat(name, age, gender);
                        System.out.println(animal.toString());
                        break;
                    case "Dog":
                        animal = new Dog(name, age, gender);
                        System.out.println(animal.toString());
                        break;
                    case "Frog":
                        animal = new Frog(name, age, gender);
                        System.out.println(animal.toString());
                        break;
                }
            } catch (IllegalArgumentException exception) {
                System.out.println(exception);
            }
        }
    }
}
