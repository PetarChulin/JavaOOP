package zoo.entities.areas;

public class WaterArea extends BaseArea{

    private static int INIT_CAPACITY = 10;

    public WaterArea(String name) {
        super(name, INIT_CAPACITY);
    }
}
