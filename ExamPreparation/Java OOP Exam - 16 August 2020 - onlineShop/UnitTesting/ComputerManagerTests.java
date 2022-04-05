package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ComputerManagerTests {
    Computer computer;
    ComputerManager manager;
    List<Computer> computers;

    private static final String MANUFACTURER = "Dell";
    private static final String MODEL = "1555";

    @Before
    public void setComputerManager() {
        computer = new Computer(MANUFACTURER, MODEL, 1000.00);
        manager = new ComputerManager();
        manager.addComputer(computer);
        computers = new ArrayList<>();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getComputers() {

        manager.getComputers().clear();
        int count = manager.getCount();
        assertEquals(1, count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testComputerForNullValue() {
        manager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForAlreadyExistingComputer() {
        manager.addComputer(computer);

    }

    @Test
    public void getCount() {
        int count = manager.getCount();
        Assert.assertEquals(1, count);
    }

    @Test
    public void removeComputer() {
        manager.removeComputer(MANUFACTURER ,MODEL);
        Assert.assertEquals(0, manager.getCount());

    }
    @Test
    public void testShouldRemoveComputerFromTheManager() {

        Computer removed = manager.removeComputer(MANUFACTURER, MODEL);
        assertEquals(computer, removed);

        assertEquals(0, manager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testComputerForNonExistingManufacturerModel() {
        manager.getComputer("Lenovo", "ThinkPad");
    }

    @Test
    public void getComputersByManufacturer() {

        List<Computer> computersGetManufacturer = manager.getComputersByManufacturer(MANUFACTURER);
        assertEquals(computer, computersGetManufacturer.get(0));
    }


}