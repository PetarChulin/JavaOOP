package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.Repository;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private final Repository toys;
    private final Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        if (type.equals("ShortHouse")) {
            houses.add(new ShortHouse(name));
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
        } else if (type.equals("LongHouse")) {
            houses.add(new LongHouse(name));
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
        }
        return ExceptionMessages.INVALID_HOUSE_TYPE;
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        if (type.equals("Ball")) {
            toy = new Ball();
        } else if (type.equals("Mouse")) {
            toy = new Mouse();
        } else {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        this.toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }
        for (House house : this.houses) {
            if (house.getName().equals(houseName)) {
                house.buyToy(toy);
                this.toys.removeToy(toy);
            }
        }
        return (String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName));
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {

        Cat cat;

        if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);
        } else if (catType.equals("ShorthairCat")) {
            cat = new ShorthairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        House house = checkHouse(houseName);

        String houseType = house.getClass().getSimpleName();

        boolean suitable = ((houseType.equals("LongHouse")) && (catType.equals("LonghairCat")) ||
                (houseType.equals("ShortHouse")) && (catType.equals("ShorthairCat")));

        if (suitable) {
            house.addCat(cat);
            return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        }
        return UNSUITABLE_HOUSE;
    }


    @Override
    public String feedingCat(String houseName) {

        House house = checkHouse(houseName);

        Collection<Cat> cats = house.getCats();

        int catFed = 0;

        for (Cat cat : cats) {
            cat.eating();
            catFed++;
        }
        return String.format(FEEDING_CAT, catFed);
    }

    private House checkHouse(String houseName) {
        return this.houses
                .stream()
                .filter(h -> h.getName().equals(houseName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String sumOfAll(String houseName) {

        House house = checkHouse(houseName);
        double totalSum = 0;

        Collection<Toy> toys = house.getToys();

        for (Toy toy : toys) {
            totalSum += toy.getPrice();
        }
        Collection<Cat> cats = house.getCats();

        for (Cat cat : cats) {
            totalSum += cat.getPrice();
        }
        return String.format(ConstantMessages.VALUE_HOUSE, houseName, totalSum);
    }

    @Override
    public String getStatistics() {

        StringBuilder build = new StringBuilder();

        for (House house : this.houses) {
            build.append(house.getStatistics());
        }
        return build.toString().trim();
    }
}

