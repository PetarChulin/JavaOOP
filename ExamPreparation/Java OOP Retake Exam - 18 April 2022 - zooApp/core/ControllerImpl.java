package zoo.core;

import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static zoo.common.ConstantMessages.*;

import static zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private final FoodRepository foodRepository;
    private final Collection<Area> areas;
    private Area area;
    private Food food;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {

        switch (areaType) {
            case "WaterArea":
                area = new WaterArea(areaName);
                break;
            case "LandArea":
                area = new LandArea(areaName);
                break;
            default:
                throw new NullPointerException(INVALID_AREA_TYPE);
        }
        areas.add(area);
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {

        switch (foodType) {
            case "Vegetable":
                food = new Vegetable();
                break;
            case "Meat":
                food = new Meat();
                break;
            default:
                throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        this.foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {

        food = this.foodRepository.findByType(foodType);

        if (food == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }
        area = findArea(areaName);

        area.addFood(food);

        this.foodRepository.remove(food);

        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }



    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {

        area = findArea(areaName);

        Animal animal;
        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName, kind, price);
                break;
            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName, kind, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }
        String areaType = area.getClass().getSimpleName();

        boolean isSuitable = ((areaType.equals("WaterArea")) && (animalType.equals("AquaticAnimal")) ||
                (areaType.equals("LandArea")) && (animalType.equals("TerrestrialAnimal")));

        if (isSuitable) {
            area.addAnimal(animal);
            return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
        }
        return AREA_NOT_SUITABLE;
    }

    @Override
    public String feedAnimal(String areaName) {

        int animalsFed = 0;

        area = findArea(areaName);

        Collection<Animal> animals = area.getAnimals();

        for (Animal animal : animals) {
            animal.eat();
            animalsFed++;
        }
        return String.format(ANIMALS_FED, animalsFed);
    }

    @Override
    public String calculateKg(String areaName) {

        area = findArea(areaName);

        Collection<Animal> animals = area.getAnimals();

        double sumKilos = animals.stream().mapToDouble(Animal::getKg).sum();

        return String.format(KILOGRAMS_AREA, areaName, sumKilos);
    }

    @Override
    public String getStatistics() {
        StringBuilder build = new StringBuilder();

        for (Area area : this.areas) {
            build.append(area.getInfo()).append("\n");
        }

        return build.toString().trim();
    }
    private Area findArea(String areaName) {
        return this.areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);
    }
}
