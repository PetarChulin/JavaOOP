package P01CarShop;

public class Seat extends CarImpl implements Sellable{


    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced , Double price) {
        super(model, color, horsePower, countryProduced);
        this.setPrice(price);
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires\n"
                + "Seat sells for %.6f", getModel() , countryProduced(), TYRES, getPrice());
    }
}
