package goldDigger.models.discoverer;

import goldDigger.models.museum.Museum;

import static goldDigger.common.ExceptionMessages.*;

public abstract class BaseDiscoverer implements Discoverer {

    private String name;
    private double energy;
    private Museum museum;
    private static final int ENERGY_DECREASE_VALUE = 15;

    protected BaseDiscoverer(String name, double energy) {
        setName(name);
        setEnergy(energy);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canDig() {
        return energy > 0;
    }

    @Override
    public Museum getMuseum() {
        return this.museum;
    }

    @Override
    public void dig() {
        energy -= ENERGY_DECREASE_VALUE;
        if (energy < 0) {
            energy = 0;
        }
    }

    private void setName(String name) {
        if (name.isEmpty() || name.equals(" ")) {
            throw new NullPointerException(DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }
}
