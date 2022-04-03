package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static spaceStation.common.ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY;

public class PlanetRepository implements Repository<Planet>{

    Map<String , Planet> planets;

    public PlanetRepository() {
        this.planets = new LinkedHashMap<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(this.planets.values());
    }

    @Override
    public void add(Planet model) {

        if (model == null) {
            throw new IllegalArgumentException(PLANET_NAME_NULL_OR_EMPTY);
        }
        planets.put(model.getName(), model);
    }

    @Override
    public boolean remove(Planet model) {
        return this.planets.remove(model.getName()) != null;
    }

    @Override
    public Planet findByName(String name) {
        return this.planets.get(name);
    }
}
