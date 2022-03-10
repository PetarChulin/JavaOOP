package PolymorphismProblem3WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    public String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.##");
        return String.format("%s[%s, %s, %s, %d]", getClass().getSimpleName(), getAnimalName(),
                df.format(getAnimalWeight()), getLivingRegion() ,getFoodEaten());
    }
}
