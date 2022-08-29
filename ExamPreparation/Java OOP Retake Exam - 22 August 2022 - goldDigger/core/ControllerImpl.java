package goldDigger.core;

import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.List;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private final DiscovererRepository discoverers;
    private final SpotRepository spots;
    private BaseMuseum exhibits;

    public ControllerImpl() {

        discoverers = new DiscovererRepository();
        spots = new SpotRepository();
        exhibits = new BaseMuseum();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;
        switch (kind) {
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }
        discoverers.add(discoverer);

        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    int inspectedSpots = 0;

    @Override
    public String addSpot(String spotName, String... exhibits) {

        Spot spot = new SpotImpl(spotName);

        if (spotName == null || spotName.trim().isEmpty()) {
            throw new NullPointerException(SPOT_NAME_NULL_OR_EMPTY);
        } else {
            spots.add(spot);
            for (String exhibit : exhibits) {
                spot.getExhibits().add(exhibit);
            }


            return String.format(SPOT_ADDED, spotName);
        }

    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = discoverers.byName(discovererName);

        if (discoverer == null) {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        }
        discoverers.remove(discoverer);

        return String.format(DISCOVERER_EXCLUDE, discovererName);

    }

    @Override
    public String inspectSpot(String spotName) {

        Operation operation = new OperationImpl();

        List<Discoverer> suitableDiscoverers = discoverers.getCollection().stream().
                filter(d -> d.getEnergy() > 45).collect(Collectors.toList());

        if (suitableDiscoverers.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        operation.startOperation(this.spots.byName(spotName) , suitableDiscoverers);

        int excluded = 0;
        for (Discoverer suitableDiscoverer : suitableDiscoverers) {
            if (suitableDiscoverer.getEnergy() == 0) {
//                discoverers.remove(suitableDiscoverer);
                excluded++;
            }
        }
        inspectedSpots++;


        return String.format(INSPECT_SPOT, spotName, excluded);

    }

    @Override
    public String getStatistics() {
        StringBuilder build = new StringBuilder();

        build.append(String.format(FINAL_SPOT_INSPECT, inspectedSpots)).append(System.lineSeparator())
                .append(FINAL_DISCOVERER_INFO).append(System.lineSeparator());
        for (Discoverer discoverer : discoverers.getCollection()) {

            build.append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName())).append(System.lineSeparator());
            build.append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy())).append(System.lineSeparator());

            if (discoverer.getMuseum().getExhibits().isEmpty()) {
                build.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None")).append(System.lineSeparator());
            } else {
                build.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS,
                                String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, discoverer.getMuseum().getExhibits())))
                        .append(System.lineSeparator());
            }
        }
        return build.toString().trim();
    }
}
