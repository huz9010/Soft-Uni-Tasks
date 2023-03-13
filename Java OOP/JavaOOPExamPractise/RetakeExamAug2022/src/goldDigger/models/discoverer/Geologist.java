package goldDigger.models.discoverer;

public class Geologist extends BaseDiscoverer {

    private static final int INITIAL_ENERGY_UNITS = 100;

    public Geologist(String name) {
        super(name, INITIAL_ENERGY_UNITS);
    }
}
