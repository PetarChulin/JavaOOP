package goldDigger.models.discoverer;

import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;


import static goldDigger.common.ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO;
import static goldDigger.common.ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY;

public class BaseDiscoverer implements Discoverer {

    private final String name;
    private double energy;
    private final Museum museum;

    public BaseDiscoverer(String name, double energy) {
        this.name = name;
        setEnergy(energy);
        this.museum = new BaseMuseum();

    }

    public void setEnergy(double energy) {
        if (this.energy < 0) {
            throw new IllegalArgumentException(DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        if (this.name == null || this.name.trim().isEmpty()) {
            throw new NullPointerException(DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canDig() {
        return this.energy > 0;
    }

    @Override
    public Museum getMuseum() {
        return museum;
    }

    @Override
    public void dig() {
        this.energy = Math.max(0, this.energy - 15);
//        this.energy -= 15;
//        if (this.energy < 0) {
//            this.energy = 0;
//        }
    }
}
