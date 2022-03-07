package P03PolymorphismLabAnimals;

public abstract class Animal {

    public String name;
    public String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public abstract String explainSelf();

}
