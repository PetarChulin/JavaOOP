package PolymorphismProblem3WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static PolymorphismProblem3WildFarm.Animal.makeAnimal;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!line.equals("End")) {

            String[] animalInfo = line.split(" ");
            String[] foodInfo = sc.nextLine().split(" ");

            Animal animal = makeAnimal(animalInfo);
            Food food = getFood(foodInfo);

            assert animal != null;
            animal.makeSound();
            animal.eat(food);
            animals.add(animal);

            line = sc.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public static Food getFood(String[] foodInfo) {
        String foodType = foodInfo[0];
        int foodQuantity = Integer.parseInt(foodInfo[1]);
        if (foodType.equals("Meat")) {
            return new Meat(foodQuantity);
        } else {
            return new Vegetable(foodQuantity);
        }
    }
}
