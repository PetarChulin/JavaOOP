package restaurant.entities.drinks;

import restaurant.entities.drinks.interfaces.BaseBeverage;

public class Smoothie extends BaseBeverage {

    private static double smoothiePrice = 4.50;

    public Smoothie(String name, int counter, String brand) {
        super(name, counter, smoothiePrice, brand);
    }
}
