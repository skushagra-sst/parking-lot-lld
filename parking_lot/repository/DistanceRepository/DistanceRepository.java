package parking_lot.repository.DistanceRepository;

import java.util.HashMap;

import parking_lot.entities.Gate;
import parking_lot.entities.Spot;

public interface DistanceRepository {
    void addDistance(Gate g, Spot s, double distance);

    void addGate(Gate g);

    HashMap<Spot, Double> getSpots(Gate g);

    double getDistance(Gate g, Spot s);

}
