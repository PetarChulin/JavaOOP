package restaurant.entities.healthyFoods;

import restaurant.entities.healthyFoods.interfaces.Food;

public class VeganBiscuits extends Food {

    private static double InitialVeganBiscuitsPortion = 205;
    public VeganBiscuits(String name, double price) {
        super(name, InitialVeganBiscuitsPortion, price);
    }
}
