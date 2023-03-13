package goldDigger.repositories;

import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SpotRepository implements Repository<Spot> {

    private Collection<Spot> spots;

    public SpotRepository() {
        this.spots = new ArrayList<>();
    }

    @Override
    public Collection<Spot> getCollection() {
        return Collections.unmodifiableCollection(spots);
    }

    @Override
    public void add(Spot entity) {
        spots.add(entity);
    }

    @Override
    public boolean remove(Spot entity) {
        if (spots.contains(entity)) {
            remove(entity);
            return true;
        }
        return false;
    }

    @Override
    public Spot byName(String name) {
        return spots.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }
}
