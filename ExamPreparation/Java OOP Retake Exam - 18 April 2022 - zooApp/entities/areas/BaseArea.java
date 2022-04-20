package zoo.entities.areas;

import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static zoo.common.ExceptionMessages.*;

public abstract class BaseArea implements Area {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }


    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getName() {
        return this.name;
    }


    public int getCapacity() {
        return this.capacity;
    }


    @Override
    public Collection<Animal> getAnimals() {
        return this.animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return this.foods;
    }

    @Override
    public int sumCalories() {
        return this.foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (this.capacity <= this.animals.size()) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
        animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        this.animals.forEach(Animal::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder build = new StringBuilder();
        build.append(String.format("%s (%s):", this.getName(), this.getClass().getSimpleName())).append("\n");
        build.append("Animals: ");
        if (!this.animals.isEmpty()) {
            build.append(this.animals.stream().map(Animal::getName).collect(Collectors.joining(" ")).trim());
        } else {
            build.append("none");
        }
        build.append("\n");
        build.append(String.format("Foods: %d\nCalories: %d", this.foods.size(), this.sumCalories())).append("\n");

        return build.toString().trim();
    }
}
