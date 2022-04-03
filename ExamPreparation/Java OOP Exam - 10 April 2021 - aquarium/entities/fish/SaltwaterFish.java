package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish{

    private static int INIT_SIZE = 5;
    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        setSize(INIT_SIZE);
    }

    @Override
    public void eat() {
        super.setSize(INIT_SIZE + 2);
    }
}
