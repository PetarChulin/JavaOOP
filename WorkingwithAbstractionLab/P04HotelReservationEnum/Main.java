package WorkingwithAbstractionLab.P04HotelReservationEnum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] line = s.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(line[0]);
        int days = Integer.parseInt(line[1]);
        Season currSeason = Season.valueOf(line[2]);
        Discount currDiscount = Discount.valueOf(line[3]);

        String totalPrice = PriceCalculator.priceCalculate(currSeason, currDiscount, pricePerDay, days);
        System.out.println(totalPrice);


    }
}
