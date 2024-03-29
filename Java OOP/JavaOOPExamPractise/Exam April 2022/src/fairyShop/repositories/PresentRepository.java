package fairyShop.repositories;

import fairyShop.models.Present;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class PresentRepository implements Repository<Present> {

    private Collection<Present> presents;

    public PresentRepository() {
        this.presents = new LinkedHashSet<>();
    }

    @Override
    public Collection<Present> getModels() {
        return Collections.unmodifiableCollection(presents);
    }

    @Override
    public void add(Present model) {
        presents.add(model);
    }

    @Override
    public boolean remove(Present model) {
        return presents.remove(model);
    }

    @Override
    public Present findByName(String name) {
        return presents.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

}
