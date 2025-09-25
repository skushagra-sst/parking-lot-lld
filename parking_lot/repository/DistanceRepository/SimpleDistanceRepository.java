package parking_lot.repository.DistanceRepository;

import java.util.HashMap;

import parking_lot.entities.Gate;
import parking_lot.entities.Spot;

public class SimpleDistanceRepository implements DistanceRepository {

    HashMap<Gate, HashMap<Spot, Double>> distanceMap;

    public SimpleDistanceRepository() {
        distanceMap = new HashMap<>();
    }

    @Override
    public void addGate(Gate g) {
        distanceMap.put(g, new HashMap<>());
    }

    @Override
    public void addDistance(Gate g, Spot s, double distance) {
        distanceMap.get(g).put(s, distance);
    }

    @Override
    public double getDistance(Gate g, Spot s) {
        return distanceMap.getOrDefault(g, new HashMap<>()).getOrDefault(s, Double.MAX_VALUE);
    }

    @Override
    public HashMap<Spot, Double> getSpots(Gate g) {
        return distanceMap.get(g);
    }

}
