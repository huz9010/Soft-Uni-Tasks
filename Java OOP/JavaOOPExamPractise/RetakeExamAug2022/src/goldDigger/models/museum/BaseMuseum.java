package goldDigger.models.museum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class BaseMuseum implements Museum {

    private Collection<String> exhibits;

    public BaseMuseum() {
        exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return Collections.unmodifiableCollection(this.exhibits);
    }
}
