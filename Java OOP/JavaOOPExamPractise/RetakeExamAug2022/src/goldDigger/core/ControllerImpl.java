package goldDigger.core;

import goldDigger.common.DiscovererTypes;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{

    private Repository<Discoverer> discovererRepository;
    private Repository<Spot> spotRepository;

    public ControllerImpl() {
        discovererRepository = new DiscovererRepository();
        spotRepository = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        DiscovererTypes discovererType = DiscovererTypes.valueOf(kind);
        Discoverer discoverer = null;
        switch (discovererType) {
            case Anthropologist:
                discoverer = new Anthropologist(discovererName);
                break;
            case Archaeologist:
                discoverer = new Archaeologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        discovererRepository.add(discoverer);
        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }

        spotRepository.add(spot);
        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        for (Discoverer discoverer : discovererRepository.getCollection())  {
            if (discoverer.getName().equals(discovererName))    {
                discovererRepository.getCollection().remove(discoverer);
                return String.format(DISCOVERER_EXCLUDE, discovererName);
            }
        }
        throw new IllegalArgumentException(String.format(DISCOVERER_EXCLUDE, discovererName));
    }

    @Override
    public String inspectSpot(String spotName) {
        return null;
    }

    @Override
    public String getStatistics() {
        return null;
    }
}
