package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Driver> drivers;
    private Repository<Car> cars;
    private Repository<Race> races;


    public ControllerImpl(Repository<Driver> drivers, Repository<Car> cars, Repository<Race> races) {
        this.drivers = drivers;
        this.cars = cars;
        this.races = races;
    }

    @Override
    public String createDriver(String driverName) {
        checkObjectForNullValue(this.drivers.getByName(driverName) != null, String.format(DRIVER_EXISTS, driverName));
        Driver driver = new DriverImpl(driverName);
        drivers.add(driver);
        return String.format(DRIVER_CREATED, driverName);
    }

    private void checkObjectForNullValue(boolean drivers, String DRIVER_EXISTS) {
        if (drivers) {
            throw new IllegalArgumentException(DRIVER_EXISTS);
        }
    }

    @Override
    public String createCar(String type, String model, int horsePower) {

        if (this.cars.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        } else {
            Car car = null;
            String typeCar = "";
            switch (type) {
                case "Muscle":
                    car = new MuscleCar(model, horsePower);
                    typeCar = "MuscleCar";
                    break;
                case "Sports":
                    car = new SportsCar(model, horsePower);
                    typeCar = "SportsCar";
                    break;

            }
            cars.add(car);
            return String.format(CAR_CREATED, typeCar, model);
        }
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        checkObjectForNullValue(this.drivers.getByName(driverName) == null, String.format(DRIVER_NOT_FOUND, driverName));
        checkObjectForNullValue(this.cars.getByName(carModel) == null, String.format(CAR_NOT_FOUND, carModel));

        Car car = cars.getByName(carModel);

        drivers.getByName(driverName).addCar(car);

        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        checkObjectForNullValue(this.races.getByName(raceName) == null, String.format(RACE_NOT_FOUND, raceName));
        checkObjectForNullValue(this.drivers.getByName(driverName) == null, String.format(DRIVER_NOT_FOUND, driverName));

        Driver driver = drivers.getByName(driverName);

        races.getByName(raceName).addDriver(driver);

        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String createRace(String name, int laps) {
        checkObjectForNullValue(this.races.getByName(name) != null, String.format(RACE_EXISTS, name));
        Race race = new RaceImpl(name, laps);

        races.add(race);

        return String.format(RACE_CREATED, name);
    }

    @Override
    public String startRace(String raceName) {
        Race race = races.getByName(raceName);
        checkObjectForNullValue(race == null, String.format(RACE_NOT_FOUND, raceName));
        checkObjectForNullValue(race.getDrivers().size() < 3, String.format(RACE_INVALID, raceName, 3));
        Collection<Driver> driverList = race.getDrivers();
        int numberOfLaps = race.getLaps();
        List<Driver> winners = driverList.stream().sorted((firstWinner, secondWinner) ->
                (int) (secondWinner.getCar().calculateRacePoints(numberOfLaps) -
                        firstWinner.getCar().calculateRacePoints(numberOfLaps))).limit(3).collect(Collectors.toList());

        races.remove(race);
        Driver firstWinner = winners.get(0);
        Driver secondWinner = winners.get(1);
        Driver thirdWinner = winners.get(2);

        StringBuilder build = new StringBuilder();
        build.append(String.format(DRIVER_FIRST_POSITION , firstWinner.getName() , raceName)).append("\n");
        build.append(String.format(DRIVER_SECOND_POSITION , secondWinner.getName() , raceName)).append("\n");
        build.append(String.format(DRIVER_THIRD_POSITION , thirdWinner.getName() , raceName)).append("\n");

        return build.toString().trim();
    }

}