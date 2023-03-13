package goldDigger.models.discoverer;

public class Archaeologist extends BaseDiscoverer {

    private static final int INITIAL_ENERGY_UNITS = 60;

    public Archaeologist(String name) {
        super(name, INITIAL_ENERGY_UNITS);
    }
}
