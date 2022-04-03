package spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut{

    private static double INIT_OXYGEN = 90;


    public Meteorologist(String name) {
        super(name, INIT_OXYGEN);
    }
}
