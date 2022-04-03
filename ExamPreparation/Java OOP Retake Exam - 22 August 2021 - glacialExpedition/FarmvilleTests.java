package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FarmvilleTests {

    Farm farm;

    @Before
    public void setUp() {
        this.farm = new Farm("OldFarm", 2);

    }

    @Test
    public void testCountAnimalsInTheFarm() {

        int expected = 0;
        int current = farm.getCount();
        Assert.assertEquals(expected, current);

    }

    @Test
    public void testFarmName() {

        String expected = "OldFarm";
        String current = farm.getName();
        Assert.assertEquals(expected, current);
    }

    @Test
    public void testFarmCapacity() {

        int expected = 2;
        int current = farm.getCapacity();
        Assert.assertEquals(expected, current);
    }

    @Test
    public void testAnimalAddition() {

        Animal animal = new Animal("Sheep" , 20.00);
        farm.add(animal);
        int expected = 1;
        Assert.assertEquals(expected , farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckIfFullCapacityThrowException() {
        farm.add(new Animal("Cow" , 50));
        farm.add(new Animal("Goat" , 20));
        farm.add(new Animal("Chicken" , 10));

    }


    @Test
    public void testAnimalRemoval () {

        farm.remove("Sheep");
        int expected = 0;
        Assert.assertEquals(expected , farm.getCount());

    }

    @Test (expected = IllegalArgumentException.class)
    public void checkForExistingAnimal () {

        farm.add(new Animal("Cow" , 50));
        farm.add(new Animal("Cow" , 50));
    }

    @Test
    public void testForAnimalRemovalByTypeException() {

        farm.add(new Animal("Dog" , 25));
        boolean removed = farm.remove("Dog");
        assertTrue(removed);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testForCapacityExceeded() {

        new Farm("Farm" , -1);
        Assert.assertEquals(0 , farm.getCapacity());
    }

    @Test (expected = NullPointerException.class)
    public void TestForInvalidFarmNameInput() {

        new Farm(" " , 1);
        Assert.assertEquals(farm.getName() , this.farm.getName());

        new Farm("" , 1);
        Assert.assertEquals(farm.getName() , this.farm.getName());
    }


}
