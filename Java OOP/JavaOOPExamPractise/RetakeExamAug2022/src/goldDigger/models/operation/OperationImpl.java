package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OperationImpl implements Operation {


    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        List<String> exhibits = new ArrayList<>(spot.getExhibits());
        List<Discoverer> discovererList = discoverers.stream().filter(Discoverer::canDig).collect(Collectors.toList());

        int i = 0;

        while (!exhibits.isEmpty() && (i < discovererList.size()))   {
            Discoverer discoverer = discovererList.get(i);
            while (discoverer.canDig()) {
                discoverer.dig();
                exhibits.remove(0);
            }
            i++;
        }
    }
}
