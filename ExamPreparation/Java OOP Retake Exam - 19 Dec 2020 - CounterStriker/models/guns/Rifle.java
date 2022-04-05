package viceCity.models.guns;

public class Rifle extends BaseGun{


        private static int BULLETS_PER_BARREL = 50;
        private static int TOTAL_BULLETS = 500;

        public Rifle(String name) {
            super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
        }

    @Override
    public int fire() {
        if (getTotalBullets() > 0 && getBulletsPerBarrel() == 0) {
            reload();
        }
        if (getBulletsPerBarrel() > 0) {
            setBulletsPerBarrel(getBulletsPerBarrel() - 5);
        }
        return 5;

    }
    public void reload() {
        setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);
        setBulletsPerBarrel(BULLETS_PER_BARREL);

    }

}
