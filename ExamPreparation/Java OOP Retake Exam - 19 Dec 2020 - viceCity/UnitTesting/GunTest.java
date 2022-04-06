package halfLife;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GunTest {

    private Gun gun;
    @Test
    public void getName() {

        gun = new Gun("Colt", 100);
        Assert.assertEquals(gun.getName() , this.gun.getName());

    }

    @Test
    public void getBullets() {
        gun = new Gun("Colt", 100);
        Assert.assertEquals(gun.getBullets() , this.gun.getBullets());
    }
}