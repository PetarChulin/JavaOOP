package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class PlayerTest {

    private Player player;
    private Gun gun;
    private Collection<Gun> guns;
    private static String USERNAME = "Mordor";
    private static int HEALTH = 100;

    @Before
    public void setPlayer() {
        this.player = new Player(USERNAME, HEALTH);
    }

    @Test
    public void getUsername() {
        Assert.assertEquals(USERNAME, this.player.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void setUsername() {
        new Player("", HEALTH);
        Assert.assertEquals(USERNAME, this.player.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void testUsernameIsEmpty() {
        new Player(" ", HEALTH);
        Assert.assertEquals(USERNAME, this.player.getUsername());
    }

    @Test
    public void getHealth() {
        Assert.assertEquals(HEALTH, this.player.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHealthIsZero() {
        new Player(USERNAME, -1);
        Assert.assertEquals(HEALTH, this.player.getHealth());
    }

    @Test (expected = UnsupportedOperationException.class)
    public void getGuns() {
        player.getGuns().clear();

    }

    @Test(expected = IllegalStateException.class)
    public void takeDamage() {

        player = new Player(USERNAME, 0);
        player.takeDamage(50);

    }

    @Test
    public void testSetHealthToZero() {
        player = new Player(USERNAME, 50);
        player.takeDamage(51);
    }

    @Test
    public void testHealthValueAfterTakeDamage() {

        player = new Player(USERNAME, 55);
        player.takeDamage(50);

    }


    @Test (expected = NullPointerException.class)
    public void addGunWithNullValueToPlayer() {
        player.addGun(null);
    }

    @Test
    public void addGunToPlayer() {
        gun = new Gun("Colt" , 20);
        player.addGun(gun);
    }

    @Test
    public void removeGun() {
        gun = new Gun("Colt" , 20);
        player.addGun(gun);
        player.removeGun(gun);
        Assert.assertEquals(0, player.getGuns().size());
    }

    @Test
    public void getGun() {
        String name = "Colt";
        gun = new Gun( name, 20);
        player.addGun(gun);
        player.getGun(name);
    }
    @Test
    public void testFindGunByNameThatExistFromCollection() {
        String name = "Colt";
        gun = new Gun( name, 20);
        player.addGun(gun);
        Gun existingGun = player.getGun(name);
        Assert.assertEquals(name, existingGun.getName());
//        Assert.assertNotNull(existingGun);
    }

}