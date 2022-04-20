package zoo.entities.areas;

public class LandArea extends BaseArea{

    private static int INIT_CAPACITY = 25;

    public LandArea(String name) {
        super(name, INIT_CAPACITY);
    }
}
