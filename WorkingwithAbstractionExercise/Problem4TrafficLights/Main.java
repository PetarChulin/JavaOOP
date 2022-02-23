package WorkingwithAbstractionExercise.Problem4TrafficLights;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] inputLine = s.nextLine().split("\\s+");
        int shift = Integer.parseInt(s.nextLine());

        List<Lights> trafficLights = new ArrayList<>();

        for (String color : inputLine) {
            Lights bulb = new Lights(Colors.valueOf(color));
            trafficLights.add(bulb);
        }

        for (int i = 0; i < shift; i++) {
            for (Lights light : trafficLights) {
                light.changeColor();
                System.out.printf("%s " , light);
            }
            System.out.println();
        }
    }
}



