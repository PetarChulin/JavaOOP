package zoo.entities.foods;

public class Meat extends BaseFood{

    private static int INIT_CALORIES = 70;
    private static double INIT_PRICE = 10;

    public Meat() {
        super(INIT_CALORIES, INIT_PRICE);
    }
}

