package P04FirstAndReverseTeam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int countPlayers = Integer.parseInt(s.nextLine());

        Team team = new Team("Black Eagles");

        while (countPlayers-- > 0) {
            String[] lines = s.nextLine().split("\\s+");
            String firstName = lines[0];
            String lastName = lines[1];
            int age = Integer.parseInt(lines[2]);
            double salary = Double.parseDouble(lines[3]);
            team.addPlayer(new Person(firstName, lastName, age, salary));
        }
        System.out.printf("First team have %d players\n" , team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players\n" , team.getReserveTeam().size());
    }
}
