package aquarium.repositories;

import aquarium.entities.decorations.Decoration;

import java.util.ArrayList;
import java.util.Collection;

public class DecorationRepository implements Repository{

    private Collection<Decoration> decorations;

    public DecorationRepository() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void add(Decoration decoration) {
        this.decorations.add(decoration);

    }

    @Override
    public boolean remove(Decoration decoration) {
        return this.decorations.remove(decoration);
    }

    @Override
    public Decoration findByType(String type) {

//        for (Decoration decoration : this.decorations) {
//            if (decoration.getClass().getSimpleName().equals(type)) {
//                return decoration;
//            }
//        }
        return this.decorations.stream().findFirst().filter(d -> d.getClass().getSimpleName().equals(type)).orElse(null);
    }
}
