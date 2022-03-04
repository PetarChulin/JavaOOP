package P03BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static P03BirthdayCelebrations.Citizen.getData;
import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(in);

        List<Birthable> creatures = new ArrayList<>();

        String input = s.nextLine();

        while (!input.equals("End")) {

            if (getData(input, "\\s+", 0).equals("Citizen")) {
                String name = getData(input, "\\s+", 1);
                int age = Integer.parseInt(getData(input, "\\s+", 2));
                String id = getData(input, "\\s+", 3);
                String birthDate = getData(input, "\\s+", 4);

                Citizen citizen = new Citizen(name, age, id, birthDate);
                creatures.add(citizen);

            } else if (getData(input, "\\s+", 0).equals("Pet")){
                String name = getData(input, "\\s+", 1);
                String birthDate = getData(input, "\\s+", 2);

                Pet pet = new Pet(name, birthDate);
                creatures.add(pet);
            }
            input = s.nextLine();
        }
        String year = s.nextLine();
        for (Birthable being : creatures) {
            if (getData(being.getBirthDate(), "/", 2).equals(year)){
                System.out.println(being.getBirthDate());
            }
        }
    }
}
