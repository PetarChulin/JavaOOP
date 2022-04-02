package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GarageTests {

    private Car car;
    private Garage garage;
    private List<Car> cars;

    @Before
    public void setGarage() {
        this.garage = new Garage();
        this.cars = new ArrayList<>();
        Car audi = new Car("audi" , 250 , 30000);
        Car porsche = new Car("porsche" , 290 , 90000);
        Car mercedes = new Car("mercedes" , 250 , 100000);

        this.cars.add(audi);
        this.cars.add(porsche);
        this.cars.add(mercedes);

        garage.addCar(audi);
        garage.addCar(porsche);
        garage.addCar(mercedes);
    }

    @Test
    public void testForExistingCar() {

        Assert.assertEquals("audi" , this.garage.getCars().get(0).getBrand());
    }
    @Test
    public void testForGarageCountOfCars() {

        Assert.assertEquals(3 , garage.getCount());
    }
    @Test (expected = UnsupportedOperationException.class)
    public void testForUnmodifiableGarageElements () {

        garage.getCars().clear();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testForNullValueOfCar () {

       garage.addCar(null);
    }
    @Test
    public void testForCarBrand() {

        Assert.assertEquals(1 , garage.findAllCarsByBrand("audi").size());
    }

    @Test
    public void testForNumberOfCarsWithMaxSpeedAbove250() {

        Assert.assertEquals(1, this.garage.findAllCarsWithMaxSpeedAbove(250).size());
    }
    @Test
    public void testForMostExpensiveCar() {

        Assert.assertEquals(garage.getCars().get(2).getPrice() , this.garage.getTheMostExpensiveCar().getPrice() , 1);
    }

}