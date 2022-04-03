package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static spaceStation.common.ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY;

public class AstronautRepository implements Repository<Astronaut>{

    Map<String , Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedHashMap<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(this.astronauts.values());
    }

    @Override
    public void add(Astronaut model) {

        if (model == null) {
            throw new IllegalArgumentException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.astronauts.put(model.getName(), model);
    }

    @Override
    public boolean remove(Astronaut model) {
        return this.astronauts.remove(model.getName()) != null;
    }

    @Override
    public Astronaut findByName(String name) {
        return astronauts.get(name);
    }
}
