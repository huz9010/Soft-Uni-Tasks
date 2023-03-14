package goldDigger.models.discoverer;

import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

import java.util.stream.Collectors;

import static goldDigger.common.ExceptionMessages.*;

public abstract class BaseDiscoverer implements Discoverer {

    private String name;
    private double energy;
    private Museum museum;
    private static final int ENERGY_DECREASE_VALUE = 15;

    protected BaseDiscoverer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.museum = new BaseMuseum();
    }

    @Override
    public String toString()    {
        String exhibits;
        if (museum.getExhibits().isEmpty()) {
            exhibits = "None";
        }   else {
            exhibits = museum.getExhibits().stream().map(String::valueOf).collect(Collectors.joining(", "));
        }
        return String.format("Name: %s%n" +
                        "Energy: %.0f%n" +
                "Museum exhibits: %s%n", this.name, this.energy, exhibits);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public boolean canDig() {
        return energy > 0;
    }

    @Override
    public Museum getMuseum() {
        return museum;
    }

    @Override
    public void dig() {
        this.energy = Math.max(0, this.energy - ENERGY_DECREASE_VALUE);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
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
