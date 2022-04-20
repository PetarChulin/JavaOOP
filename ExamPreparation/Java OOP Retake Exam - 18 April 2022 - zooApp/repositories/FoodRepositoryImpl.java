package zoo.repositories;

import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

public class FoodRepositoryImpl implements FoodRepository {

    private final Collection<Food> foods;

    public FoodRepositoryImpl() {
        this.foods = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        this.foods.add(food);
    }

    @Override
    public boolean remove(Food food) {

        for (Food f : foods) {
            if (f.getClass().getSimpleName().equals("Vegetable") ||
                    f.getClass().getSimpleName().equals("Meat")) {
                foods.remove(f);
                return true;
            }
        }
        return false;
    }

    @Override
    public Food findByType(String type) {
        return this.foods.stream().findFirst().filter(f->f.getClass().getSimpleName().equals(type)).orElse(null);
    }
}
