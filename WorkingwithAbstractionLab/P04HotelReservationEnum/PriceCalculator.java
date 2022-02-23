package WorkingwithAbstractionLab.P04HotelReservationEnum;

public class PriceCalculator {

    public static String priceCalculate(Season season, Discount discount, double pricePerDay, int days) {
        double totalPrice = days * pricePerDay;

        totalPrice *= season.getMultiplier() * discount.getDiscount();

        return String.format("%.2f", totalPrice);
    }
}
