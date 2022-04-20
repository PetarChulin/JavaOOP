package zoo.entities.foods;

public class Vegetable extends BaseFood{

    private static int INIT_CALORIES = 50;
    private static double INIT_PRICE = 5;

    public Vegetable() {
        super(INIT_CALORIES, INIT_PRICE);
    }
}
