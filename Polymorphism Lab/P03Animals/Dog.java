package P03PolymorphismLabAnimals;

public class Dog extends Animal {

    public String name;
    public String favouriteFood;

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s DJAAF", name, favouriteFood);
    }
}