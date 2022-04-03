package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.bags.Backpack;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private AstronautRepository astronauts;
    private PlanetRepository planets;
    private Backpack items;

    public ControllerImpl() {
        astronauts = new AstronautRepository();
        planets = new PlanetRepository();
        items = new Backpack();
    }

    int exploredPlanets = 0;

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
        astronauts.add(astronaut);

        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {

        Planet planet = new PlanetImpl(planetName);
        if (planetName == null || planetName.trim().isEmpty()) {
            throw new NullPointerException(PLANET_NAME_NULL_OR_EMPTY);
        } else {
            planets.add(planet);
            for (String item : items) {
                planet.getItems().add(item);
            }
        }
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronauts.findByName(astronautName);

        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronauts.remove(astronaut);

        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {

        Mission mission = new MissionImpl();

        List<Astronaut> suitablePeople = astronauts.getModels().stream().
                filter(a -> a.getOxygen() > 60).collect(Collectors.toList());

        if (suitablePeople.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        mission.explore(this.planets.findByName(planetName), suitablePeople);

        int retired = 0;
        for (Astronaut suitablePerson : suitablePeople) {
            if (suitablePerson.getOxygen() == 0) {
//                astronauts.remove(suitablePerson);
                retired++;
            }
        }
        exploredPlanets++;


        return String.format(PLANET_EXPLORED, planetName, retired);
    }

    @Override
    public String report() {

        StringBuilder build = new StringBuilder();

        build.append(String.format(REPORT_PLANET_EXPLORED, exploredPlanets)).append(System.lineSeparator())
                .append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        for (Astronaut astronaut : astronauts.getModels()) {

            build.append(String.format(REPORT_ASTRONAUT_NAME, astronaut.getName())).append(System.lineSeparator());
            build.append(String.format(REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen())).append(System.lineSeparator());

            if (astronaut.getBag().getItems().isEmpty()) {
                build.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, "None")).append(System.lineSeparator());
            } else {
                build.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS,
                                String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, astronaut.getBag().getItems())))
                        .append(System.lineSeparator());
            }
        }
        return build.toString().trim();
    }
}
