package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.Collection;

public class OperationImpl implements Operation{


    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {

        Collection<String> exhibits = spot.getExhibits();

        for (Discoverer discoverer : discoverers) {

            while (spot.getExhibits().iterator().hasNext() && discoverer.canDig()) {
                discoverer.getMuseum().getExhibits().add(exhibits.iterator().next());
                discoverer.dig();
                exhibits.remove(exhibits.iterator().next());

            }
        }

    }
}
