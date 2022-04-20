package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal{

    private static double INIT_KILOS = 2.50;


    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, INIT_KILOS, price);
        this.setKg(INIT_KILOS);
    }

    @Override
    public void eat() {
        super.setKg(this.getKg() + 7.50);
    }
}
