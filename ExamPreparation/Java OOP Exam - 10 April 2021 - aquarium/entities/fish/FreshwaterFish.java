package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish {
    private static int INIT_SIZE = 3;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        setSize(INIT_SIZE);
    }

    @Override
    public void eat() {
        super.setSize(INIT_SIZE + 3);
    }
}
