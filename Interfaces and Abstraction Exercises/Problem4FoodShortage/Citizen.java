package Problem4FoodShortage;

import java.util.Map;

public class Citizen implements Buyer, Person, Birthable, Identifiable {
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getFood() {
        return food;
    }

    public void buyFood() {
        this.food += 10;
    }
    public static void addCitizen(Map<String, Buyer> persons, String[] line) {
        Citizen citizen = new Citizen(line[0], Integer.parseInt(line[1]), line[2], line[3]);
        persons.put(line[0], citizen);
    }
}
