package viceCity.models.guns;

public class Pistol extends BaseGun{

    private static int BULLETS_PER_BARREL = 10;
    private static int TOTAL_BULLETS = 100;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (getTotalBullets() > 0 && getBulletsPerBarrel() == 0) {
            reload();
        }
        if (getBulletsPerBarrel() > 0) {
            setBulletsPerBarrel(getBulletsPerBarrel() - 1);
        }
        return 1;

    }
    public void reload() {
        setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);
        setBulletsPerBarrel(BULLETS_PER_BARREL);

    }
}
