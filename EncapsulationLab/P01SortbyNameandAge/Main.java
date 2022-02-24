package P01SortbyNameandAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();
        while (n-- > 0) {
            String[] lines = reader.readLine().split("\\s+");
            people.add(new Person(lines[0], lines[1], Integer.parseInt(lines[2])));
        }
        people.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge));

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
