package P05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        List<String> idNumbers = new ArrayList<>();

        while (!"End".equals(input)) {

            String[] info = input.split("\\s+");

            if (info.length == 3) {
                idNumbers.add(info[2]);
            } else {
                idNumbers.add(info[1]);
            }
            input = sc.nextLine();
        }
        String number = sc.nextLine();

        for (String id : idNumbers) {
            if (id.endsWith(number)) {
                System.out.println(id);
            }
        }
    }
}
