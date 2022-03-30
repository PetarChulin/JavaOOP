package restaurant.entities.drinks;

import restaurant.entities.drinks.interfaces.BaseBeverage;

public class Fresh extends BaseBeverage {

    private static double freshPrice = 3.50;

    public Fresh(String name, int counter,  String brand) {
        super(name, counter, freshPrice, brand);
    }
}
