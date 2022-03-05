package Problem4FoodShortage;

import java.util.*;

import static Problem4FoodShortage.Citizen.addCitizen;
import static Problem4FoodShortage.Rebel.addRebel;
import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(in);

        int count = Integer.parseInt(s.nextLine());
        Map<String, Buyer> persons = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {

            String[] line = s.nextLine().split("\\s+");

            if (line.length == 4) {
                addCitizen(persons, line);
            } else {
                addRebel(persons, line);
            }
        }
        int foodQuantity = 0;
        String name = s.nextLine();
        while (!name.equals("End")) {

            if (persons.containsKey(name)) {
                persons.get(name).buyFood();
            }
            name = s.nextLine();
        }
        for (Buyer value : persons.values()) {
            foodQuantity += value.getFood();
        }
        System.out.println(foodQuantity);
    }
}


