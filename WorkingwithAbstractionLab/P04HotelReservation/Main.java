package WorkingwithAbstractionLab.P04HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] input = s.nextLine().split(" ");

        PriceCalculator priceCalculator = new PriceCalculator();

        priceCalculator.ParseCommand(input);
    }
}
