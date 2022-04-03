package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut{

    private static double INIT_OXYGEN = 50;

    public Geodesist(String name) {
        super(name,INIT_OXYGEN);
    }

}
