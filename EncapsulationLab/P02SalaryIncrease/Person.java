package P02SalaryIncrease;

import java.text.DecimalFormat;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;


    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;

    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        if (age < 30) {
            setSalary(salary + ((salary * bonus / 100) / 2));
        } else {
            setSalary(salary + (salary * bonus / 100));
        }
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#.0###");
        return String.format("%s %s gets ", this.firstName, this.lastName) +
                df.format(this.salary) + (" leva");
    }
}
