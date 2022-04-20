package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal{

    private static double INIT_KILOS = 5.50;

    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, INIT_KILOS, price);
        this.setKg(INIT_KILOS);
    }

    @Override
    public void eat() {
        super.setKg(this.getKg() + 5.70);
    }
}
