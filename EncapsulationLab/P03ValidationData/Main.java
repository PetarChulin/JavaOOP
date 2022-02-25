package P03ValidationData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numberPeople = Integer.parseInt(s.nextLine());

        List<Person> people = new ArrayList<>();
        while (numberPeople-- > 0) {
            String[] lines = s.nextLine().split("\\s+");

//            try {
                String firstName = lines[0];
                String lastName = lines[1];
                int age = Integer.parseInt(lines[2]);
                double salary = Double.parseDouble(lines[3]);
                people.add(new Person(firstName, lastName, age, salary));

//            } catch (IllegalArgumentException exception) {
//                System.out.println(exception);
//            }
        }
        double bonus = Double.parseDouble(s.nextLine());

        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());

        }
    }
}
