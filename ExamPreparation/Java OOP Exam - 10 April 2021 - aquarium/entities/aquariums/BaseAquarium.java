package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public abstract class BaseAquarium implements Aquarium {

    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fishes;

    public BaseAquarium(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.decorations = new ArrayList<>();
        this.fishes = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int calculateComfort() {
        return decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish fish) {

        if (this.capacity < this.fishes.size()) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        } else {
            fishes.add(fish);
        }

    }

    @Override
    public void removeFish(Fish fish) {
        fishes.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish fish : fishes) {
            fish.eat();
        }
    }

    @Override
    public String getInfo() {

        String names = this.fishes
                .stream()
                .map(Fish::getName)
                .collect(Collectors.joining(" "));

        StringBuilder build = new StringBuilder();

        build.append(String.format("%s (%s):" , this.name , this.getClass().getSimpleName())).append(System.lineSeparator());
        build.append("Fish: ");
        if (!fishes.isEmpty()) {
//            for (Fish fish : fishes) {
                build.append(String.format("%s" , names));
//            }
        } else {
            build.append("none").append(System.lineSeparator());
        }
        build.append(System.lineSeparator());
        build.append(String.format("Decorations: %d" , this.decorations.size())).append(System.lineSeparator());
        build.append(String.format("Comfort: %d", calculateComfort())).append(System.lineSeparator());

        return build.toString();
    }

    @Override
    public Collection<Fish> getFish() {
        return fishes;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }
}
