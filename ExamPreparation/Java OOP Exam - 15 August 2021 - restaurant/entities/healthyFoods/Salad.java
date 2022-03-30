package restaurant.entities.healthyFoods;

import restaurant.entities.healthyFoods.interfaces.Food;

public class Salad extends Food {
    private static double InitialSaladPortion = 150;

    public Salad(String name, double price) {
        super(name, InitialSaladPortion, price);
    }
}
