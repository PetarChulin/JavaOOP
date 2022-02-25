package Problem2AnimalFarm;

public class Chicken {

    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }
    public double productPerDay () {
        double eggs = 0;
        if (age > 0 && age <= 5) {
            eggs = 2;
        } else if (age >= 6 && age <= 11) {
            eggs = 1;
        } else if (age > 11) {
            eggs = 0.75;
        }
        return eggs;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day."
                , name , age , productPerDay());
    }
    private double calculateProductPerDay () {
        return 0;
    }
}
