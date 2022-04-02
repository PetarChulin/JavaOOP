package catHouse.repositories;

import catHouse.entities.toys.Toy;


import java.util.ArrayList;
import java.util.Collection;

public class ToyRepository implements Repository {

    private final Collection<Toy> toys;

    public ToyRepository() {
        this.toys = new ArrayList<>();
    }

    public void buyToy(Toy toy) {
        this.toys.add(toy);

    }
    public boolean removeToy(Toy toy) {

        for (Toy t : toys) {
            if (t.getClass().getSimpleName().equals("Mouse")
                    || t.getClass().getSimpleName().equals("Ball")) {
        toys.remove(t);
        return true;
            }
        }
        return false;
    }
    @Override
    public Toy findFirst(String type) {

        for (Toy toy : toys) {
            if (toy.getClass().getSimpleName().equals(type)) {
                return toy;
            }
        }
        return null;
    }
}
