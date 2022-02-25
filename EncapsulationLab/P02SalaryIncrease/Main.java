package P02SalaryIncrease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        List<Person> people = new ArrayList<>();
        while (n-- > 0) {
            String[] lines = s.nextLine().split("\\s+");
            String firstName = lines[0];
            String lastName = lines[1];
            int age = Integer.parseInt(lines[2]);
            double salary = Double.parseDouble(lines[3]);
            people.add(new Person(firstName, lastName, age, salary));
        }
        double bonus = Double.parseDouble(s.nextLine());

        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }
}
