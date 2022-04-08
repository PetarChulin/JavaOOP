package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AquariumTests {

    Aquarium aquarium;
    Fish fish;
    Collection<Fish> fishes;

    @Before
    public void setUp() {
        Aquarium aquarium = new Aquarium("aqua", 10);

        Fish f = new Fish("name");
        Fish f1 = new Fish("name1");
        Fish f2 = new Fish("name2");
        fish = new Fish ("Nemo");

        aquarium.add(f);
        aquarium.add(f1);
        aquarium.add(f2);
        fishes = new ArrayList<>();

        fishes.add(f);
    }
    @Test
    public void getName() {

        Assert.assertEquals("Nemo" , fish.getName());
    }

    @Test
    public void isAvailableAfterSell() {
        aquarium = new Aquarium("Aqua" , 2);
        aquarium.add(fish);
        Fish fishForSell = aquarium.sellFish("Nemo");
        assertEquals(fish, fishForSell);
        assertFalse(fishForSell.isAvailable());
    }

    @Test
    public void testAquariumConstructor() {
        Aquarium aquarium = new Aquarium("aqua", 10);
        Fish f = new Fish("name");
        aquarium.add(f);
        Assert.assertEquals("aqua", aquarium.getName());
        Assert.assertEquals(10, aquarium.getCapacity());
        Assert.assertEquals("name", f.getName());
    }

    @Test (expected = NullPointerException.class)
    public void testForInvalidAquariumName() {
        aquarium = new Aquarium(null , 1);
        Assert.assertEquals("aqua" , this.aquarium.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAquariumCapacityForInvalidValue() {
        Aquarium aquarium = new Aquarium("aqua", -10);
        Assert.assertEquals(10 , this.aquarium.getCapacity());
    }
    @Test
    public void testAquariumGetCount () {
        aquarium = new Aquarium("aqua", 10);
        Assert.assertEquals(10 , this.aquarium.getCapacity());
    }

    @Test
    public void testAquariumCapacity() {

        Assert.assertEquals(1 , this.fishes.size());
    }


    @Test (expected = IllegalArgumentException.class)
    public void testForFullAquarium() {
        aquarium = new Aquarium("name1" , 1);
        Fish fish = new Fish("nemo");
        Fish fish1 = new Fish("nemo1");
                aquarium.add(fish);
                aquarium.add(fish1);
        Assert.assertEquals(aquarium.getCapacity() , this.aquarium.getCapacity());
    }
    @Test
    public void testForRemovalOfFish(){
        aquarium = new Aquarium("name1" , 1);
        Fish fish = new Fish("nemo");
        aquarium.add(fish);
        aquarium.remove("nemo");
        Assert.assertEquals(0 , aquarium.getCount());

    }
    @Test (expected = IllegalArgumentException.class)
    public void testForRemovalOfNonExistingFish(){
        aquarium = new Aquarium("name1" , 1);

        aquarium.remove("nemo");
    }


    @Test
    public void testReport() {
        aquarium = new Aquarium("name1", 1);
        Fish fish = new Fish("nemo");
        aquarium.add(fish);
        String expected = "Fish available at name1: nemo";
        Assert.assertEquals(expected , aquarium.report());

    }
    @Test
    public void testForSellingFish(){
        aquarium = new Aquarium("name1", 1);
        Fish fish = new Fish("nemo");
        aquarium.add(fish);
        aquarium.sellFish("nemo");
        Assert.assertEquals("nemo" , fish.getName());

    }
    @Test (expected = IllegalArgumentException.class)
    public void testForSellingNonExistingFish(){
        aquarium = new Aquarium("name1", 1);
        Fish fish = new Fish("nemo");
        aquarium.add(fish);
        aquarium.sellFish("sharky");
        Assert.assertEquals("nemo" , fish.getName());

    }

}

