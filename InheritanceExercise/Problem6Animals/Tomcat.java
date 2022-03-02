package animals;

public class Tomcat extends Cat {

    private static final String MALE = "Male";

    public Tomcat(String name, int age) {
        super(name, age, MALE);
    }

    public String produceSound() {
        return "MEOW";
    }
}
