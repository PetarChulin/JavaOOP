package animals;

public class Kitten extends Cat {
    private static final String FEMALE = "Female";

    public Kitten(String name, int age) {
        super(name, age, FEMALE);
    }

    public String produceSound() {
        return "Meow";
    }
}
