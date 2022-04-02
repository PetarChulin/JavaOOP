package christmasRaces.repositories;

import christmasRaces.entities.races.Race;
import christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {

    private Collection<Race> races;

    public RaceRepository() {
        this.races = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        return this.races.stream().findFirst().filter(r -> r.getName().equals(name)).orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(races);
    }

    @Override
    public void add(Race race) {
        races.add(race);
    }

    @Override
    public boolean remove(Race race) {
        return races.remove(race);
    }
}
