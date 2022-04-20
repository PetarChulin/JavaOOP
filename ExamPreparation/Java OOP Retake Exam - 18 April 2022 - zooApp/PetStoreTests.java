package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PetStoreTests {

    private List<Animal> animals;
    private PetStore store;

    @Before
    public void petStoreSet() {
        Animal lion = new Animal("Lion", 200, 3000.0);

        this.animals = new ArrayList<>();
        this.store = new PetStore();
        this.animals.add(lion);

        store.addAnimal(lion);
    }

    @Test
    public void testSetAge() {
        Animal elephant = new Animal("Elephant", 2000, 3500.0);
        elephant.setAge(20);
        Assert.assertEquals(20, elephant.getAge());
    }

    @Test
    public void testGetAnimalSpecie() {
        Assert.assertEquals("Lion", this.animals.get(0).getSpecie());
    }

    @Test
    public void testGetAnimalPrice() {
        Assert.assertEquals(3000.0, this.animals.get(0).getPrice(), 0.1);
    }

    @Test
    public void testGetAnimalMaxKilos() {
        Assert.assertEquals(200, this.animals.get(0).getMaxKilograms());
    }

    @Test
    public void testForListOfAnimalsInTheStore() {
        Assert.assertEquals(1, this.store.getCount());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testModifyCollectionOfAnimals() {
        this.store.getAnimals().clear();
    }

    @Test
    public void testFindAllAnimalsWithMaxKilograms() {

        Assert.assertEquals(0, this.store.findAllAnimalsWithMaxKilograms(200).size());
    }

    @Test
    public void testForAdditionOfAnimal() {

        Animal elephant = new Animal("Elephant", 2000, 3500.0);
        this.store.addAnimal(elephant);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForAdditionOfAnimalWithNullValue() {
        this.store.addAnimal(null);
    }

    @Test
    public void testForMostExpensiveAnimal() {

        Animal elephant = new Animal("Elephant", 2000, 3500.0);
        this.store.addAnimal(elephant);

        Assert.assertEquals(this.store.getAnimals().get(1).getPrice(),
                this.store.getTheMostExpensiveAnimal().getPrice(), 0.1);
    }

    @Test
    public void testFindAllAnimalBySpecie() {

        Assert.assertEquals(1, this.store.findAllAnimalBySpecie("Lion").size());

    }
}

