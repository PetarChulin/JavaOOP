package TrafficLights2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] inputLines = s.nextLine().split("\\s+");
        int shift = Integer.parseInt(s.nextLine());

        List<Color> lights = new ArrayList<>();
        for (String light : inputLines) {
            lights.add(Color.valueOf(light));
        }
        for (int i = 0; i < shift; i++) {
            for (int j = 0; j < lights.size(); j++) {
                lights.set(j, Color.valueOf(lights.get(j).nextColor));
                System.out.print(lights.get(j) + " ");
            }
            System.out.println();
        }
    }
}
