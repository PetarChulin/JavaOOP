package goldDigger.models.discoverer;

public class Archaeologist extends BaseDiscoverer{

    private static final double INIT_ENERGY = 60;

    public Archaeologist(String name) {
        super(name, INIT_ENERGY);
    }
}
