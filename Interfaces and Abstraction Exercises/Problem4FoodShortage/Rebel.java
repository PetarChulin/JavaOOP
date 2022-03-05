package Problem4FoodShortage;

import java.util.Map;

public class Rebel implements Buyer, Person {

    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
    public static void addRebel(Map<String, Buyer> persons, String[] line) {
        Rebel rebel = new Rebel(line[0], Integer.parseInt(line[1]), line[2]);
        persons.put(line[0], rebel);
    }
}
