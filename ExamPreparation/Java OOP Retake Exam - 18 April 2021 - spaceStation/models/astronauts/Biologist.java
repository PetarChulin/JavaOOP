package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {

    private static double INIT_OXYGEN = 70;

    public Biologist(String name) {
        super(name, INIT_OXYGEN);
    }

    @Override
    public void breath() {

        if (INIT_OXYGEN <= 0) {
            super.setOxygen(0);
        } else {
            super.setOxygen(getOxygen() - 5);
        }
    }
}
