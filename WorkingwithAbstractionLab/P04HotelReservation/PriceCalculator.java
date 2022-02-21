package WorkingwithAbstractionLab.P04HotelReservation;

public class PriceCalculator {


    public void ParseCommand(String[] args) {

        double pricePerDay = Double.parseDouble(args[0]);
        int days = Integer.parseInt(args[1]);
        String season = args[2];
        String discount = args[3];
        double totalPrice = days * pricePerDay;

        totalPrice = getTotalPrice(season, discount, totalPrice);

        System.out.printf("%.2f" , totalPrice);
    }

    private double getTotalPrice(String season, String discount, double totalPrice) {
        if (season.equals("Spring")) {
            totalPrice *= 2;
        } else if (season.equals("Winter")) {
            totalPrice *= 3;
        } else if (season.equals("Summer")) {
            totalPrice *= 4;
        }

        if (discount.equals("VIP")) {
            totalPrice *= 0.8;
        } else if (discount.equals("SecondVisit")) {
            totalPrice *= 0.9;
        }
        return totalPrice;
    }
}
